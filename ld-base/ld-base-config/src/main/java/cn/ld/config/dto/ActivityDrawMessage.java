package cn.ld.config.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author mojo
 * @description: 抽奖活动 MQ消息体
 * @date 2022/12/28 0028 22:46
 */
@Data
@Accessors(chain = true)
public class ActivityDrawMessage {

    /**
     * 业务唯一id
     */
    private Long id;

    private String uuid;

    /**
     * json内容对象
     */
    private String body;
}
