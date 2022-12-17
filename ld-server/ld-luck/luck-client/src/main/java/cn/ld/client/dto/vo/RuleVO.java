package cn.ld.client.dto.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 16:35
 */
@Data
public class RuleVO {

    private Long id;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 最大可参与次数
     */
    private Integer maxJoinNumber;

    /**
     * 最大可中奖次数
     */
    private Integer maxWinningNumber;

    private LocalDateTime createTime;

    private String creator;

    private LocalDateTime updateTime;

    private String updater;
}
