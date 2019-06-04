package com.only.tech.admin.service.facade;

import com.alibaba.dubbo.config.annotation.Reference;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.exposeinfz.activity.api.ActivityInfz;
import com.only.tech.exposeinfz.activity.api.ActivityRuleInfz;
import com.only.tech.exposeinfz.activity.api.AwardInfoInfz;
import com.only.tech.exposeinfz.activity.dto.ActivityRuleDto;
import com.only.tech.exposeinfz.activity.dto.AwardInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * facade: 活动规则
 * @author shutong
 * @since 2019/03/13
 */
@Service
public class ActivityRuleFacade {

	@Reference
	private ActivityRuleInfz ruleInfz;

    /**
     * 查询所有
     * @return
     */
    public List<ActivityRuleDto> listAll() {
        return this.ruleInfz.listAll();
    }
}
