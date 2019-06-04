package com.only.tech.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.dto.user.ExchangeOrderDto;
import com.only.tech.entity.user.ExchangeOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 兑换订单 Mapper 接口
 * </p>
 *
 * @author zzb
 * @since 2019-05-22
 */
@Repository
public interface ExchangeOrderMapper extends BaseMapper<ExchangeOrder> {

    List<ExchangeOrderDto> dtoList(@Param("cuId") Long cuId, @Param("orderStatus")Integer orderStatus, @Param("startTime")String startTime, @Param("endTime")String endTime);
}
