package cn.ld.adapter.web.admin;

import cn.ld.client.api.PrizeService;
import cn.ld.client.dto.cmd.PrizeAddCmd;
import cn.ld.client.dto.cmd.PrizeUpdateCmd;
import cn.ld.client.dto.query.PrizeListQuery;
import cn.ld.client.dto.vo.PrizeVO;
import cn.ld.common.annotation.ResponseResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 13:31
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RestController("/admin/v1/prize")
public class AdminPrizeController {

    private final PrizeService prizeService;

    @PostMapping("/add")
    public PrizeVO addPrize(@RequestBody @Validated PrizeAddCmd cmd){
        return prizeService.prizeAdd(cmd);
    }

    @PostMapping("/update")
    public PrizeVO updatePrize(@RequestBody @Validated PrizeUpdateCmd cmd){
        return prizeService.updatePrize(cmd);
    }

    @PostMapping("/page")
    public IPage<PrizeVO> page(@RequestBody PrizeListQuery query){
        return prizeService.page(query);
    }

    @PostMapping("/{id}")
    public PrizeVO getOne(@PathVariable("id") Long id){
        return prizeService.getOne(id);
    }

}
