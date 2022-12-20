package cn.ld.client.api;

import cn.ld.client.dto.cmd.ActivityAddCmd;
import cn.ld.client.dto.cmd.ActivityUpdateCmd;
import cn.ld.client.dto.query.ActivityListQuery;
import cn.ld.client.dto.vo.ActivityVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 15:45
 */
@Service
public interface ActivityService {

    ActivityVO addActivity(ActivityAddCmd cmd);

    ActivityVO updateActivity(ActivityUpdateCmd cmd);

    IPage<ActivityVO> page(ActivityListQuery query);

    ActivityVO getOne(Long id);
}
