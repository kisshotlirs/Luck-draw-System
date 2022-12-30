package cn.ld.client.dto.cmd;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/29 0029 22:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RecordUpdateStatusCmd {

    private Long id;

    /**
     * 是否中奖：0未中奖，1中奖
     */
    private Integer isWinning;

    private Integer status;
}
