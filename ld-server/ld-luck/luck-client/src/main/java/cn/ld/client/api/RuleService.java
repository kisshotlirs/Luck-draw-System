package cn.ld.client.api;

import cn.ld.client.dto.cmd.RuleAddCmd;
import cn.ld.client.dto.cmd.RuleUpdateCmd;
import cn.ld.client.dto.query.RuleListQuery;
import cn.ld.client.dto.vo.RuleVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 16:53
 */
@Service
public interface RuleService {

    RuleVO ruleAdd(RuleAddCmd cmd);

    RuleVO ruleUpdate(RuleUpdateCmd cmd);

    IPage<RuleVO> page(RuleListQuery query);

    RuleVO getOne(Long id);
}
