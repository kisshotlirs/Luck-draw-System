package cn.ld.adapter.web.admin;

import cn.ld.client.api.ActivityConfigService;
import cn.ld.client.dto.cmd.ActivityConfigAddCmd;
import cn.ld.client.dto.cmd.ActivityConfigUpdateCmd;
import cn.ld.client.dto.vo.ActivityConfigCopyVO;
import cn.ld.client.dto.vo.ActivityConfigVO;
import cn.ld.common.annotation.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author mojo
 * @description: 抽奖活动配置
 * @date 2022/12/22 0022 16:39
 */
@AllArgsConstructor
@ResponseResult
@RestController("/admin/v1/activityConfig")
public class AdminActivityConfigController {

    private final ActivityConfigService activityConfigService;

    @PostMapping("/add")
    public ActivityConfigVO add(@Validated @RequestBody ActivityConfigAddCmd cmd){
        return activityConfigService.add(cmd);
    }

    @GetMapping("/one")
    public ActivityConfigVO getOne(@RequestParam("id") Long id){
        return activityConfigService.getOne(id);
    }

    @GetMapping("/copy")
    public ActivityConfigCopyVO copy(@RequestParam("id") Long id){
        return activityConfigService.copy(id);
    }
}
