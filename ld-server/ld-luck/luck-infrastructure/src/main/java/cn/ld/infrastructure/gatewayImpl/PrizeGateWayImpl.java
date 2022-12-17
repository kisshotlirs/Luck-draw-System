package cn.ld.infrastructure.gatewayImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.client.dto.query.PrizeListQuery;
import cn.ld.config.exception.ldException;
import cn.ld.domain.gateway.PrizeGateWay;
import cn.ld.domain.prize.PrizeEntity;
import cn.ld.infrastructure.convertor.PrizeConvertor;
import cn.ld.infrastructure.database.dataObject.PrizeDB;
import cn.ld.infrastructure.database.mapper.PrizeMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 11:39
 */
@Slf4j
@Component
@AllArgsConstructor
public class PrizeGateWayImpl implements PrizeGateWay {

    private final PrizeMapper prizeMapper;

    @Override
    public PrizeEntity save(PrizeEntity entity) {
        if (ObjectUtil.isNull(entity.getId())){
            return addPrize(entity);
        }
        return updatePrize(entity);
    }

    private PrizeEntity updatePrize(PrizeEntity entity) {
        PrizeDB prizeDB = PrizeConvertor.toPrizeDB(entity);
        int result = prizeMapper.updateById(prizeDB);
        if (result!=1){
            throw new ldException("更新奖品信息失败！");
        }
        return PrizeConvertor.toPrizeEntity(prizeDB);
    }

    private PrizeEntity addPrize(PrizeEntity entity) {
        PrizeDB prizeDB = PrizeConvertor.toPrizeDB(entity);
        int result = prizeMapper.insert(prizeDB);
        if (result!=1){
            throw new ldException("新增奖品信息失败！");
        }
        return PrizeConvertor.toPrizeEntity(prizeDB);
    }

    @Override
    public IPage<PrizeEntity> page(PrizeListQuery query) {
        IPage<PrizeDB> page = prizeMapper.page(new Page<PrizeDB>(query.getPageIndex(), query.getPageIndex()),query);
        return page.convert(PrizeConvertor::toPrizeEntity);
    }
}
