package cn.ld.infrastructure.database.dataObject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 * @TableName ld_activity
 */
@TableName(value ="ld_activity")
@Data
public class ActivityDB implements Serializable {

    @TableId(type = IdType.AUTO)
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
     * 描述
     */
    private String describe;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String creator;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private String updater;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}