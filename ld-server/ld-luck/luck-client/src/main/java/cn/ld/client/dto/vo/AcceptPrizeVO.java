package cn.ld.client.dto.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:20
 */
@Data
public class AcceptPrizeVO {

    private Long id;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    private LocalDateTime createTime;
}
