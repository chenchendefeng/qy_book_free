package com.only.tech.exposeinfz.payment.api;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/21
 */
public interface DedutionInfz {

    void apply(Long uid);

    void checkOrder();
}
