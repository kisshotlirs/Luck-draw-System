package cn.ld.domain.activityRule;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/21 0021 17:22
 */
@Data
@Entity
public class ActivityRuleEntity {

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
