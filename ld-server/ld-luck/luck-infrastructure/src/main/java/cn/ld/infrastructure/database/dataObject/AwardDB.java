package cn.ld.infrastructure.database.dataObject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName ld_award
 */
@TableName(value ="ld_award")
@Data
public class AwardDB implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 奖品名称
     */
    private Long prizeId;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 奖项名称
     */
    private String awardName;

    /**
     * 概率
     */
    private Double probability;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String creator;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private String updater;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}