package cn.ld.adapter.web;

import cn.ld.client.api.UserService;
import cn.ld.client.dto.cmd.UserRegisterCmd;
import cn.ld.client.dto.cmd.UserUpdateCmd;
import cn.ld.client.dto.data.UserVO;
import cn.ld.client.dto.query.UserListByParamQuery;
import cn.ld.client.dto.query.UserLoginQuery;
import cn.ld.common.annotation.ResponseResult;
import cn.ld.config.util.SecurityUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author mojo
 * @description: 用户 控制层
 * @date 2022/12/11 0011 22:00
 */
@Slf4j
@AllArgsConstructor
@ResponseResult
@RestController("/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserVO register(@RequestBody @Validated UserRegisterCmd cmd){
        return userService.register(cmd);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated UserLoginQuery query){
        return userService.login(query);
    }

    @GetMapping("/one")
    public UserVO getOne(@RequestParam("id") Long id){

        System.out.println(SecurityUtil.getUserName());

        return userService.getOne(id);
    }

    @PostMapping("/update")
    public UserVO update(@RequestBody @Validated UserUpdateCmd cmd){
        return userService.update(cmd);
    }
}
