package cn.ld.app.award.cmd;

import cn.hutool.core.util.ObjectUtil;
import cn.ld.app.assembler.AwardAssembler;
import cn.ld.client.dto.cmd.AwardAddCmd;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.config.util.Assertutil;
import cn.ld.domain.award.AwardEntity;
import cn.ld.domain.gateway.AwardGateWay;
import cn.ld.domain.gateway.PrizeGateWay;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 19:54
 */
@Component
@AllArgsConstructor
public class AwardAddCmdExe {

    private final AwardGateWay awardGateWay;

    private final PrizeGateWay prizeGateWay;

    public AwardVO execute(AwardAddCmd cmd) {
        Assertutil.isTrue(ObjectUtil.isNull(cmd.getActivityId()),"奖项的活动id不为空");
        AwardEntity entity = awardGateWay.save(AwardAssembler.toAddEntity(cmd));

        //判断是否为奖品，是否需要扣除奖品库存
        if (entity.isPrize()){
            //prizeId为0是 非奖品，谢谢参与之类的
            return AwardAssembler.toAwardVO(entity);
        }

        //添加奖项后 扣除奖品库存
        int updated = prizeGateWay.reduceInventory(cmd.getPrizeId(),cmd.getNumber());
        Assertutil.isTrue(updated!=1,String.format("扣取奖品：%s 出错，库存不足或奖品不存在",cmd.getPrizeId()));

        return AwardAssembler.toAwardVO(entity);
    }
}
