package cn.ld.client.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/16 0016 22:09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PrizeListQuery extends PageQuery {

    private Long id;

    private String prizeName;

    /**
     * 类型（1：商品，2：金钱）
     */
    private Integer type;
}
