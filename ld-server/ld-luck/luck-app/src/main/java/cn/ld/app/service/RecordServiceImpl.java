package cn.ld.app.service;

import cn.ld.app.record.cmd.RecordAddCmdExe;
import cn.ld.app.record.cmd.RecordUpdateStatusCmdExe;
import cn.ld.app.record.query.RecordListQueryExe;
import cn.ld.client.api.RecordService;
import cn.ld.client.dto.cmd.RecordAddCmd;
import cn.ld.client.dto.cmd.RecordUpdateStatusCmd;
import cn.ld.client.dto.query.RecordListQuery;
import cn.ld.client.dto.vo.RecordVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/30 0030 11:26
 */
@Service
@AllArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final RecordAddCmdExe recordAddCmdExe;
    private final RecordUpdateStatusCmdExe recordUpdateStatusCmdExe;
    private final RecordListQueryExe recordListQueryExe;

    @Override
    public IPage<RecordVO> page(RecordListQuery query) {
        return recordListQueryExe.execute(query);
    }

    @Override
    public RecordVO add(RecordAddCmd cmd) {
        return recordAddCmdExe.execute(cmd);
    }

    @Override
    public Boolean updateStatus(RecordUpdateStatusCmd cmd) {
        return recordUpdateStatusCmdExe.execute(cmd);
    }
}
