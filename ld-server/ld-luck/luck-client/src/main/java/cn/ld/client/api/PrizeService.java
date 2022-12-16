package cn.ld.client.api;

import cn.ld.client.dto.cmd.PrizeAddCmd;
import cn.ld.client.dto.cmd.PrizeUpdateCmd;
import cn.ld.client.dto.query.PrizeListQuery;
import cn.ld.client.dto.vo.PrizeVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/16 0016 21:58
 */
@Service
public interface PrizeService {

    /**
     * 奖品添加
     */
    PrizeVO prizeAdd(PrizeAddCmd cmd);

    PrizeVO updatePrize(PrizeUpdateCmd cmd);

    IPage<PrizeVO> page(PrizeListQuery query);

    PrizeVO getOne(Long id);
}
