package cn.ld.infrastructure.convertor;
import java.time.LocalDateTime;

import cn.ld.domain.acceptPrize.AcceptPrizeEntity;
import cn.ld.infrastructure.database.dataObject.AcceptPrizeDB;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:17
 */
public class AcceptPrizeConvertor {
    public static AcceptPrizeDB toAcceptPrizeDB(AcceptPrizeEntity entity) {
        AcceptPrizeDB acceptPrizeDB = new AcceptPrizeDB();
        acceptPrizeDB.setId(entity.getId());
        acceptPrizeDB.setRecordId(entity.getRecordId());
        acceptPrizeDB.setPhone(entity.getPhone());
        acceptPrizeDB.setAddress(entity.getAddress());
        acceptPrizeDB.setCreateTime(entity.getCreateTime());
        acceptPrizeDB.setCreator(entity.getCreator());
        acceptPrizeDB.setUpdateTime(entity.getUpdateTime());
        acceptPrizeDB.setUpdater(entity.getUpdater());
        return acceptPrizeDB;
    }

    public static AcceptPrizeEntity toEntity(AcceptPrizeDB acceptPrizeDB) {
        AcceptPrizeEntity entity = new AcceptPrizeEntity();
        entity.setId(acceptPrizeDB.getId());
        entity.setRecordId(acceptPrizeDB.getRecordId());
        entity.setPhone(acceptPrizeDB.getPhone());
        entity.setAddress(acceptPrizeDB.getAddress());
        entity.setCreateTime(acceptPrizeDB.getCreateTime());
        entity.setCreator(acceptPrizeDB.getCreator());
        entity.setUpdateTime(acceptPrizeDB.getUpdateTime());
        entity.setUpdater(acceptPrizeDB.getUpdater());
        return entity;
    }
}
