package cn.ld.client.dto.vo;

import lombok.Data;

import java.util.List;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 23:06
 */
@Data
public class ActivityConfigVO {

    private ActivityVO activityVO;

    private List<RuleVO> ruleVOList;

    private AwardVO awardVO;

}
