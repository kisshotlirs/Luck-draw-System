package cn.ld.app.activity.query;

import cn.ld.app.assembler.ActivityAssembler;
import cn.ld.client.dto.query.ActivityListQuery;
import cn.ld.client.dto.vo.ActivityVO;
import cn.ld.domain.activity.ActivityEntity;
import cn.ld.domain.gateway.ActivityGateWay;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 16:51
 */
@Component
@AllArgsConstructor
public class ActivityListQueryExe {

    private final ActivityGateWay activityGateWay;

    public IPage<ActivityVO> execute(ActivityListQuery query) {
        IPage<ActivityEntity> page = activityGateWay.page(query);
        return page.convert(ActivityAssembler::toActivityVO);
    }
}
