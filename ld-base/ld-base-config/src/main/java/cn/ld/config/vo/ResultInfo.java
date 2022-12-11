package cn.ld.config.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

/**
 * @author mojo
 * @description: 返回结果信息
 * @date 2022/12/10 0010 14:59
 */
@Getter
public class ResultInfo {

    protected Boolean result;
    protected Integer code;
    /**
     * 字段为null，系统不显示
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String message;

    protected ResultInfo(Boolean result, Integer code, String message) {
        this.result = result;
        this.code = code;
        this.message = message;
    }


}
