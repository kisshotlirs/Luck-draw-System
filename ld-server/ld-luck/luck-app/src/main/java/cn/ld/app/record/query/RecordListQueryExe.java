package cn.ld.app.record.query;

import cn.ld.app.assembler.RecordAssembler;
import cn.ld.client.dto.query.RecordListQuery;
import cn.ld.client.dto.vo.RecordVO;
import cn.ld.domain.gateway.RecordGateway;
import cn.ld.domain.record.RecordEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/30 0030 11:28
 */
@Component
@AllArgsConstructor
public class RecordListQueryExe {

    private final RecordGateway recordGateway;

    public IPage<RecordVO> execute(RecordListQuery query) {
        IPage<RecordEntity> page = recordGateway.page(query);
        return page.convert(RecordAssembler::toVO);
    }
}
