package cn.ld.client.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/29 0029 22:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RecordAddCmd extends Command {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 活动id
     */
    private Long activityId;

    private String activityName;

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

}
