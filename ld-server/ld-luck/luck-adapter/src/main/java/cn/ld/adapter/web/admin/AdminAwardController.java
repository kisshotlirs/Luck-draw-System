package cn.ld.adapter.web.admin;

import cn.ld.client.api.AwardService;
import cn.ld.client.dto.cmd.AwardAddCmd;
import cn.ld.client.dto.cmd.AwardUpdateCmd;
import cn.ld.client.dto.query.AwardListQuery;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.common.annotation.ResponseResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 14:46
 */
@AllArgsConstructor
@ResponseResult
@RestController("/admin/v1/award")
public class AdminAwardController {

    private final AwardService awardService;

    @PostMapping("/add")
    public AwardVO addAward(@Validated @RequestBody AwardAddCmd cmd){
        return awardService.awardAdd(cmd);
    }

    @PostMapping("/update")
    public AwardVO updateAward(@Validated @RequestBody AwardUpdateCmd cmd){
        return awardService.awardUpdate(cmd);
    }

    @PostMapping("/{id}")
    public AwardVO getOne(@PathVariable("id") Long id){
        return awardService.getOne(id);
    }

    @PostMapping("/page")
    public IPage<AwardVO> page(@RequestBody @Validated AwardListQuery query){
        return awardService.page(query);
    }
}
