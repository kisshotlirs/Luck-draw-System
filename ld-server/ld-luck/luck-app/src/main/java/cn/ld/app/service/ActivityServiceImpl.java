package cn.ld.app.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.app.activity.cmd.ActivityAddCmdExe;
import cn.ld.app.activity.cmd.ActivityUpdateCmdExe;
import cn.ld.app.activity.cmd.BaseDrawExe;
import cn.ld.app.activity.query.ActivityListQueryExe;
import cn.ld.client.api.ActivityConfigService;
import cn.ld.client.api.ActivityService;
import cn.ld.client.dto.cmd.ActivityAddCmd;
import cn.ld.client.dto.cmd.ActivityUpdateCmd;
import cn.ld.client.dto.query.ActivityListQuery;
import cn.ld.client.dto.vo.ActivityConfigVO;
import cn.ld.client.dto.vo.ActivityVO;
import cn.ld.client.dto.vo.DrawResultVO;
import cn.ld.config.util.SecurityUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 16:06
 */
@Slf4j
@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityAddCmdExe activityAddCmdExe;
    private final ActivityUpdateCmdExe activityUpdateCmdExe;
    private final ActivityListQueryExe activityListQueryExe;

    private final BaseDrawExe drawExe;
    private final ActivityConfigService activityConfigService;

    @Override
    public ActivityVO addActivity(ActivityAddCmd cmd) {
        return activityAddCmdExe.execute(cmd);
    }

    @Override
    public ActivityVO updateActivity(ActivityUpdateCmd cmd) {
        return activityUpdateCmdExe.execute(cmd);
    }

    @Override
    public IPage<ActivityVO> page(ActivityListQuery query) {
        return activityListQueryExe.execute(query);
    }

    @Override
    public ActivityVO getOne(Long id) {
        ActivityListQuery query = new ActivityListQuery();
        query.setId(id);
        IPage<ActivityVO> page = page(query);
        if (CollectionUtil.isEmpty(page.getRecords())){
            return null;
        }
        return page.getRecords().get(0);
    }

    @Override
    public DrawResultVO draw(Long activityId) {
        log.info("用户：{} ，开始抽奖。。。。。。", SecurityUtil.getName());
        //获取活动配置
        ActivityConfigVO activityConfigVO = activityConfigService.getOne(activityId);
        return drawExe.execute(activityConfigVO);
    }
}
