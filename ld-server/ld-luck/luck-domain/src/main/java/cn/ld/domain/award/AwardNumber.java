package cn.ld.domain.award;

import cn.ld.config.exception.LdException;
import lombok.Data;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 18:43
 */
@Data
public class AwardNumber {

    private Integer number;

    public AwardNumber(Integer number) {
        if (number<0){
            throw new LdException("奖项数量不合法，需要大于等于0");
        }
        this.number = number;
    }

}
