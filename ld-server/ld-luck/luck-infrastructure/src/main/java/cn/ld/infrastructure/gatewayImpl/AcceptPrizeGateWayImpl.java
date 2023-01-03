package cn.ld.infrastructure.gatewayImpl;

import cn.ld.config.enums.LdExceptionEnum;
import cn.ld.config.util.AssertUtil;
import cn.ld.domain.acceptPrize.AcceptPrizeEntity;
import cn.ld.domain.gateway.AcceptPrizeGateway;
import cn.ld.infrastructure.convertor.AcceptPrizeConvertor;
import cn.ld.infrastructure.database.dataObject.AcceptPrizeDB;
import cn.ld.infrastructure.database.mapper.AcceptPrizeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 16:14
 */
@Component
@AllArgsConstructor
public class AcceptPrizeGateWayImpl implements AcceptPrizeGateway {

    private final AcceptPrizeMapper acceptPrizeMapper;

    @Override
    public AcceptPrizeEntity save(AcceptPrizeEntity entity) {
        AcceptPrizeDB acceptPrizeDB = AcceptPrizeConvertor.toAcceptPrizeDB(entity);
        int insert = acceptPrizeMapper.insert(acceptPrizeDB);
        AssertUtil.isTrue(insert != 1, LdExceptionEnum.ADD_ERROR.getDescription());
        return AcceptPrizeConvertor.toEntity(acceptPrizeDB);
    }

    @Override
    public AcceptPrizeEntity getOne(Long recordId) {
        QueryWrapper<AcceptPrizeDB> wrapper = new QueryWrapper<>();
        wrapper.eq("recordId",recordId);
        AcceptPrizeDB acceptPrizeDB = acceptPrizeMapper.selectOne(wrapper);
        return AcceptPrizeConvertor.toEntity(acceptPrizeDB);
    }
}
