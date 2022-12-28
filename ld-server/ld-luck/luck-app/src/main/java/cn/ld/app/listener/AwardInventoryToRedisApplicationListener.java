package cn.ld.app.listener;

import cn.ld.app.assembler.AwardAssembler;
import cn.ld.app.listener.event.ActivityCreateEvent;
import cn.ld.client.dto.vo.ActivityConfigVO;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.domain.award.AwardEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: 添加奖项库存时，将奖项库存放入redis
 * @date 2022/12/27 0027 21:55
 */
@Slf4j
@Component
@AllArgsConstructor
public class AwardInventoryToRedisApplicationListener implements ApplicationListener<ActivityCreateEvent> {

    private final RedisTemplate<String,Object> redisTemplate;

    /**
     * lucky-draw:activity:award:活动id:奖项id
     */
    public static final String AWARD_INVENTORY_KEY = "lucky-draw:activity:award:";

    @Override
    public void onApplicationEvent(ActivityCreateEvent event) {
        log.info("ActivityCreateEvent 执行。。。。。。。。");

        ActivityConfigVO activityConfigVO = event.getActivityConfigVO();
        for (AwardVO awardVO : activityConfigVO.getAwardVOList()) {
            AwardEntity awardEntity = AwardAssembler.toAwardEntity(awardVO);
            if (!awardEntity.isPrize()){
                //不是奖项，跳过
                continue;
            }
            redisTemplate.opsForValue().set(getKey(activityConfigVO.getActivityVO().getId(),awardVO.getId()),awardVO.getNumber());
        }
    }

    public static String getKey(Long activityId, Long awardId) {
        return AWARD_INVENTORY_KEY+activityId+":"+awardId;
    }
}
