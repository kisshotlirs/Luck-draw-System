package cn.ld.client.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mojo
 * @description: 用户分页查询请求
 * @date 2022/12/11 0011 19:53
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserListByParamQuery extends PageQuery {

    private Long id;

    private String name;

    private String phone;
}
