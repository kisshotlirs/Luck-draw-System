package cn.ld.app.user.query;

import cn.ld.app.assembler.UserAssembler;
import cn.ld.client.dto.data.UserVO;
import cn.ld.client.dto.query.UserListByParamQuery;
import cn.ld.domain.gateway.UserGateway;
import cn.ld.domain.user.UserEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mojo
 * @description: 用户分页查询执行器
 * @date 2022/12/13 0013 23:03
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserListByParamQueryExe {

    private final UserGateway userGateway;

    /**
     * 用户分页查询
     */
    public IPage<UserVO> execute(UserListByParamQuery query) {
        IPage<UserEntity> entityIPage = userGateway.listByQuery(query);
        return entityIPage.convert(UserAssembler::toUserVO);
    }
}
