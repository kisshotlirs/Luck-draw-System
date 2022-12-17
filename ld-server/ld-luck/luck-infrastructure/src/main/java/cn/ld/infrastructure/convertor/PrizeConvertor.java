package cn.ld.infrastructure.convertor;
import cn.hutool.core.util.ObjectUtil;
import cn.ld.domain.prize.Inventory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import cn.ld.domain.prize.PrizeEntity;
import cn.ld.infrastructure.database.dataObject.PrizeDB;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 12:02
 */
public class PrizeConvertor {

    public static PrizeDB toPrizeDB(PrizeEntity entity) {
        PrizeDB prizeDB = new PrizeDB();
        if (!Objects.isNull(entity.getId())){
            prizeDB.setId(entity.getId());
        }
        prizeDB.setPrizeName(entity.getPrizeName());
        prizeDB.setInventory(entity.getInventory().getInventory());
        prizeDB.setMoney(new BigDecimal(String.valueOf(entity.getMoney())));
        prizeDB.setType(entity.getType());
        prizeDB.setCreateTime(entity.getCreateTime());
        prizeDB.setCreator(entity.getCreator());
        prizeDB.setUpdateTime(entity.getUpdateTime());
        prizeDB.setUpdater(entity.getUpdater());
        return prizeDB;
    }

    public static PrizeEntity toPrizeEntity(PrizeDB prizeDB) {
        PrizeEntity prizeEntity = new PrizeEntity();
        if (ObjectUtil.isNotNull(prizeDB.getId())){
            prizeEntity.setId(prizeDB.getId());
        }
        prizeEntity.setPrizeName(prizeDB.getPrizeName());
        prizeEntity.setInventory(new Inventory(prizeDB.getInventory()));
        prizeEntity.setMoney(new BigDecimal(String.valueOf(prizeDB.getMoney())));
        prizeEntity.setType(prizeDB.getType());
        prizeEntity.setCreateTime(prizeDB.getCreateTime());
        prizeEntity.setCreator(prizeDB.getCreator());
        prizeEntity.setUpdateTime(prizeDB.getUpdateTime());
        prizeEntity.setUpdater(prizeDB.getUpdater());
        return prizeEntity;
    }
}
