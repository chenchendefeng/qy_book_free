package com.only.tech.user.service.facade;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.constant.Constants;
import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.entity.user.ExchangeGoods;
import com.only.tech.entity.user.SystemConfig;
import com.only.tech.enums.CurrencyTypeEnum;
import com.only.tech.user.dto.ExchangeGoodsDto;
import com.only.tech.user.dto.ExchangeGoodsPageDto;
import com.only.tech.user.service.biz.ExchangeGoodsService;
import com.only.tech.user.service.biz.SystemConfigService;
import ooh.chaos.util.NumUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/30
 */
@Service
public class ExchangeGoodsFacade {

    @Autowired
    private CustomerAccountFacade customerAccountFacade;

    @Autowired
    private SystemConfigFacade systemConfigFacade;

    @Autowired
    private ExchangeGoodsService exchangeGoodsService;


    public ExchangeGoodsPageDto getPageData(Long cuId) {
        ExchangeGoodsPageDto pageDto = new ExchangeGoodsPageDto();
        CustomerAccount customerAccount = customerAccountFacade.getCuId(cuId);
        pageDto.setGold(customerAccount.getGold());
        Double goldToRmb = systemConfigFacade.goldToRmbYuan(customerAccount.getGold());
        pageDto.setGoldToRmb(goldToRmb);

        pageDto.setRmb(NumUtil.div(customerAccount.getRmb(),100));

        List<ExchangeGoodsDto> goldGoodsList = getDtoByType(CurrencyTypeEnum.GOLD);
        pageDto.setGoldGoodsList(goldGoodsList);

        List<ExchangeGoodsDto> rmbGoodsList = getDtoByType(CurrencyTypeEnum.RMB);
        pageDto.setRmbGoodsList(rmbGoodsList);

        return pageDto;
    }

    private List<ExchangeGoodsDto> getDtoByType(CurrencyTypeEnum gold) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("status",1);
        qw.eq("exchangeType",gold.getType());
        qw.orderByAsc("sort");

        List<ExchangeGoods> list = exchangeGoodsService.list(qw);
        if (list.isEmpty()) {
            return new ArrayList<>();
        }

        List<ExchangeGoodsDto> dtoList = new ArrayList<>();
        for (ExchangeGoods goods: list) {
            ExchangeGoodsDto dto = new ExchangeGoodsDto();
            BeanUtils.copyProperties(goods,dto);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
