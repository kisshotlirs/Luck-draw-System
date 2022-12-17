package cn.ld.infrastructure.gatewayImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.client.dto.query.RuleListQuery;
import cn.ld.config.exception.ldException;
import cn.ld.domain.gateway.RuleGateWay;
import cn.ld.domain.rule.RuleEntity;
import cn.ld.infrastructure.convertor.RuleConvertor;
import cn.ld.infrastructure.database.dataObject.RuleDB;
import cn.ld.infrastructure.database.dataObject.UserDB;
import cn.ld.infrastructure.database.mapper.RuleMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 18:23
 */
@Component
@AllArgsConstructor
public class RuleGateWayImpl implements RuleGateWay {

    private final RuleMapper ruleMapper;

    @Override
    public RuleEntity save(RuleEntity entity) {
        if (ObjectUtil.isNull(entity.getId())){
            return addRule(entity);
        }
        return updateRule(entity);
    }

    private RuleEntity addRule(RuleEntity entity) {
        RuleDB ruleDB = RuleConvertor.toRuleDB(entity);
        int result = ruleMapper.insert(ruleDB);
        if (result!=1){
            throw new ldException("新建抽奖规则失败");
        }
        return RuleConvertor.toEntity(ruleDB);
    }

    private RuleEntity updateRule(RuleEntity entity) {
        RuleDB ruleDB = RuleConvertor.toRuleDB(entity);
        int result = ruleMapper.updateById(ruleDB);
        if (result!=1){
            throw new ldException("更新抽奖规则失败");
        }
        return RuleConvertor.toEntity(ruleDB);
    }

    @Override
    public IPage<RuleEntity> page(RuleListQuery query) {
        IPage<RuleDB> page = ruleMapper.page(new Page<RuleDB>(query.getPageIndex(), query.getPageSize()),query);
        return page.convert(RuleConvertor::toEntity);
    }
}
