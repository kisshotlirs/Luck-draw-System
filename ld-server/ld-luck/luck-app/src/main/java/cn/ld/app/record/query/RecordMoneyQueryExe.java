package cn.ld.app.record.query;

import cn.ld.app.assembler.RecordAssembler;
import cn.ld.client.dto.query.RecordListQuery;
import cn.ld.client.dto.vo.RecordVO;
import cn.ld.domain.gateway.RecordGateway;
import cn.ld.domain.record.RecordEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 20:48
 */
@Component
@AllArgsConstructor
public class RecordMoneyQueryExe {

    private final RecordGateway recordGateway;

    /**
     * 查询奖品金额数值
     */
    public BigDecimal execute(Long recordId) {
        return recordGateway.getPrizeMoneyByRecordId(recordId);
    }
}
