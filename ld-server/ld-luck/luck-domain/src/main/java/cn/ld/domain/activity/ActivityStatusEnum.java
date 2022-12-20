package cn.ld.domain.activity;

import lombok.Getter;

/**
 * @author mojo
 * @description: 活动状态（根据时间判断）
 * @date 2022/12/20 0020 15:35
 */
@Getter
public enum ActivityStatusEnum {

    NOT_START(0,"活动未开始"),
    END(1,"活动结束"),
    START(2,"活动进行中");

    private Integer value;

    private String description;

    ActivityStatusEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }
}
