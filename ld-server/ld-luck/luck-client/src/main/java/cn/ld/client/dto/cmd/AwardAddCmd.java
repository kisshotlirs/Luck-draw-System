package cn.ld.client.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 18:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AwardAddCmd extends Command {

    /**
     * 奖品名称
     */
    @NotNull(message = "奖品id不为空")
    private Long prizeId;

    @NotNull(message = "活动id不为空")
    private Long activityId;

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
