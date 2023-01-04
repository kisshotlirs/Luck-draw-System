package cn.ld.client.feign.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/4 0004 21:47
 */
@Data
@Accessors(chain = true)
public class WalletUpdateResultVO {

    private Boolean result;
}
