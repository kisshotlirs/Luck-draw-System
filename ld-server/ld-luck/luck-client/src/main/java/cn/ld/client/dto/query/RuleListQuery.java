package cn.ld.client.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 16:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RuleListQuery extends PageQuery {

    private Long id;

    private List<Long> ids;

    private String ruleName;
}
