package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.AccountFlowRecord;
import com.only.tech.entity.user.Customer;
import com.only.tech.enums.AccountChangeSpecificTypeEnum;
import com.only.tech.exposeinfz.user.api.AccountFlowRecordInfz;
import com.only.tech.exposeinfz.user.api.CustomerInfz;
import com.only.tech.user.service.biz.AccountFlowRecordService;
import com.only.tech.user.service.biz.CustomerService;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * infz实现类： 账户流水信息
 * @author shutong
 * @since 2019/05/09
 */
@Slf4j
@Component
@Service(interfaceClass = AccountFlowRecordInfz.class)
public class AccountFlowRecordInfzImpl implements AccountFlowRecordInfz {

    @Autowired
    private AccountFlowRecordService accountFlowService;

    /**
     * 添加or修改
     * @param flowRecord
     */
    @Override
    public void saveOrUpdate(AccountFlowRecord flowRecord) {
        String specificType = flowRecord.getSpecificType();
        if (AccountChangeSpecificTypeEnum.READ_30_SECONDS_AWARD.equals(specificType)){
            QueryWrapper qw = new QueryWrapper();
            qw.eq("specificType",specificType);
            Date now = new Date();
            qw.between("createTime", DateFormatUtil.getStartDate(now),DateFormatUtil.getEndDate(now));
            AccountFlowRecord record = accountFlowService.getOne(qw);
            if (record != null){
                Long amount = record.getAmount();
                Long recordAmount = flowRecord.getAmount();
                record.setAmount(amount+recordAmount);
                accountFlowService.updateById(record);
                return;
            }
        }

        this.accountFlowService.saveOrUpdate(flowRecord);
    }

    /**
     * 分页查询账户流水（金豆or现金）
     * @param pageReq
     * @param cuId
     * @param currentType
     * @return
     */
    @Override
    public PageData<AccountFlowRecord> pageListByCondition(PageReq pageReq, Long cuId, String currentType) {

        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());
        List<AccountFlowRecord> flowList = this.accountFlowService.listByCondition(cuId,currentType);
        PageData pageData = new PageData(page);
        pageData.setData(flowList);

        return pageData;

    }
}
