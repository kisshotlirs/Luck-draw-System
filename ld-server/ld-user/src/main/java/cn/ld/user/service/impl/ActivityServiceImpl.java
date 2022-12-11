package cn.ld.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ld.user.po.Activity;
import cn.ld.user.service.ActivityService;
import cn.ld.user.mapper.ActivityMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【ld_activity】的数据库操作Service实现
* @createDate 2022-12-11 17:33:24
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
    implements ActivityService{

}




