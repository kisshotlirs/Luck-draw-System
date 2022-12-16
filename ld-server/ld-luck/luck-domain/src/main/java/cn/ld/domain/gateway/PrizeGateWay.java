package cn.ld.domain.gateway;

import cn.ld.client.dto.query.PrizeListQuery;
import cn.ld.domain.prize.PrizeEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/16 0016 22:55
 */
public interface PrizeGateWay {

    PrizeEntity save(PrizeEntity entity);

    IPage<PrizeEntity> page(PrizeListQuery query);
}
