package cn.ld.client.dto.vo;

import cn.ld.client.dto.cmd.ActivityAddCmd;
import cn.ld.client.dto.cmd.AwardAddCmd;
import lombok.Data;

import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/22 0022 21:21
 */
@Data
public class ActivityConfigCopyVO {

    private ActivityAddCmd activityAddCmd;

    /**
     * 规则id
     */
    private List<Long> ruleIdList;

    private List<AwardAddCmd> awardAddCmdList;
}
