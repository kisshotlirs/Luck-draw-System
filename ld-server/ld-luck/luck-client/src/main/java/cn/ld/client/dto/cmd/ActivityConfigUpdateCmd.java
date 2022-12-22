package cn.ld.client.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 15:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActivityConfigUpdateCmd extends Command {

    private ActivityUpdateCmd activityUpdateCmd;

    private List<Long> ruleIdList;

    private List<AwardUpdateCmd> awardUpdateCmdList;
}
