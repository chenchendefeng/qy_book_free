package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.activity.Welfare;

import java.util.List;

/**
 * <p>
 * 福利配置 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-10
 */
public interface WelfareService extends IService<Welfare> {

    List<Welfare> getByType(String novice, Integer showTime);

    PageData<Welfare> pageData(String type, Integer status, String rewardType, PageReq pageReq);

    boolean insert(Welfare welfare);

    boolean update(Welfare welfare);

    boolean updateStatus(Integer id, Integer status);
}
