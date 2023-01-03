package cn.ld.adapter.web.admin;

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
@RequestMapping("/admin/v1/record")
public class AdminRecordController {

    private final RecordService recordService;

    @PostMapping("/page")
    public IPage<RecordVO> page(@RequestBody RecordListQuery query){
        query.setUserId(SecurityUtil.getUserId());
        return recordService.page(query);
    }

    @PostMapping("/updateStatusTo3")
    public Boolean updateStatusTo3(@RequestBody RecordUpdateStatusCmd cmd){
        cmd.setStatus(3);
        return recordService.updateStatus(cmd);
    }

}
