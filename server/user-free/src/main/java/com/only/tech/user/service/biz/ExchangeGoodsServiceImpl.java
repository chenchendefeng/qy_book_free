package com.only.tech.user.service.biz;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.ExchangeGoods;
import com.only.tech.user.mapper.ExchangeGoodsMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 兑换商品 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-22
 */
@Service
public class ExchangeGoodsServiceImpl extends ServiceImpl<ExchangeGoodsMapper, ExchangeGoods> implements ExchangeGoodsService {

    @Override
    public PageData<ExchangeGoods> pageByStatusAndType(Integer status, String exchangeType, PageReq pageReq) {
        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());
        QueryWrapper qw = new QueryWrapper();
        if (status != null){
            qw.eq("status",status);
        }
        if (StringUtils.isNotBlank(exchangeType)){
            qw.eq("exchangeType",exchangeType);
        }
        qw.orderByDesc("updateTime");
        this.list(qw);

        PageData pageData = new PageData(page);

        return pageData;
    }
}
