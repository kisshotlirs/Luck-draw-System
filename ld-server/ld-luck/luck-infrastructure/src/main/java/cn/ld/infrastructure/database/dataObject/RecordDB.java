package cn.ld.infrastructure.database.dataObject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName ld_record
 */
@TableName(value ="ld_record")
@Data
public class RecordDB implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 奖项id
     */
    private Long awardId;

    /**
     * 是否中奖：0未中奖，1中奖
     */
    private Integer isWinning;

    /**
     * 状态（0，1，2，3）
     */
    private Integer state;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String creator;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private String updater;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}