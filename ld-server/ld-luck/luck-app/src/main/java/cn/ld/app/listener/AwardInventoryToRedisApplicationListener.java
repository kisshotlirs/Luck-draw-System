package cn.ld.app.listener;

import cn.ld.app.listener.event.ActivityCreateEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/27 0027 21:55
 */
public class AwardInventoryToRedisApplicationListener implements ApplicationListener<ActivityCreateEvent> {

    @Override
    public void onApplicationEvent(ActivityCreateEvent activityCreateEvent) {

    }
}
