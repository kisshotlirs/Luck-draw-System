package cn.ld.app.assembler;
import java.time.LocalDateTime;

import cn.ld.client.dto.cmd.AcceptPrizeAddCmd;
import cn.ld.client.dto.vo.AcceptPrizeVO;
import cn.ld.config.util.SecurityUtil;
import cn.ld.domain.acceptPrize.AcceptPrizeEntity;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:33
 */
public class AcceptPrizeAssembler {

    public static AcceptPrizeEntity toEntity(AcceptPrizeAddCmd cmd) {
        AcceptPrizeEntity entity = new AcceptPrizeEntity();
        entity.setRecordId(cmd.getRecordId());
        entity.setPhone(cmd.getPhone());
        entity.setAddress(cmd.getAddress());
        entity.setCreateTime(LocalDateTime.now());
        entity.setCreator(SecurityUtil.getUserName());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setUpdater(SecurityUtil.getUserName());
        return entity;
    }

    public static AcceptPrizeVO toAcceptPrizeVO(AcceptPrizeEntity entity) {
        AcceptPrizeVO acceptPrizeVO = new AcceptPrizeVO();
        acceptPrizeVO.setId(entity.getId());
        acceptPrizeVO.setPhone(entity.getPhone());
        acceptPrizeVO.setAddress(entity.getAddress());
        acceptPrizeVO.setCreateTime(entity.getCreateTime());
        return acceptPrizeVO;
    }
}
