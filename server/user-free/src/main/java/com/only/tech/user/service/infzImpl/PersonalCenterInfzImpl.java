package com.only.tech.user.service.infzImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.PersonalCenter;
import com.only.tech.exposeinfz.user.api.PersonalCenterInfz;
import com.only.tech.user.service.biz.PersonalCenterService;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.service.OSSPicService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2019/3/7
 */
@Slf4j
@Component
@Service(interfaceClass = PersonalCenterInfz.class)
public class PersonalCenterInfzImpl implements PersonalCenterInfz {


    @Autowired
    private PersonalCenterService personalCenterService;

    @Autowired
    private OSSPicService ossPicService;


    @Override
    public PageData<PersonalCenter> pageByStatus(Integer status, PageReq pageReq) {

        Page page = PageHelper.startPage(pageReq.getPageNo(),pageReq.getPageSize());

        Wrapper qw = new QueryWrapper<>();
        if (status != null){
            ((QueryWrapper) qw).eq("status",status);
        }
        ((QueryWrapper) qw).orderByAsc("sort");

        personalCenterService.list(qw);

        return  new PageData<>(page);
    }

    @Override
    public PersonalCenter getById(Integer id) {
        return personalCenterService.getById(id);
    }

    @Override
    public boolean insert(PersonalCenter data) {
        if (data == null){
            return false;
        }

        Date now = new Date();
        data.setCreateDate(now);
        data.setUpdateDate(now);
        Integer sort = data.getSort();


        //设置排序
        if (sort == null){
            //获取配置集合
            Wrapper qw = new QueryWrapper<>().orderByAsc("sort");
            List<PersonalCenter> list = personalCenterService.list(qw);
            if (list.isEmpty()){
                sort = 1;
            }else {
                int size = list.size();
                PersonalCenter dbData = list.get(--size);
                sort = (dbData.getSort() + 1);
            }

        }

        data.setSort(sort);
        boolean save = personalCenterService.save(data);

        if (save){
            //修改排序
            Wrapper qw = new QueryWrapper<>().orderByAsc("sort");
            List<PersonalCenter> list = personalCenterService.list(qw);
            if (!list.isEmpty()){
                Integer personalCenterId = data.getId();

                for (PersonalCenter dbData: list) {
                    Integer dataId = dbData.getId();
                    Integer dataSort = dbData.getSort();
                    if (!dataId.equals(personalCenterId) && sort <= dataSort){
                        dataSort++;
                        data.setSort(dataSort);
                        personalCenterService.updateById(dbData);
                    }
                }
            }
        }

        return save;
    }


    @Override
    public boolean update(PersonalCenter personalCenter) {

        Date now = new Date();
        personalCenter.setUpdateDate(now);

        boolean update = personalCenterService.updateById(personalCenter);

        return update;
    }

    @Override
    public boolean updateStatus(Integer id, Integer status) {
        PersonalCenter personalCenter = personalCenterService.getById(id);
        if (personalCenter == null){
            return false;
        }
        personalCenter.setStatus(status);
        personalCenter.setUpdateDate(new Date());

        boolean update = personalCenterService.updateById(personalCenter);
        return update;
    }

    @Override
    public boolean delete(Integer id) {
        PersonalCenter personalCenter = personalCenterService.getById(id);
        if (personalCenter == null){
            return false;
        }
        String picUrl = personalCenter.getPicUrl();
        if (StringUtils.isNotBlank(picUrl)){
            ossPicService.deleteFile(picUrl);
        }

        boolean remove = personalCenterService.removeById(id);
        return remove;
    }
}
