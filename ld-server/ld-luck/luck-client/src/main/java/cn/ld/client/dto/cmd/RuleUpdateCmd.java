package cn.ld.client.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 16:38
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RuleUpdateCmd extends Command {

    @NotNull(message = "规则id不能为空")
    private Long id;

    /**
     * 规则名称
     */
    @NotNull(message = "规则名称不能为空")
    private String ruleName;

    /**
     * 最大可参与次数
     */
    @NotNull(message = "规则最大可参与次数不能为空")
    private Integer maxJoinNumber;

    /**
     * 最大可中奖次数
     */
    @NotNull(message = "规则最大可中奖次数不能为空")
    private Integer maxWinningNumber;
}
