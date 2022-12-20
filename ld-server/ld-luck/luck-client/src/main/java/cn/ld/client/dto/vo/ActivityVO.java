package cn.ld.client.dto.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 15:46
 */
@Data
public class ActivityVO {

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

    private LocalDateTime createTime;

    private String creator;

    private LocalDateTime updateTime;

    private String updater;

}
