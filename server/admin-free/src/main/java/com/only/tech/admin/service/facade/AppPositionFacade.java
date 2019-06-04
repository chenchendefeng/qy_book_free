package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.exposeinfz.activity.api.ActivityRuleInfz;
import com.only.tech.exposeinfz.activity.api.AppPositionInfz;
import com.only.tech.exposeinfz.activity.dto.ActivityRuleDto;
import com.only.tech.exposeinfz.activity.dto.AppPositionDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * facade: 页面元素位置
 * @author shutong
 * @since 2019/03/13
 */
@Service
public class AppPositionFacade {

	@Reference
	private AppPositionInfz appPositionInfz;

    /**
     * 查询所有
     * @return
     */
    public List<AppPositionDto> listAll() {
        return this.appPositionInfz.listAll();
    }
}
