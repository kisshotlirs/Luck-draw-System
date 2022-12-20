package cn.ld.client.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 15:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActivityUpdateCmd extends Command {

    /**
     * 活动id
     */
    @NotNull(message = "活动id不为空")
    private Long id;

    /**
     * 活动名称
     */
    @NotNull(message = "活动名称不为空")
    private String activityName;

    /**
     * 开始时间
     */
    @NotNull(message = "活动开始时间不为空")
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @NotNull(message = "活动结束结束时间不为空")
    private LocalDateTime endTime;

    /**
     * 描述
     */
    @NotNull(message = "活动描述不为空")
    private String describe;
}
