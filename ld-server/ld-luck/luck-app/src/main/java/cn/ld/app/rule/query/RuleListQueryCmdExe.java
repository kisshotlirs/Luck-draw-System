package cn.ld.app.rule.query;

import cn.ld.client.dto.query.RuleListQuery;
import cn.ld.client.dto.vo.RuleVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/17 0017 17:13
 */
@Component
@AllArgsConstructor
public class RuleListQueryCmdExe {

    public IPage<RuleVO> page(RuleListQuery query) {
        return null;
    }
}
