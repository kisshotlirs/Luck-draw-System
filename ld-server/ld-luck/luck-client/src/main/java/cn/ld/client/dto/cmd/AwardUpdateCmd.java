package cn.ld.client.dto.cmd;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 18:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AwardUpdateCmd {

    @NotNull(message = "奖项id不为空")
    private Long id;

    /**
     * 奖品名称
     */
    @NotNull(message = "奖品id不为空")
    private Long prizeId;

    /**
     * 数量
     */
    @NotNull(message = "奖项数量不为空")
    private Integer number;

    /**
     * 奖项名称
     */
    @NotNull(message = "奖项名称不为空")
    private String awardName;

    /**
     * 概率
     */
    @NotNull(message = "概率不为空")
    private Double probability;
}
