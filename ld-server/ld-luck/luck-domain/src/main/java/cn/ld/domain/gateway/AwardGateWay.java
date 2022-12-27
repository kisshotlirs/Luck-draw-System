package cn.ld.domain.gateway;

import cn.ld.client.dto.query.AwardListQuery;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.domain.award.AwardEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 21:44
 */
public interface AwardGateWay {

    AwardEntity save(AwardEntity entity);

    IPage<AwardEntity> page(AwardListQuery query);

    /**
     * 扣减奖项库存
     */
    int deductionAwardNumber(Long awardId, Integer number);
}
