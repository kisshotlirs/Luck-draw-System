package cn.ld.adapter.web;

import cn.ld.client.api.PrizeService;
import cn.ld.common.annotation.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mojo
 * @description: 奖品 控制层
 * @date 2022/12/17 0017 13:28
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RestController("/v1/prize")
public class PrizeController {

    private final PrizeService prizeService;


}
