package cn.ld.adapter.web;

import cn.ld.client.api.AcceptPrizeService;
import cn.ld.client.dto.cmd.AcceptPrizeAddCmd;
import cn.ld.client.dto.vo.AcceptPrizeVO;
import cn.ld.common.annotation.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 17:07
 */
@AllArgsConstructor
@ResponseResult
@RestController("/v1/acceptPrize")
public class AcceptPrizeController {

    private final AcceptPrizeService acceptPrizeService;

    @PostMapping("/add")
    public AcceptPrizeVO add(@RequestBody @Validated AcceptPrizeAddCmd cmd){
        return acceptPrizeService.add(cmd);
    }

    @GetMapping("/one")
    public AcceptPrizeVO getOne(@RequestParam("recordId") Long recordId){
        return acceptPrizeService.getOne(recordId);
    }
}
