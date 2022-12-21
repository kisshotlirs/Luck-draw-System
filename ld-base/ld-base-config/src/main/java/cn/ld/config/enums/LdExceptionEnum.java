package cn.ld.config.enums;

import cn.ld.config.vo.FailInfo;
import lombok.Getter;

/**
 * @author mojo
 * @description: 错误信息
 * @date 2022/12/20 0020 21:47
 */
@Getter
public enum LdExceptionEnum {

    ADD_ERROR(FailInfo.DEFAULT_CODE,"保存数据失败"),
    UPDATE_ERROR(FailInfo.DEFAULT_CODE,"修改数据失败"),
    DELETE_ERROR(FailInfo.DEFAULT_CODE,"删除数据失败");

    private Integer code;
    private String description;

    LdExceptionEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
