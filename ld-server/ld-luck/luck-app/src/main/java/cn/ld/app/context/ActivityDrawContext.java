package cn.ld.app.context;

import cn.ld.client.dto.vo.ActivityConfigVO;
import cn.ld.client.dto.vo.AwardVO;
import cn.ld.domain.award.AwardEntity;
import cn.ld.domain.record.RecordEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author mojo
 * @description: 抽奖活动 上下文
 * @date 2022/12/28 0028 18:12
 */
@Data
@Accessors(chain = true)
public class ActivityDrawContext {

    private ActivityConfigVO activityConfigVO;

    /**
     * 抽奖算法获得到的奖项
     */
    private AwardVO awardVO;

    private AwardEntity awardEntity;

    /**
     * 是否中奖
     */
    private Boolean isWinTheLottery;

    /**
     * 是否可见
     */
    private Boolean isShow;

    /**
     * 中奖记录id
     */
    private Long recordId;
}
