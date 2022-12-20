package cn.ld.domain.activity;

import cn.ld.config.exception.LdCodeException;
import cn.ld.config.exception.LdException;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDateTime;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/20 0020 15:22
 */
@Getter
public class ActivityTime {

    /**
     * 活动开始时间
     */
    private LocalDateTime startTime;

    /**
     * 活动结束结束时间
     */
    private LocalDateTime endTime;

    public ActivityTime(LocalDateTime startTime, LocalDateTime endTime) {
        if (ObjectUtils.anyNull(startTime,endTime)){
            throw new LdException("活动时间不为空");
        }
        if (startTime.isAfter(endTime)){
            //throw new ldException("活动时间非法");
            throw new LdCodeException(5050,"活动时间非法");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ActivityStatusEnum getStatus(){
        return getStatus(LocalDateTime.now());
    }

    /**
     * 活动状态（根据时间判断）
     */
    public ActivityStatusEnum getStatus(LocalDateTime now){
        if (now.isBefore(this.startTime)){
            return ActivityStatusEnum.NOT_START;
        }
        if (now.isAfter(this.startTime) || now.isBefore(this.endTime)){
            return ActivityStatusEnum.START;
        }
        return ActivityStatusEnum.END;
    }
}
