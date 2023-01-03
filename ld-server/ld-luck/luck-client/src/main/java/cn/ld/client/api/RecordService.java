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

    /**
     * 获取奖品中奖类型（1.商品 2.金钱）
     */
    Integer prizeType(Long recordId);

    /**
     * 兑换金钱类奖品
     */
    Boolean exchangeMoney(Long recordId);
}
