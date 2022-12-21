package cn.ld.app.rule.query;

import cn.ld.app.assembler.RuleAssembler;
import cn.ld.client.dto.query.RuleListQuery;
import cn.ld.client.dto.vo.RuleVO;
import cn.ld.domain.gateway.RuleGateWay;
import cn.ld.domain.rule.RuleEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 17:13
 */
@Component
@AllArgsConstructor
public class RuleListQueryCmdExe {

    private final RuleGateWay ruleGateWay;

    public IPage<RuleVO> execute(RuleListQuery query) {
        //// TODO: 2022/12/21 0021
        IPage<RuleEntity> page = ruleGateWay.page(query);
        return page.convert(RuleAssembler::toRuleVO);
    }
}
