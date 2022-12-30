package cn.ld.client.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/29 0029 22:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RecordListQuery extends PageQuery {

    private Long userId;

    private Long activityId;

    /**
     * 是否中奖
     */
    private Boolean winTheLottery;

    /**
     * 记录状态
     */
    private Integer state;
}
