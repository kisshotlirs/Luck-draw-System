package cn.ld.adapter.web;

import cn.ld.client.api.RecordService;
import cn.ld.client.dto.cmd.RecordUpdateStatusCmd;
import cn.ld.client.dto.query.RecordListQuery;
import cn.ld.client.dto.vo.RecordVO;
import cn.ld.common.annotation.ResponseResult;
import cn.ld.config.util.SecurityUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/31 0031 16:02
 */
@ResponseResult
@AllArgsConstructor
@RequestMapping("/v1/record")
public class RecordController {

    private final RecordService recordService;

    @PostMapping("/page")
    public IPage<RecordVO> page(@RequestBody RecordListQuery query){
        query.setUserId(SecurityUtil.getUserId());
        return recordService.page(query);
    }

    @GetMapping("/prizeType")
    public Integer prizeType(@RequestParam("recordId") Long recordId){
        return recordService.prizeType(recordId);
    }

    @PostMapping("/updateStatusTo4")
    public Boolean updateStatusTo4(@RequestBody RecordUpdateStatusCmd cmd){
        cmd.setStatus(4);
        return recordService.updateStatus(cmd);
    }

    @GetMapping("/exchangeMoney")
    public Boolean exchangeMoney(@RequestParam("recordId") Long recordId){
        return recordService.exchangeMoney(recordId);
    }

}
