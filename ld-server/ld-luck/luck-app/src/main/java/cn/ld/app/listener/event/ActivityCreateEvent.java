package cn.ld.app.listener.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/27 0027 22:04
 */
public class ActivityCreateEvent extends ApplicationEvent {

    /**
     * 活动创建id
     */
    private final Long activityId;

    public Long getActivityId() {
        return activityId;
    }

    public ActivityCreateEvent(Object source, Long activityId) {
        super(source);
        this.activityId = activityId;
    }
}
