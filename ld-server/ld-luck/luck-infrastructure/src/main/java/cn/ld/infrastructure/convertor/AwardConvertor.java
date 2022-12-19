package cn.ld.infrastructure.convertor;
import cn.hutool.core.util.ObjectUtil;
import cn.ld.domain.award.AwardNumber;
import java.time.LocalDateTime;

import cn.ld.domain.award.AwardEntity;
import cn.ld.infrastructure.database.dataObject.AwardDB;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 22:26
 */
public class AwardConvertor {
    public static AwardDB toAddDB(AwardEntity entity) {
        AwardDB awardDB = new AwardDB();
        awardDB.setPrizeId(entity.getPrizeId());
        awardDB.setNumber(entity.getNumber().getNumber());
        awardDB.setAwardName(entity.getAwardName());
        awardDB.setProbability(entity.getProbability());
        awardDB.setCreateTime(entity.getCreateTime());
        awardDB.setCreator(entity.getCreator());
        awardDB.setUpdateTime(entity.getUpdateTime());
        awardDB.setUpdater(entity.getUpdater());
        return awardDB;
    }

    public static AwardEntity toEntity(AwardDB awardDB) {
        AwardEntity entity = new AwardEntity();
        if (ObjectUtil.isNotNull(awardDB.getId())){
            entity.setId(awardDB.getId());
        }
        entity.setPrizeId(awardDB.getPrizeId());
        entity.setNumber(new AwardNumber(awardDB.getNumber()));
        entity.setAwardName(awardDB.getAwardName());
        entity.setProbability(awardDB.getProbability());
        entity.setCreateTime(awardDB.getCreateTime());
        entity.setCreator(awardDB.getCreator());
        entity.setUpdateTime(awardDB.getUpdateTime());
        entity.setUpdater(awardDB.getUpdater());
        return entity;
    }

    public static AwardDB toUpdateDB(AwardEntity entity) {
        AwardDB awardDB = new AwardDB();
        awardDB.setId(entity.getId());
        awardDB.setPrizeId(entity.getPrizeId());
        awardDB.setNumber(entity.getNumber().getNumber());
        awardDB.setAwardName(entity.getAwardName());
        awardDB.setProbability(entity.getProbability());
        awardDB.setCreateTime(entity.getCreateTime());
        awardDB.setCreator(entity.getCreator());
        awardDB.setUpdateTime(entity.getUpdateTime());
        awardDB.setUpdater(entity.getUpdater());
        return awardDB;
    }
}
