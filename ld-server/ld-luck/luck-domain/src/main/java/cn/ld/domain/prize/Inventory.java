package cn.ld.domain.prize;

import cn.ld.config.exception.ldException;
import lombok.Data;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/16 0016 21:49
 */
@Data
public class Inventory {

    private Integer inventory;

    public Inventory(Integer inventory) {
        if (inventory < 0){
            throw new ldException("库存数量有误，请大于等于0");
        }
        this.inventory = inventory;
    }
}
