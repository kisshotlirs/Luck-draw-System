package cn.ld.client.api;

import cn.ld.client.dto.cmd.RecordAddCmd;
import cn.ld.client.dto.cmd.RecordUpdateStatusCmd;
import cn.ld.client.dto.query.RecordListQuery;
import cn.ld.client.dto.vo.RecordVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/30 0030 11:20
 */
@Service
public interface RecordService {

    IPage<RecordVO> page(RecordListQuery query);

    RecordVO add(RecordAddCmd cmd);

    Boolean updateStatus(RecordUpdateStatusCmd cmd);
}
