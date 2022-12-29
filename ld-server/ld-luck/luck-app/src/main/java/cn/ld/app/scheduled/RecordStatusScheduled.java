package cn.ld.app.scheduled;

import cn.ld.app.activity.cmd.RedisDeductionAwardNumberDrawExe;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: 刷新记录状态的定时任务
 * @date 2022/12/29 0029 19:54
 */
@Slf4j
@Component
@AllArgsConstructor
public class RecordStatusScheduled {

    private final RedisDeductionAwardNumberDrawExe drawExe;

    /**
     * 每隔五分钟执行一次
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void deductionOfInventoryAndUpdateRecordStatus(){

        /**
         * 定时扫描用户不可见状态的中奖记录，然后对比当前时间和数据创建时间，
         * 发现两者相隔10分钟，那么，定时任务就将这个数据查询出来，再执行一般方案三消费流程
         */

    }
}
