package cn.ld.infrastructure.database.mapper;

import cn.ld.client.dto.query.PrizeListQuery;
import cn.ld.infrastructure.database.dataObject.PrizeDB;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【ld_prize】的数据库操作Mapper
* @createDate 2022-12-11 17:32:33
* @Entity cn.ld.user.po.Prize
*/
public interface PrizeMapper extends BaseMapper<PrizeDB> {

    IPage<PrizeDB> page(@Param("page") Page<PrizeDB> prizeDBPage,@Param("query") PrizeListQuery query);

    /**
     * 扣减奖品数量
     * @param prizeId 奖品id
     * @param number 扣减数量
     */
    int reduceInventory(@Param("prizeId") Long prizeId, @Param("number") Integer number);
}




