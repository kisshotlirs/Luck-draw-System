package cn.ld.domain.activity;

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
 * @date 2022/12/20 0020 15:06
 */
@Data
@Entity
public class ActivityEntity {

    private Long id;

    /**
     * 活动名称
     */
    private String activityName;

    private ActivityTime activityTime;

    /**
     * 描述
     */
    private String describe;

    private LocalDateTime createTime;

    private String creator;

    private LocalDateTime updateTime;

    private String updater;

}
