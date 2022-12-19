package cn.ld.domain.award;


import com.alibaba.cola.domain.Entity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 18:29
 */
@Data
@Entity
public class AwardEntity {

    private Long id;

    /**
     * 奖品名称
     */
    private Long prizeId;

    /**
     * 数量
     */
    private AwardNumber number;

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
