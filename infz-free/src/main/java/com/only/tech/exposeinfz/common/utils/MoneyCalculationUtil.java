package com.only.tech.exposeinfz.common.utils;

/**
 *  币计算工具类
 * @author ZHI ZUN BAO
 * @since 2018/10/27
 */
public class MoneyCalculationUtil {

    /**
     * 计算金额
     * @param allwords
     * @param words
     * @param price
     * @return
     */
    public static int getBookMoney(Integer allwords, Integer words, Integer price) {
        int d = allwords / words;
        int m = allwords % words;

        int p = m != 0?d+1:d;

        price = price < 0?0:price;

        int amount = p * price;
        return amount;
    }
}
