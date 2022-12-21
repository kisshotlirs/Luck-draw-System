package cn.ld.app.activityRule.query;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.app.assembler.ActivityRuleAssembler;
import cn.ld.client.dto.query.ActivityRuleListQuery;
import cn.ld.client.dto.vo.ActivityRuleVO;
import cn.ld.domain.activityRule.ActivityRuleEntity;
import cn.ld.domain.gateway.ActivityRuleGateWay;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 17:49
 */
@Component
@AllArgsConstructor
public class ActivityRuleListQueryExe {

    private final ActivityRuleGateWay activityRuleGateWay;

    public List<ActivityRuleVO> execute(ActivityRuleListQuery query) {
        List<ActivityRuleEntity> list = activityRuleGateWay.list(query);
        if (CollectionUtil.isEmpty(list)){
            return new ArrayList<>();
        }
        List<ActivityRuleVO> ruleVOS = new Page<ActivityRuleEntity>()
                .setRecords(list)
                .convert(ActivityRuleAssembler::toVo)
                .getRecords();
        return ruleVOS;
    }
}
