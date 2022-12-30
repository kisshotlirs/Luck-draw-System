package cn.ld.infrastructure.gatewayImpl;

import cn.ld.client.dto.query.RecordListQuery;
import cn.ld.config.util.AssertUtil;
import cn.ld.domain.gateway.RecordGateway;
import cn.ld.domain.record.RecordEntity;
import cn.ld.infrastructure.convertor.RecordConvertor;
import cn.ld.infrastructure.database.dataObject.RecordDB;
import cn.ld.infrastructure.database.mapper.RecordMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/30 0030 12:06
 */
@Component
@AllArgsConstructor
public class RecordGateWayImpl implements RecordGateway {

    private final RecordMapper recordMapper;

    @Override
    public RecordEntity save(RecordEntity entity) {
        RecordDB recordDB = RecordConvertor.toRecordDB(entity);
        int insert = recordMapper.insert(recordDB);
        AssertUtil.isTrue(insert!=1,"保存记录数据失败");
        return RecordConvertor.toEntity(recordDB);
    }

    @Override
    public IPage<RecordEntity> page(RecordListQuery query) {
        IPage<RecordDB> page = recordMapper.page(new Page<RecordDB>(query.getPageIndex(),query.getPageSize()),query);
        return page.convert(RecordConvertor::toEntity);
    }

    @Override
    public Boolean updateStatus(Long recordId, Integer status) {
        return recordMapper.updateStatus(recordId,status) == 1;
    }
}
