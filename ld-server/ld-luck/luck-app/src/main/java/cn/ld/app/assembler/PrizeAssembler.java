package cn.ld.app.assembler;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.config.util.SecurityUtil;
import cn.ld.domain.prize.Inventory;

import cn.ld.client.dto.cmd.PrizeAddCmd;
import cn.ld.client.dto.cmd.PrizeUpdateCmd;
import cn.ld.client.dto.vo.PrizeVO;
import cn.ld.domain.prize.PrizeEntity;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 11:10
 */
public class PrizeAssembler {
    public static PrizeEntity toAddEntity(PrizeAddCmd cmd) {
        PrizeEntity prizeEntity = new PrizeEntity();
        prizeEntity.setPrizeName(cmd.getPrizeName());
        prizeEntity.setInventory(new Inventory(cmd.getInventory()));
        prizeEntity.setMoney(new BigDecimal(cmd.getMoney().toString()));
        prizeEntity.setType(cmd.getType());
        prizeEntity.setCreateTime(LocalDateTime.now());
        prizeEntity.setCreator(SecurityUtil.getName());
        prizeEntity.setUpdateTime(LocalDateTime.now());
        prizeEntity.setUpdater(SecurityUtil.getName());
        return prizeEntity;
    }

    public static PrizeVO toPrizeVO(PrizeEntity prizeEntity) {
        PrizeVO prizeVO = new PrizeVO();
        if (ObjectUtil.isNotNull(prizeEntity.getId())){
            prizeEntity.setId(prizeEntity.getId());
        }
        prizeVO.setPrizeName(prizeEntity.getPrizeName());
        prizeVO.setInventory(prizeEntity.getInventory().getInventory());
        prizeVO.setMoney(new BigDecimal(String.valueOf(prizeEntity.getMoney())));
        prizeVO.setType(prizeEntity.getType());
        prizeVO.setCreateTime(prizeEntity.getCreateTime());
        prizeVO.setCreator(prizeEntity.getCreator());
        prizeVO.setUpdateTime(prizeEntity.getUpdateTime());
        prizeVO.setUpdater(prizeEntity.getUpdater());
        return prizeVO;
    }

    public static PrizeEntity toUpdateEntity(PrizeUpdateCmd cmd) {
        PrizeEntity prizeEntity = new PrizeEntity();
        prizeEntity.setId(cmd.getId());
        prizeEntity.setPrizeName(cmd.getPrizeName());
        prizeEntity.setInventory(new Inventory(cmd.getInventory()));
        prizeEntity.setMoney(new BigDecimal(cmd.getMoney().toString()));
        prizeEntity.setType(cmd.getType());
        prizeEntity.setCreateTime(LocalDateTime.now());
        prizeEntity.setCreator(SecurityUtil.getName());
        prizeEntity.setUpdateTime(LocalDateTime.now());
        prizeEntity.setUpdater(SecurityUtil.getName());
        return prizeEntity;
    }
}
