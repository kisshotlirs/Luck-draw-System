package cn.ld.client.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AcceptPrizeAddCmd extends Command {

    @NotNull(message = "抽奖记录id不为空")
    private Long recordId;

    /**
     * 电话
     */
    @NotNull(message = "电话不为空")
    private String phone;

    /**
     * 地址
     */
    @NotNull(message = "地址不为空")
    private String address;
}
