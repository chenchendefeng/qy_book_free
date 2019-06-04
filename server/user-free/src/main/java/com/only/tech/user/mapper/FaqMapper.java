package com.only.tech.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.only.tech.entity.user.Faq;
import com.only.tech.exposeinfz.user.dto.FaqDto;
import com.only.tech.user.dto.FaqRespDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * FAQ Mapper 接口
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/5/20
 */
@Repository
public interface FaqMapper extends BaseMapper<Faq> {

    List<FaqRespDto> getFaqList(@Param(value = "channle")String channle);

    List<FaqDto> getFaqDtoList(@Param(value = "status") Integer status, @Param(value = "channle") String channle);
}
