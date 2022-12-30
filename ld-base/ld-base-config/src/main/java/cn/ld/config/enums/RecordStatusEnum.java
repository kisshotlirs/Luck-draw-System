package cn.ld.config.enums;

import lombok.Getter;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/29 0029 21:43
 */
@Getter
public enum RecordStatusEnum {

    STATUE_0(0,"用户不可见"),
    STATUE_1(1,"待运营人员确认"),
    STATUE_2(2,"待用户签收"),
    STATUE_3(3,"流程结束")
    ;

    private Integer value;

    private String description;

    RecordStatusEnum(Integer value,String description){
        this.value = value;
        this.description = description;
    }
}
