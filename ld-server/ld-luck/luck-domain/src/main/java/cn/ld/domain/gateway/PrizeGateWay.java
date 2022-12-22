package cn.ld.domain.gateway;

import cn.ld.client.dto.query.PrizeListQuery;
import cn.ld.config.exception.LdException;
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

    default PrizeEntity getOne(Long id){
        PrizeListQuery query = new PrizeListQuery();
        query.setId(id);
        PrizeEntity prizeEntity = null;
        try {
            prizeEntity = page(query).getRecords().get(0);
        }catch (Exception e){
            throw new LdException(String.format("奖品id: %s，数据不存在",id));
        }
        return prizeEntity;
    };

    /**
     * 扣减奖品库存
     * @param prizeId 奖品id
     * @param number 扣减数量
     */
    int reduceInventory(Long prizeId, Integer number);
}
