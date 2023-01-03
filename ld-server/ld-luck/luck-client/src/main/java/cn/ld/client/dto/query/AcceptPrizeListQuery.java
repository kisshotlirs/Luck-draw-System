package cn.ld.client.dto.query;

import com.alibaba.cola.dto.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mojo
 * @description: TODO
 * @date 2023/1/3 0003 15:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AcceptPrizeListQuery extends PageQuery {

    private Long recordId;
}
