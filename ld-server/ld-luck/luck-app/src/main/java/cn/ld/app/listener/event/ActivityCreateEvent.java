package cn.ld.app.listener.event;

import cn.ld.client.dto.vo.ActivityConfigVO;
import org.springframework.context.ApplicationEvent;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/27 0027 22:04
 */
public class ActivityCreateEvent extends ApplicationEvent {

    private final ActivityConfigVO activityConfigVO;

    public ActivityConfigVO getActivityConfigVO() {
        return activityConfigVO;
    }

    public ActivityCreateEvent(Object source, ActivityConfigVO activityConfigVO) {
        super(source);

        this.activityConfigVO = activityConfigVO;
    }
}
