package cn.ld.client.api;

import cn.ld.client.dto.cmd.AwardAddCmd;
import cn.ld.client.dto.cmd.AwardUpdateCmd;
import cn.ld.client.dto.query.AwardListQuery;
import cn.ld.client.dto.vo.AwardVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 18:34
 */
@Service
public interface AwardService {

    AwardVO awardAdd(AwardAddCmd cmd);

    AwardVO awardUpdate(AwardUpdateCmd cmd);

    IPage<AwardVO> page(AwardListQuery query);

    AwardVO getOne(Long id);
}
