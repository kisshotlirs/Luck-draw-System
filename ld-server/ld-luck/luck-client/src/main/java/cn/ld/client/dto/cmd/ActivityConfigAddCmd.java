package cn.ld.client.dto.cmd;

import cn.ld.client.dto.vo.AwardVO;
import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 15:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActivityConfigAddCmd extends Command {

    private ActivityAddCmd activityAddCmd;

    /**
     * 规则id
     */
    private List<Long> ruleIdList;

    private AwardAddCmd awardAddCmd;
}
