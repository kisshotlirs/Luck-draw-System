package cn.ld.client.dto.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 17:26
 */
@Data
public class ActivityRuleVO {

    private Long id;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 规则id
     */
    private Long ruleId;

    private LocalDateTime createTime;

    private String creator;

    private LocalDateTime updateTime;

    private String updater;
}
