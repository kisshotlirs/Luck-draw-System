package cn.ld.client.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 16:39
 */
@Data
public class RuleListQuery extends PageQuery {

    private Long id;

    private String ruleName;
}
