package cn.ld.app.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.app.award.query.AwardListQueryCmdExe;
import cn.ld.app.prize.query.PrizeListQueryExe;
import cn.ld.app.record.cmd.RecordAddCmdExe;
import cn.ld.app.record.cmd.RecordUpdateStatusCmdExe;
import cn.ld.app.record.query.RecordListQueryExe;
import cn.ld.app.record.query.RecordMoneyQueryExe;
import cn.ld.client.api.RecordService;
import cn.ld.client.dto.cmd.RecordAddCmd;
import cn.ld.client.dto.cmd.RecordUpdateStatusCmd;
import cn.ld.client.dto.query.AwardListQuery;
import cn.ld.client.dto.query.PrizeListQuery;
import cn.ld.client.dto.query.RecordListQuery;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.client.dto.vo.RecordVO;
import cn.ld.config.util.AssertUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

    private final RecordMoneyQueryExe recordMoneyQueryExe;
    private final AwardListQueryCmdExe awardListQueryCmdExe;

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

    @Override
    public Integer prizeType(Long recordId) {
        return getPrizeByRecordId(recordId).getPrizeType();
    }

    public RecordVO getPrizeByRecordId(Long recordId){
        RecordListQuery recordQuery = new RecordListQuery();
        recordQuery.setRecordId(recordId);

        List<RecordVO> records = recordListQueryExe.execute(recordQuery).getRecords();
        AssertUtil.isTrue(CollectionUtil.isEmpty(records) || Objects.isNull(records.get(0)),
                "数据不存在");

        return records.get(0);
    }

    @Override
    public Boolean exchangeMoney(Long recordId) {
        //校验奖品类型
        Integer prizeType = prizeType(recordId);
        AssertUtil.isTrue(prizeType!=2,"奖品类型兑换出错");

        //获取奖品金额
        BigDecimal money = recordMoneyQueryExe.execute(recordId);

        //// TODO: 2023/1/3 0003  
        //调用给用户钱包加钱逻辑

        Boolean result = Boolean.TRUE;
        if (Boolean.FALSE.equals(result)){
            return Boolean.FALSE;
        }

        //将记录状态改为4（流程结束）
        RecordUpdateStatusCmd cmd = new RecordUpdateStatusCmd();
        cmd.setId(recordId);
        cmd.setStatus(4);
        updateStatus(cmd);

        return Boolean.TRUE;
    }
}
