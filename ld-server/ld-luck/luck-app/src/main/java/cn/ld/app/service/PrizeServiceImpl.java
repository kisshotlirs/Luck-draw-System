package cn.ld.app.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.app.prize.cmd.PrizeAddCmdExe;
import cn.ld.app.prize.cmd.PrizeUpdateCmdExe;
import cn.ld.app.prize.query.PrizeListQueryExe;
import cn.ld.client.api.PrizeService;
import cn.ld.client.dto.cmd.PrizeAddCmd;
import cn.ld.client.dto.cmd.PrizeUpdateCmd;
import cn.ld.client.dto.query.PrizeListQuery;
import cn.ld.client.dto.vo.PrizeVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/16 0016 22:32
 */
@Service
@AllArgsConstructor
public class PrizeServiceImpl implements PrizeService {

    private final PrizeAddCmdExe prizeAddCmdExe;
    private final PrizeUpdateCmdExe prizeUpdateCmdExe;
    private final PrizeListQueryExe prizeListQueryExe;

    @Override
    public PrizeVO prizeAdd(PrizeAddCmd cmd) {
        return prizeAddCmdExe.execute(cmd);
    }

    @Override
    public PrizeVO updatePrize(PrizeUpdateCmd cmd) {
        return prizeUpdateCmdExe.execute(cmd);
    }

    @Override
    public IPage<PrizeVO> page(PrizeListQuery query) {
        return prizeListQueryExe.execute(query);
    }

    @Override
    public PrizeVO getOne(Long id) {
        PrizeListQuery listQuery = new PrizeListQuery();
        listQuery.setId(id);
        IPage<PrizeVO> page = page(listQuery);
        if (CollectionUtil.isEmpty(page.getRecords())){
            return null;
        }
        return page.getRecords().get(0);
    }
}
