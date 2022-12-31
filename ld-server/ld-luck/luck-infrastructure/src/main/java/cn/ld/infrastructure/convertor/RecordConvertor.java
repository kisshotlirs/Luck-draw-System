package cn.ld.infrastructure.convertor;
import cn.ld.domain.record.RecordStatus;
import java.time.LocalDateTime;

import cn.ld.domain.record.RecordEntity;
import cn.ld.infrastructure.database.dataObject.RecordDB;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/29 0029 21:34
 */
public class RecordConvertor {

    public static RecordDB toRecordDB(RecordEntity entity) {
        RecordDB recordDB = new RecordDB();
        recordDB.setId(entity.getId());
        recordDB.setUserId(entity.getUserId());
        recordDB.setActivityId(entity.getActivityId());
        recordDB.setActivityName(entity.getActivityName());
        recordDB.setAwardId(entity.getAwardId());
        recordDB.setAwardName(entity.getAwardName());
        recordDB.setPrizeName(entity.getPrizeName());
        recordDB.setIsWinning(entity.getIsWinning());
        recordDB.setState(entity.getState().getState().getValue());
        recordDB.setCreateTime(entity.getCreateTime());
        recordDB.setCreator(entity.getCreator());
        recordDB.setUpdateTime(entity.getUpdateTime());
        recordDB.setUpdater(entity.getUpdater());
        return recordDB;
    }

    public static RecordEntity toEntity(RecordDB recordDB) {
        RecordEntity entity = new RecordEntity();
        entity.setId(recordDB.getId());
        entity.setUserId(recordDB.getUserId());
        entity.setActivityId(recordDB.getActivityId());
        entity.setActivityName(recordDB.getActivityName());
        entity.setAwardId(recordDB.getAwardId());
        entity.setAwardName(recordDB.getAwardName());
        entity.setPrizeName(recordDB.getPrizeName());
        entity.setIsWinning(recordDB.getIsWinning());
        entity.setState(new RecordStatus(recordDB.getState()));
        entity.setCreateTime(recordDB.getCreateTime());
        entity.setCreator(recordDB.getCreator());
        entity.setUpdateTime(recordDB.getUpdateTime());
        entity.setUpdater(recordDB.getUpdater());
        return entity;
    }
}
