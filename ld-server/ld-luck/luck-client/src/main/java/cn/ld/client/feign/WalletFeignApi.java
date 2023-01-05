package cn.ld.client.feign;

import cn.ld.client.feign.form.UpdateWalletForm;
import cn.ld.client.feign.vo.WalletUpdateResultVO;
import cn.ld.config.constant.ServerNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/4 0004 22:35
 */
@FeignClient(name = ServerNameConstants.WALLET)
public interface WalletFeignApi {

    @PostMapping("/v1/feign/wallet/updateWallet")
    WalletUpdateResultVO updateBalance(@RequestBody UpdateWalletForm form);

    @GetMapping("/v1/feign/wallet/initUserWallet")
    void initUserWallet(Long userId);
}
