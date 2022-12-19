package cn.ld.app.assembler;
import java.time.LocalDateTime;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.client.dto.cmd.AwardUpdateCmd;
import cn.ld.config.util.SecurityUtil;
import cn.ld.domain.award.AwardNumber;

import cn.ld.client.dto.cmd.AwardAddCmd;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.domain.award.AwardEntity;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 19:51
 */
public class AwardAssembler {
    public static AwardEntity toAddEntity(AwardAddCmd cmd) {
        AwardEntity entity = new AwardEntity();
        entity.setPrizeId(cmd.getPrizeId());
        entity.setNumber(new AwardNumber(cmd.getNumber()));
        entity.setAwardName(cmd.getAwardName());
        entity.setProbability(cmd.getProbability());
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreator(SecurityUtil.getName());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdater(SecurityUtil.getName());
        return entity;
    }

    public static AwardVO toAwardVO(AwardEntity entity) {
        AwardVO awardVO = new AwardVO();
        if (ObjectUtil.isNotNull(entity.getId())){
            awardVO.setId(entity.getId());
        }
        awardVO.setPrizeId(entity.getPrizeId());
        awardVO.setNumber(entity.getNumber().getNumber());
        awardVO.setAwardName(entity.getAwardName());
        awardVO.setProbability(entity.getProbability());
        awardVO.setCreateTime(entity.getCreateTime());
        awardVO.setCreator(entity.getCreator());
        awardVO.setUpdateTime(entity.getUpdateTime());
        awardVO.setUpdater(entity.getUpdater());
        return awardVO;
    }

    public static AwardEntity toUpdateEntity(AwardUpdateCmd cmd) {
        AwardEntity entity = new AwardEntity();
        entity.setId(cmd.getId());
        entity.setPrizeId(cmd.getPrizeId());
        entity.setNumber(new AwardNumber(cmd.getNumber()));
        entity.setAwardName(cmd.getAwardName());
        entity.setProbability(cmd.getProbability());
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreator(SecurityUtil.getName());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdater(SecurityUtil.getName());
        return entity;
    }
}
