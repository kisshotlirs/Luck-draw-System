package cn.ld.app.prize.query;

import cn.ld.client.dto.query.PrizeListQuery;
import cn.ld.client.dto.vo.PrizeVO;
import cn.ld.domain.gateway.PrizeGateWay;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/16 0016 22:40
 */
@Slf4j
@Component
@AllArgsConstructor
public class PrizeListQueryExe {

    private final PrizeGateWay prizeGateWay;

    public static IPage<PrizeVO> execute(PrizeListQuery query) {
        return null;
    }
}
