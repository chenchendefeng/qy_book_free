package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.Faq;
import com.only.tech.exposeinfz.user.dto.FaqDto;
import com.only.tech.user.common.model.PaginationDto;
import com.only.tech.user.dto.FaqRespDto;

import java.util.List;

/**
 * <p>
 * FAQ 服务类
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019/5/7
 */
public interface FaqService extends IService<Faq> {

    PageData<FaqRespDto> getFaqList(String channle, PageReq pageReq);

    List<FaqDto> getFaqDtoList(Integer status, String channle);
}
