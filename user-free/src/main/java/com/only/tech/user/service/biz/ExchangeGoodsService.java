package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.ExchangeGoods;

/**
 * <p>
 * 兑换商品 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-22
 */
public interface ExchangeGoodsService extends IService<ExchangeGoods> {

    PageData<ExchangeGoods> pageByStatusAndType(Integer status, String exchangeType, PageReq pageReq);
}
