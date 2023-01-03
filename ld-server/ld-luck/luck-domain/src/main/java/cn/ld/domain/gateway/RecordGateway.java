package cn.ld.domain.gateway;

import cn.ld.client.dto.query.RecordListQuery;
import cn.ld.domain.record.RecordEntity;
import cn.ld.domain.record.RecordStatus;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.math.BigDecimal;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/30 0030 11:35
 */
public interface RecordGateway {

    RecordEntity save(RecordEntity entity);

    IPage<RecordEntity> page(RecordListQuery query);

    Boolean updateStatus(Long recordId, Integer status);

    BigDecimal getPrizeMoneyByRecordId(Long recordId);
}
