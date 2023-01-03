package cn.ld.app.service;

import cn.ld.app.acceptPrize.cmd.AcceptPrizeAddCmdExe;
import cn.ld.app.acceptPrize.query.AcceptPrizeListQueryExe;
import cn.ld.app.record.cmd.RecordUpdateStatusCmdExe;
import cn.ld.client.api.AcceptPrizeService;
import cn.ld.client.dto.cmd.AcceptPrizeAddCmd;
import cn.ld.client.dto.cmd.RecordUpdateStatusCmd;
import cn.ld.client.dto.vo.AcceptPrizeVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:32
 */
@Service
@AllArgsConstructor
public class AcceptPrizeServiceImpl implements AcceptPrizeService {

    private final AcceptPrizeAddCmdExe acceptPrizeAddCmdExe;
    private final AcceptPrizeListQueryExe acceptPrizeListQueryExe;
    private final RecordUpdateStatusCmdExe recordUpdateStatusCmdExe;

    @Override
    public AcceptPrizeVO getOne(Long recordId) {
        return acceptPrizeListQueryExe.excute(recordId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AcceptPrizeVO add(AcceptPrizeAddCmd cmd) {
        RecordUpdateStatusCmd updateStatusCmd = new RecordUpdateStatusCmd();
        updateStatusCmd.setId(cmd.getRecordId());
        updateStatusCmd.setStatus(2);
        recordUpdateStatusCmdExe.execute(updateStatusCmd);

        return acceptPrizeAddCmdExe.excute(cmd);
    }
}
