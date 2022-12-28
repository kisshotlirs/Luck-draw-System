package cn.ld.config.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.ld.config.exception.LdException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author mojo
 * @description: TODO
 * @date 2022/12/28 0028 16:02
 */
@Slf4j
public class FileLoadUtil {

    public static String read(String fileName){
        String val = "";
        try {
            val = IoUtil.read(new FileInputStream(FileUtil.file(fileName)), CharEncoding.UTF_8);
        }catch (Exception e){
            log.error("文件路径读取失败 {}",fileName,e);
            throw new LdException(String.format("文件路径读取失败：%s",fileName));
        }
        return val;
    }
}
