package cn.ld.adapter.web;

import cn.ld.client.api.ActivityConfigService;
import cn.ld.client.api.ActivityService;
import cn.ld.client.dto.query.ActivityListQuery;
import cn.ld.client.dto.vo.ActivityConfigVO;
import cn.ld.client.dto.vo.ActivityVO;
import cn.ld.client.dto.vo.DrawResultVO;
import cn.ld.common.annotation.ResponseResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author mojo
 * @description: 用户抽奖
 * @date 2022/12/23 0023 14:18
 */
@AllArgsConstructor
@ResponseResult
@RestController("/v1/activity")
public class ActivityController {

    private final ActivityConfigService activityConfigService;

    private final ActivityService activityService;

    @PostMapping("/page")
    public IPage<ActivityVO> page(@RequestBody ActivityListQuery query){
        return activityService.page(query);
    }

    @GetMapping("/one")
    public ActivityConfigVO getOne(@RequestParam("id") Long id){
        return activityConfigService.getOne(id);
    }

    @GetMapping("/draw")
    public DrawResultVO draw(@RequestParam("activityId") Long activityId){
        return activityService.draw(activityId);
    }

}
