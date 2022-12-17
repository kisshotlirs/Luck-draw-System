package cn.ld.domain.rule;

import cn.ld.config.exception.ldException;
import lombok.Data;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 16:28
 */
@Data
public class MaxNumber {

    private Integer number;

    public MaxNumber(Integer number) {
        if (number<1){
            throw new ldException("规则次数必须大于等于1！");
        }
        this.number = number;
    }
}
