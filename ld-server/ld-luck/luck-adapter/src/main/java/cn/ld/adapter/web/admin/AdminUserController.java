package cn.ld.adapter.web.admin;

import cn.ld.client.api.UserService;
import cn.ld.client.dto.vo.UserVO;
import cn.ld.client.dto.query.UserListByParamQuery;
import cn.ld.common.annotation.ResponseResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author mojo
 * @description: 管理员
 * @date 2022/12/14 0014 20:19
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RestController("/admin/v1/user")
public class AdminUserController {

    private final UserService userService;

    @PostMapping("/one")
    public UserVO getOne(@RequestParam("id") Long id){
        return userService.getOne(id);
    }

    @GetMapping("/page")
    public IPage<UserVO> page(@RequestBody UserListByParamQuery query){
        return userService.page(query);
    }

}
