package cn.ld.infrastructure.convertor;
import cn.ld.domain.user.UserName;
import cn.ld.domain.user.PassWord;
import java.time.LocalDateTime;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.ld.domain.user.UserEntity;
import cn.ld.infrastructure.database.dataObject.UserDB;

/**
 * @author mojo
 * @description: DO 和 Entity 转换
 * @date 2022/12/12 0012 15:14
 */
public class UserConvertor {

    /**
     * UserEntity转UserDB
     */
    public static UserDB toUserDB(UserEntity entity) {
        UserDB userDB = new UserDB();
        userDB.setId(entity.getId());
        userDB.setUsername(entity.getUsername().getUsername());
        userDB.setPassword(entity.getPassword().getEncrypt().getPassword());
        userDB.setName(entity.getName());
        userDB.setPhone(entity.getPhone());
        userDB.setCreateTime(entity.getCreateTime());
        userDB.setCreator("admin");
        userDB.setUpdateTime(entity.getUpdateTime());
        userDB.setUpdater("admin");
        return userDB;
    }

    /**
     * UserDB转UserEntity
     */
    public static UserEntity toUserEntity(UserDB userDB) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDB.getId());
        userEntity.setUsername(new UserName(userDB.getUsername()));
        userEntity.setPassword(new PassWord(new PassWord.Encrypt(userDB.getPassword())));
        userEntity.setName(userDB.getName());
        userEntity.setPhone(userDB.getPhone());
        userEntity.setCreateTime(userDB.getCreateTime());
        userEntity.setUpdateTime(userDB.getUpdateTime());
        return userEntity;
    }
}
