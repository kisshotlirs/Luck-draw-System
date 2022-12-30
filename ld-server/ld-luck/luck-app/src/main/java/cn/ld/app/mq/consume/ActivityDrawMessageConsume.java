package cn.ld.app.mq.consume;

import cn.ld.app.activity.cmd.RedisDeductionAwardNumberDrawExe;
import cn.ld.app.context.ActivityDrawContext;
import cn.ld.config.dto.ActivityDrawMessage;
import cn.ld.config.util.AssertUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: 消息消费者
 * @date 2022/12/29 0029 14:08
 */
@Slf4j
@Component
@AllArgsConstructor
@RocketMQMessageListener(topic = "activity-draw-topic",consumerGroup = "lucky-draw")
public class ActivityDrawMessageConsume implements RocketMQListener<ActivityDrawMessage> {

    private final RedisDeductionAwardNumberDrawExe drawExe;

    @Override
    public void onMessage(ActivityDrawMessage activityDrawMessage) {
        log.info("接收到MQ消息了...,{}", JSON.toJSONString(activityDrawMessage));

        String body = activityDrawMessage.getBody();
        ActivityDrawContext context = JSONObject.parseObject(body, ActivityDrawContext.class);

        //扣减库存 修改中奖记录状态
        Boolean result = drawExe.mqDeductionOfInventoryAndUpdateRecordStatus(context);
        if (Boolean.FALSE.equals(result)){
            AssertUtil.isTrue(true,"执行消费MQ逻辑失败（扣减库存和修改不可见记录）");
        }
    }
}
