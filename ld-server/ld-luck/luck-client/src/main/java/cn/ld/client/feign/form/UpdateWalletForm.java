package cn.ld.client.feign.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/4 0004 21:52
 */
@Data
public class UpdateWalletForm {

    private Long userId;

    private BigDecimal updateMoney;
}
