package cn.ld.domain.acceptPrize;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:14
 */
@Data
@Entity
public class AcceptPrizeEntity {

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

    private LocalDateTime createTime;

    private String creator;

    private LocalDateTime updateTime;

    private String updater;
}
