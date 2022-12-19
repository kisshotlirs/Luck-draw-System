package cn.ld.client.dto.query;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/19 0019 19:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AwardListQuery extends PageQuery {

    private Long id;

    private Long awardName;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;
}
