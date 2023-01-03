package cn.ld.domain.gateway;

import cn.ld.domain.acceptPrize.AcceptPrizeEntity;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:16
 */
public interface AcceptPrizeGateway {

    AcceptPrizeEntity save(AcceptPrizeEntity entity);

    AcceptPrizeEntity getOne(Long recordId);
}
