package cn.ld.client.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/16 0016 22:08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PrizeUpdateCmd extends Command {

    @NotNull(message = "奖品id不为空")
    private Long id;

    /**
     * 奖品名称
     */
    @NotNull(message = "奖品名称不为空")
    private String prizeName;

    /**
     * 库存
     */
    @NotNull(message = "奖品库存不为空")
    private Integer inventory;

    /**
     * 金额
     */
    @NotNull(message = "奖品金额不为空")
    private BigDecimal money;

    /**
     * 类型（1：商品，2：金钱）
     */
    @NotNull(message = "奖品类型不为空")
    private Integer type;
}
