package cn.ld.app.assembler;
import cn.ld.client.dto.vo.RecordVO;
import cn.ld.config.util.SecurityUtil;
import cn.ld.domain.record.RecordStatus;
import java.time.LocalDateTime;

import cn.ld.client.dto.cmd.RecordAddCmd;
import cn.ld.domain.record.RecordEntity;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/30 0030 11:34
 */
public class RecordAssembler {

    public static RecordEntity toAddEntity(RecordAddCmd cmd) {
        RecordEntity entity = new RecordEntity();
        entity.setUserId(cmd.getUserId());
        entity.setActivityId(cmd.getActivityId());
        entity.setActivityName(cmd.getActivityName());
        entity.setAwardId(cmd.getAwardId());
        entity.setIsWinning(cmd.getIsWinning());
        entity.setState(new RecordStatus(cmd.getState()));
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreator(SecurityUtil.getName());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdater(SecurityUtil.getName());
        return entity;
    }

    public static RecordVO toVO(RecordEntity entity) {
        RecordVO recordVO = new RecordVO();
        recordVO.setId(entity.getId());
        recordVO.setUserId(entity.getUserId());
        recordVO.setActivityId(entity.getActivityId());
        recordVO.setActivityName(entity.getActivityName());
        recordVO.setAwardId(entity.getAwardId());
        recordVO.setPrizeName(entity.getPrizeName());
        recordVO.setAwardName(entity.getAwardName());
        recordVO.setIsWinning(entity.getIsWinning());
        recordVO.setState(entity.getState().getState().getValue());
        recordVO.setCreateTime(entity.getCreateTime());
        recordVO.setCreator(entity.getCreator());
        recordVO.setUpdateTime(entity.getUpdateTime());
        recordVO.setUpdater(entity.getUpdater());
        return recordVO;
    }
}
