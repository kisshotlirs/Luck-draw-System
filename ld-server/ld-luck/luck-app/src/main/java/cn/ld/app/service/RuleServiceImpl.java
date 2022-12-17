package cn.ld.app.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.app.rule.cmd.RuleAddCmdExe;
import cn.ld.app.rule.cmd.RuleUpdateCmdExe;
import cn.ld.app.rule.query.RuleListQueryCmdExe;
import cn.ld.client.api.RuleService;
import cn.ld.client.dto.cmd.RuleAddCmd;
import cn.ld.client.dto.cmd.RuleUpdateCmd;
import cn.ld.client.dto.query.RuleListQuery;
import cn.ld.client.dto.vo.RuleVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 17:02
 */
@Service
@AllArgsConstructor
public class RuleServiceImpl implements RuleService {

    private final RuleAddCmdExe ruleAddCmdExe;
    private final RuleUpdateCmdExe ruleUpdateCmdExe;
    private final RuleListQueryCmdExe ruleListQueryCmdExe;

    @Override
    public RuleVO ruleAdd(RuleAddCmd cmd) {
        return ruleAddCmdExe.execute(cmd);
    }

    @Override
    public RuleVO ruleUpdate(RuleUpdateCmd cmd) {
        return ruleUpdateCmdExe.execute(cmd);
    }

    @Override
    public IPage<RuleVO> page(RuleListQuery query) {
        return ruleListQueryCmdExe.page(query);
    }

    @Override
    public RuleVO getOne(Long id) {
        RuleListQuery query = new RuleListQuery();
        query.setId(id);
        IPage<RuleVO> page = page(query);
        if (CollectionUtil.isEmpty(page.getRecords())){
            return null;
        }
        return page.getRecords().get(0);
    }
}
