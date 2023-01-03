package cn.ld.client.api;

import cn.ld.client.dto.cmd.AcceptPrizeAddCmd;
import cn.ld.client.dto.vo.AcceptPrizeVO;
import org.springframework.stereotype.Service;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:19
 */
@Service
public interface AcceptPrizeService {

    AcceptPrizeVO getOne(Long recordId);

    AcceptPrizeVO add(AcceptPrizeAddCmd cmd);
}
