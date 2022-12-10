package cn.ld.config.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author mojo
 * @description: 成功信息
 * @date 2022/12/10 0010 15:53
 */
@Builder
@ToString
@Getter
public class SuccessInfo extends ResultInfo{

    protected static final Integer DEFAULT_CODE = 20000;
    protected static final String DEFAULT_MESSAGE = "操作成功";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Object data;

    protected SuccessInfo(Object data){
        super(true,DEFAULT_CODE,DEFAULT_MESSAGE);
        this.data=data;
    }
}
