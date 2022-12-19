package cn.ld.app.award.query;


import cn.ld.app.assembler.AwardAssembler;
import cn.ld.client.dto.query.AwardListQuery;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.domain.award.AwardEntity;
import cn.ld.domain.gateway.AwardGateWay;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 19:56
 */
@Component
@AllArgsConstructor
public class AwardListQueryCmdExe{

    private final AwardGateWay awardGateWay;

    public IPage<AwardVO> execute(AwardListQuery query) {
        IPage<AwardEntity> page = awardGateWay.page(query);
        return page.convert(AwardAssembler::toAwardVO);
    }
}
