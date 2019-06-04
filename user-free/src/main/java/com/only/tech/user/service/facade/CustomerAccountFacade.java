package com.only.tech.user.service.facade;

import com.only.tech.entity.user.CustomerAccount;
import com.only.tech.user.service.biz.CustomerAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZHI ZUN BAO
 * @since 2019/5/5
 */
@Slf4j
@Service
public class CustomerAccountFacade {

    @Autowired
    private CustomerAccountService customerAccountService;


    public boolean creat(Long cuId){
        CustomerAccount account = customerAccountService.getCuId(cuId);
        if (account == null){
            account = new CustomerAccount();
            account.setCuId(cuId);
            account.setRmb(0L);
            account.setGold(0L);
            return customerAccountService.save(account);
        }
        return false;
    }

    /**
     * 变更账户
     * @param cuId
     * @param rmb
     * @param gold
     * @return
     */
    public boolean chanage(Long cuId,Long rmb,Long gold){
        CustomerAccount account = customerAccountService.getCuId(cuId);
        if (account != null){
            if (rmb != null && !rmb.equals(0)){
                Long amount = account.getRmb();
                rmb = amount + rmb;
                account.setRmb(rmb);
                if (account.getRmb() < 0){
                    return false;
                }

                if (rmb > 0){
                    Long rmbTotal = account.getRmbTotal();
                    account.setRmbTotal(rmbTotal+rmb);
                }

            }
            if (gold != null && !gold.equals(0)){
                Long amount = account.getGold();
                gold = amount + gold;
                account.setGold(gold);
                if (account.getGold() < 0){
                    return false;
                }
            }
            account.setChanged(1);
            return customerAccountService.updateById(account);
        }else {
            boolean creat = this.creat(cuId);
            if (creat){
                return chanage(cuId,rmb,gold);
            }
        }

        return false;
    }


    /**
     * 现金账户更改
     * @param cuId
     * @param money
     * @return
     */
    public boolean rmbChange(Long cuId,Long money){
        if (money == 0){
            return true;
        }
        CustomerAccount account = customerAccountService.getCuId(cuId);
        if (account != null){
            Long rmb = account.getRmb();
            rmb = rmb + money;
            account.setRmb(rmb);
            if (account.getRmb() < 0){
                return false;
            }
            if (money > 0){
                Long rmbTotal = account.getRmbTotal();
                account.setRmbTotal(rmbTotal+money);
            }
            account.setChanged(1);
            return customerAccountService.updateById(account);
        }else {
            boolean creat = this.creat(cuId);
            if (creat){
                return rmbChange(cuId,money);
            }
        }

        return false;
    }


    /**
     * 金币账户修改
     * @param cuId
     * @param money
     * @return
     */
    public boolean goldChanage(Long cuId,Long money){
        if (money == 0){
            return true;
        }
        CustomerAccount account = customerAccountService.getCuId(cuId);
        if (account != null){
            Long gold = account.getGold();
            gold = gold + money;
            account.setGold(gold);
            if (account.getGold() < 0){
                return false;
            }
            account.setChanged(1);
            return customerAccountService.updateById(account);
        }else {
            boolean creat = this.creat(cuId);
            if (creat){
                return goldChanage(cuId,money);
            }
        }

        return false;
    }


    /**
     * 检查账户是否变更
     * @param cuId
     * @return
     */
    public boolean checkChange(Long cuId) {
        CustomerAccount account = customerAccountService.getCuId(cuId);
        if (account != null){
            Integer changed = account.getChanged();

            return (changed != null && changed.equals(1));
        }
        return false;
    }

    /**
     * 修改变更
     * @param cuId
     * @return
     */
    public boolean modifiedChange(Long cuId) {
        CustomerAccount account = customerAccountService.getCuId(cuId);
        if (account != null){
            account.setChanged(0);
            return customerAccountService.updateById(account);
        }
        return false;
    }

    public CustomerAccount getCuId(Long cuId) {
        CustomerAccount account = customerAccountService.getCuId(cuId);
        if (account == null){
            account = new CustomerAccount();
            account.setCuId(cuId);
            account.setRmb(0L);
            account.setGold(0L);
            customerAccountService.save(account);
        }
        return account;
    }

    public boolean update(CustomerAccount account) {
        if (account == null){
            return false;
        }
        return customerAccountService.updateById(account);
    }
}
