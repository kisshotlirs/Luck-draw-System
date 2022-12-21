package cn.ld.client.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 17:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActivityRuleUpdateCmd extends Command {

    private Long id;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 规则id
     */
    private Long ruleId;
}
