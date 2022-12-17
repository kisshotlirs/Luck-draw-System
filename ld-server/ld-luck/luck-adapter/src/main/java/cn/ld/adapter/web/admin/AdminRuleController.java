package cn.ld.adapter.web.admin;

import cn.ld.client.api.RuleService;
import cn.ld.client.dto.cmd.RuleAddCmd;
import cn.ld.client.dto.cmd.RuleUpdateCmd;
import cn.ld.client.dto.query.RuleListQuery;
import cn.ld.client.dto.vo.RuleVO;
import cn.ld.common.annotation.ResponseResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 21:03
 */
@AllArgsConstructor
@ResponseResult
@RestController("/admin/v1/rule")
public class AdminRuleController {

    private final RuleService ruleService;

    @PostMapping("/add")
    public RuleVO addRule(@RequestBody @Validated RuleAddCmd cmd){
        return ruleService.ruleAdd(cmd);
    }

    @PostMapping("/update")
    public RuleVO updateRule(@RequestBody @Validated RuleUpdateCmd cmd){
        return ruleService.ruleUpdate(cmd);
    }

    @PostMapping("/page")
    public IPage<RuleVO> page(@RequestBody @Validated RuleListQuery query){
        return ruleService.page(query);
    }

    @GetMapping("/{id}")
    public RuleVO getOne(@PathVariable("id") Long id){
        return ruleService.getOne(id);
    }
}
