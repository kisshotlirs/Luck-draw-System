package cn.ld.infrastructure.gatewayImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.client.dto.query.AwardListQuery;
import cn.ld.config.enums.LdExceptionEnum;
import cn.ld.config.util.Assertutil;
import cn.ld.domain.award.AwardEntity;
import cn.ld.domain.gateway.AwardGateWay;
import cn.ld.infrastructure.convertor.AwardConvertor;
import cn.ld.infrastructure.database.dataObject.AwardDB;
import cn.ld.infrastructure.database.mapper.AwardMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 22:22
 */
@Component
@AllArgsConstructor
public class AwardGatewayImpl implements AwardGateWay {

    private final AwardMapper awardMapper;

    @Override
    public AwardEntity save(AwardEntity entity) {
        if (ObjectUtil.isNull(entity.getId())){
            return addAward(entity);
        }
        return updateAward(entity);
    }

    private AwardEntity addAward(AwardEntity entity) {
        AwardDB awardDB = AwardConvertor.toAddDB(entity);
        Assertutil.isTrue(awardMapper.insert(awardDB)!=1, LdExceptionEnum.ADD_ERROR.getDescription());
        return AwardConvertor.toEntity(awardDB);
    }

    private AwardEntity updateAward(AwardEntity entity) {
        AwardDB awardDB = AwardConvertor.toUpdateDB(entity);
        Assertutil.isFalse(awardMapper.updateById(awardDB)==1,LdExceptionEnum.UPDATE_ERROR.getDescription());
        return AwardConvertor.toEntity(awardDB);
    }

    @Override
    public IPage<AwardEntity> page(AwardListQuery query) {
        IPage<AwardDB> page = awardMapper.page(new Page<AwardDB>(query.getPageIndex(),query.getPageSize()),query);
        return page.convert(AwardConvertor::toEntity);
    }

    @Override
    public int deductionAwardNumber(Long awardId, Integer number) {
        return awardMapper.deductionAwardNumber(awardId,number);
    }
}
