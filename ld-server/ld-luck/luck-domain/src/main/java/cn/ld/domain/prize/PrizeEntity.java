package cn.ld.domain.prize;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: 奖品的领域对象
 * @date 2022/12/16 0016 21:25
 */
@Data
@Entity
public class PrizeEntity {

    private Long id;

    /**
     * 奖品名称
     */
    private String prizeName;

    /**
     * 库存
     */
    private Inventory inventory;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 类型（1：商品，2：金钱）
     */
    private Integer type;

    private LocalDateTime createTime;

    private String creator;

    private LocalDateTime updateTime;

    private String updater;
}
