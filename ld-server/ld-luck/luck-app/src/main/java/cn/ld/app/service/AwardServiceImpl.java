package cn.ld.app.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.ld.app.award.cmd.AwardAddCmdExe;
import cn.ld.app.award.cmd.AwardUpdateCmdExe;
import cn.ld.app.award.query.AwardListQueryCmdExe;
import cn.ld.client.api.AwardService;
import cn.ld.client.dto.cmd.AwardAddCmd;
import cn.ld.client.dto.cmd.AwardUpdateCmd;
import cn.ld.client.dto.query.AwardListQuery;
import cn.ld.client.dto.vo.AwardVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 19:52
 */
@Service
@AllArgsConstructor
public class AwardServiceImpl implements AwardService {

    private final AwardAddCmdExe awardAddCmdExe;

    private final AwardUpdateCmdExe awardUpdateCmdExe;

    private final AwardListQueryCmdExe awardListQueryCmdExe;

    @Override
    public AwardVO awardAdd(AwardAddCmd cmd) {
        return awardAddCmdExe.execute(cmd);
    }

    @Override
    public AwardVO awardUpdate(AwardUpdateCmd cmd) {
        return awardUpdateCmdExe.execute(cmd);
    }

    @Override
    public IPage<AwardVO> page(AwardListQuery query) {
        return awardListQueryCmdExe.execute(query);
    }

    @Override
    public AwardVO getOne(Long id) {
        AwardListQuery query = new AwardListQuery();
        query.setId(id);
        IPage<AwardVO> page = page(query);
        if (CollectionUtil.isEmpty(page.getRecords())){
            return null;
        }
        return page.getRecords().get(0);
    }
}
