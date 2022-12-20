package cn.ld.domain.rule;

import cn.ld.config.exception.LdException;
import lombok.Data;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 16:28
 */
@Data
public class MinNumber {

    private Integer number;

    public MinNumber(Integer number) {
        if (number<1){
            throw new LdException("规则数量必须大于等于1！");
        }
        this.number = number;
    }
}
