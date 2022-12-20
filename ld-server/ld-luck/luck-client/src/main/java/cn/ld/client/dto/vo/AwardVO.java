package cn.ld.client.dto.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 18:35
 */
@Data
public class AwardVO {

    private Long id;

    /**
     * 奖品名称
     */
    private Long prizeId;

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

    private LocalDateTime createTime;

    private String creator;

    private LocalDateTime updateTime;

    private String updater;
}
