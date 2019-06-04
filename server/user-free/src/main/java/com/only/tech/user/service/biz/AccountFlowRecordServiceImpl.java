package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.entity.user.AccountFlowRecord;
import com.only.tech.entity.user.Customer;
import com.only.tech.user.mapper.AccountFlowRecordMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 * 账户流水 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-05
 */
@Service
public class AccountFlowRecordServiceImpl extends ServiceImpl<AccountFlowRecordMapper, AccountFlowRecord> implements AccountFlowRecordService {

    /**
     * 查询账户流水（金豆or现金）
     * @param cuId
     * @param currencyType
     * @return
     */
    @Override
    public List<AccountFlowRecord> listByCondition(Long cuId, String currencyType) {

        QueryWrapper<AccountFlowRecord> wrapper = new QueryWrapper<AccountFlowRecord>();

        if(StringUtils.isNotBlank(currencyType)){
           wrapper.eq("currencyType",currencyType);
        }

        if(cuId!=null){
            wrapper.eq("cuId",cuId);
        }
        return super.list(wrapper);
    }

}
