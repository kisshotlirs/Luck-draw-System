package cn.ld.domain.record;

import cn.ld.config.enums.RecordStatusEnum;
import cn.ld.config.util.AssertUtil;
import lombok.Getter;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/29 0029 21:44
 */
@Getter
public class RecordStatus {

    /**
     * 状态（0，1，2，3）
     */
    private RecordStatusEnum state;

    public RecordStatus(Integer state) {
        AssertUtil.isTrue(state<0,"记录状态无效");

        if (RecordStatusEnum.STATUE_0.getValue().equals(state)){
            this.state = RecordStatusEnum.STATUE_0;
            return;
        }
        if (RecordStatusEnum.STATUE_1.getValue().equals(state)){
            this.state = RecordStatusEnum.STATUE_1;
            return;
        }
        if (RecordStatusEnum.STATUE_2.getValue().equals(state)){
            this.state = RecordStatusEnum.STATUE_2;
            return;
        }
        if (RecordStatusEnum.STATUE_3.getValue().equals(state)){
            this.state = RecordStatusEnum.STATUE_3;
            return;
        }
        AssertUtil.isTrue(true,"记录状态无效");
    }
}
