package cn.ld.client.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 15:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActivityListQuery extends PageQuery {

    /**
     * 活动id
     */
    private Long id;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 活动状态（0，1，2）
     */
    private Integer status;
}
