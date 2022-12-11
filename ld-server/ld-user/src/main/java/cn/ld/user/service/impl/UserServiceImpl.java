package cn.ld.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ld.user.po.User;
import cn.ld.user.service.UserService;
import cn.ld.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【ld_user】的数据库操作Service实现
* @createDate 2022-12-11 17:29:39
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




