package cn.ld.infrastructure.database.dataObject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName ld_accept_prize
 */
@TableName(value ="ld_accept_prize")
@Data
public class AcceptPrizeDB implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 抽奖记录id
     */
    private Long recordId;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String creator;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private String updater;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}