package cn.ld.app.assembler;
import java.time.LocalDateTime;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.config.util.SecurityUtil;
import cn.ld.domain.activity.ActivityTime;

import cn.ld.client.dto.cmd.ActivityAddCmd;
import cn.ld.client.dto.cmd.ActivityUpdateCmd;
import cn.ld.client.dto.vo.ActivityVO;
import cn.ld.domain.activity.ActivityEntity;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 17:06
 */
public class ActivityAssembler {
    public static ActivityEntity toAddEntity(ActivityAddCmd cmd) {
        ActivityEntity entity = new ActivityEntity();
        entity.setActivityName(cmd.getActivityName());
        entity.setActivityTime(new ActivityTime(cmd.getStartTime(),cmd.getEndTime()));
        entity.setDescribe(cmd.getDescribe());
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreator(SecurityUtil.getName());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdater(SecurityUtil.getName());
        return entity;
    }

    public static ActivityVO toActivityVO(ActivityEntity entity) {
        ActivityVO activityVO = new ActivityVO();
        if (ObjectUtil.isNotNull(entity.getId())){
            activityVO.setId(entity.getId());
        }
        activityVO.setActivityName(entity.getActivityName());
        activityVO.setStartTime(entity.getActivityTime().getStartTime());
        activityVO.setEndTime(entity.getActivityTime().getEndTime());
        activityVO.setDescribe(entity.getDescribe());
        activityVO.setCreateTime(entity.getCreateTime());
        activityVO.setCreator(entity.getCreator());
        activityVO.setUpdateTime(entity.getUpdateTime());
        activityVO.setUpdater(entity.getUpdater());
        return activityVO;
    }

    public static ActivityEntity toUpdateEntity(ActivityUpdateCmd cmd) {
        ActivityEntity entity = new ActivityEntity();
        entity.setId(cmd.getId());
        entity.setActivityName(cmd.getActivityName());
        entity.setActivityTime(new ActivityTime(cmd.getStartTime(),cmd.getEndTime()));
        entity.setDescribe(cmd.getDescribe());
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreator(SecurityUtil.getName());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdater(SecurityUtil.getName());
        return entity;
    }
}
