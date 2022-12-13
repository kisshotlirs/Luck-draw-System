package cn.ld.app.assembler;
import cn.ld.domain.user.UserName;
import cn.ld.domain.user.PassWord;

import java.time.LocalDateTime;

import cn.ld.client.dto.cmd.UserRegisterCmd;
import cn.ld.client.dto.data.UserVO;
import cn.ld.domain.user.UserEntity;

/**
 * @author mojo
 * @description: entity 和 vo 转换
 * @date 2022/12/12 0012 12:52
 */
public class UserAssembler {

    public static UserEntity cmdToEntity(UserRegisterCmd cmd) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(new UserName(cmd.getUsername()));

        String password = PassWord.getEncryptPassword(cmd.getPassword());
        userEntity.setPassword(new PassWord(new PassWord.Encrypt(password)));
        userEntity.setName(cmd.getName());
        userEntity.setPhone(cmd.getPhone());
        userEntity.setCreateTime(LocalDateTime.now());
        userEntity.setUpdateTime(LocalDateTime.now());
        return userEntity;
    }

    public static UserVO toUserVO(UserEntity userEntity) {
        UserVO userVO = new UserVO();
        userVO.setId(userEntity.getId());
        userVO.setUsername(userEntity.getUsername().getUsername());
        userVO.setName(userEntity.getName());
        userVO.setPhone(userEntity.getPhone());
        userVO.setCreateTime(LocalDateTime.now());
        userVO.setUpdateTime(LocalDateTime.now());
        return userVO;
    }
}
