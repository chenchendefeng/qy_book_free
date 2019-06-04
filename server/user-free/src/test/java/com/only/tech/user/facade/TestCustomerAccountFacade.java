package com.only.tech.user.facade;

import com.only.tech.user.UserFreeApplicationTests;
import com.only.tech.user.service.facade.CustomerAccountFacade;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
public class TestCustomerAccountFacade extends UserFreeApplicationTests {

    @Autowired
    private CustomerAccountFacade accountFacade;

    @Test
    public void create(){
        Long cuId = Long.valueOf("1");
        boolean creat = accountFacade.creat(cuId);
        Assert.assertNotNull(creat);

    }


    @Test
    public void cashChanage(){
        Long cuId = Long.valueOf("1");
        Long money = Long.valueOf("1");

        boolean change = accountFacade.rmbChange(cuId, money);
        Assert.assertNotNull(change);

    }


    @Test
    public void goldChanage(){
        Long cuId = Long.valueOf("1");
        Long money = Long.valueOf("1");

        boolean change = accountFacade.goldChanage(cuId, money);
        Assert.assertNotNull(change);

    }
}
