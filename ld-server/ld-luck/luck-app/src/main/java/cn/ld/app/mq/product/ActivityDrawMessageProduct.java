package cn.ld.app.mq.product;

import cn.hutool.core.util.IdUtil;
import cn.ld.app.context.ActivityDrawContext;
import cn.ld.config.dto.ActivityDrawMessage;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: 抽奖活动 消息生产者
 * @date 2022/12/29 0029 11:47
 */
@Slf4j
@Component
@AllArgsConstructor
public class ActivityDrawMessageProduct {

    private final RocketMQTemplate rocketMQTemplate;

    public Boolean send(ActivityDrawContext context){
        ActivityDrawMessage activityDrawMessage = new ActivityDrawMessage();
        activityDrawMessage.setUuid(IdUtil.simpleUUID());
        activityDrawMessage.setBody(JSON.toJSONString(context));

        Message<ActivityDrawMessage> message = MessageBuilder
                .withPayload(activityDrawMessage).build();

        SendResult sendResult = rocketMQTemplate.syncSend("activity-draw-topic", message);
        if (SendStatus.SEND_OK.equals(sendResult.getSendStatus())){
            //消息发送成功
            log.info("消息发送成功，业务ID：{}，uuid：{}",
                    activityDrawMessage.getId(),
                    activityDrawMessage.getUuid());
            return Boolean.TRUE;
        }
        log.info("消息发送失败");
        return Boolean.FALSE;
    }
}
