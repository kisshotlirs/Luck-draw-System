package cn.ld.domain.gateway;

import cn.ld.client.dto.query.PrizeListQuery;
import cn.ld.client.dto.query.RuleListQuery;
import cn.ld.domain.rule.RuleEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 17:35
 */
public interface RuleGateWay {

    RuleEntity save(RuleEntity entity);

    IPage<RuleEntity> page(RuleListQuery query);
}
