package cn.ld.app.assembler;
import cn.hutool.core.util.ObjectUtil;
import cn.ld.client.dto.cmd.RuleUpdateCmd;
import cn.ld.config.util.SecurityUtil;
import cn.ld.domain.rule.MaxNumber;
import java.time.LocalDateTime;

import cn.ld.client.dto.cmd.RuleAddCmd;
import cn.ld.client.dto.vo.RuleVO;
import cn.ld.domain.rule.RuleEntity;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 17:40
 */
public class RuleAssembler {

    public static RuleEntity toAddEntity(RuleAddCmd cmd) {
        RuleEntity ruleEntity = new RuleEntity();
        ruleEntity.setRuleName(cmd.getRuleName());
        ruleEntity.setMaxJoinNumber(new MaxNumber(cmd.getMaxJoinNumber()));
        ruleEntity.setMaxWinningNumber(new MaxNumber(cmd.getMaxWinningNumber()));
        ruleEntity.setCreateTime(LocalDateTime.now());
        ruleEntity.setCreator(SecurityUtil.getName());
        ruleEntity.setUpdateTime(LocalDateTime.now());
        ruleEntity.setUpdater(SecurityUtil.getName());
        return ruleEntity;
    }

    public static RuleVO toRuleVO(RuleEntity ruleEntity) {
        RuleVO ruleVO = new RuleVO();
        ruleVO.setId(ruleVO.getId());
        ruleVO.setRuleName(ruleEntity.getRuleName());
        ruleVO.setMaxJoinNumber(ruleEntity.getMaxJoinNumber().getNumber());
        ruleVO.setMaxWinningNumber(ruleEntity.getMaxWinningNumber().getNumber());
        ruleVO.setCreateTime(ruleEntity.getCreateTime());
        ruleVO.setCreator(ruleEntity.getCreator());
        ruleVO.setUpdateTime(LocalDateTime.now());
        ruleVO.setUpdater(ruleEntity.getUpdater());
        return ruleVO;
    }

    public static RuleEntity toUpdateEntity(RuleUpdateCmd cmd) {
        RuleEntity ruleEntity = new RuleEntity();
        ruleEntity.setId(cmd.getId());
        ruleEntity.setRuleName(cmd.getRuleName());
        ruleEntity.setMaxJoinNumber(new MaxNumber(cmd.getMaxJoinNumber()));
        ruleEntity.setMaxWinningNumber(new MaxNumber(cmd.getMaxWinningNumber()));
        ruleEntity.setCreateTime(LocalDateTime.now());
        ruleEntity.setCreator(SecurityUtil.getName());
        ruleEntity.setUpdateTime(LocalDateTime.now());
        ruleEntity.setUpdater(SecurityUtil.getName());
        return ruleEntity;
    }
}
