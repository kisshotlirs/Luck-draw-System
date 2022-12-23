package cn.ld.client.dto.vo;

import lombok.Data;

/**
 * @author mojo
 * @description: 用户抽奖返回结果
 * @date 2022/12/23 0023 14:14
 */
@Data
public class DrawResultVO {

    private String awardName;

    private String prizeName;

    /**
     * 是否中奖
     */
    private Boolean isDraw;
}
