package com.only.tech.exposeinfz.user.api;

import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.base.result.ResultDto;
import com.only.tech.exposeinfz.user.dto.FaqDto;

/**
 * @author HUA MAN LOU
 * @since 2019/5/20
 */
public interface FaqInfz {

    PageData<FaqDto> getPage(Integer status, String channle, PageReq pageReq);

    FaqDto getFaq(Long id);

    ResultDto insertFaq(FaqDto faqDto);

    ResultDto updateFaq(FaqDto faqDto);

    ResultDto deleteFaq(Long id);
}
