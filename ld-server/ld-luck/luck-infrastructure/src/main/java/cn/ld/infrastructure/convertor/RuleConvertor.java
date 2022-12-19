package cn.ld.infrastructure.convertor;
import cn.ld.domain.rule.MinNumber;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.domain.rule.RuleEntity;
import cn.ld.infrastructure.database.dataObject.RuleDB;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 18:33
 */
public class RuleConvertor {
    public static RuleDB toRuleDB(RuleEntity entity) {
        RuleDB ruleDB = new RuleDB();
        if (ObjectUtil.isNotNull(entity.getId())){
            ruleDB.setId(entity.getId());
        }
        ruleDB.setRuleName(entity.getRuleName());
        ruleDB.setMaxJoinNumber(entity.getMaxJoinNumber().getNumber());
        ruleDB.setMaxWinningNumber(entity.getMaxWinningNumber().getNumber());
        ruleDB.setCreateTime(entity.getCreateTime());
        ruleDB.setCreator(entity.getCreator());
        ruleDB.setUpdateTime(entity.getUpdateTime());
        ruleDB.setUpdater(entity.getUpdater());
        return ruleDB;
    }

    public static RuleEntity toEntity(RuleDB ruleDB) {
        RuleEntity ruleEntity = new RuleEntity();
        ruleEntity.setId(ruleDB.getId());
        ruleEntity.setRuleName(ruleDB.getRuleName());
        ruleEntity.setMaxJoinNumber(new MinNumber(ruleDB.getMaxJoinNumber()));
        ruleEntity.setMaxWinningNumber(new MinNumber(ruleDB.getMaxWinningNumber()));
        ruleEntity.setCreateTime(ruleDB.getCreateTime());
        ruleEntity.setCreator(ruleDB.getCreator());
        ruleEntity.setUpdateTime(ruleDB.getUpdateTime());
        ruleEntity.setUpdater(ruleDB.getUpdater());
        return ruleEntity;
    }
}
