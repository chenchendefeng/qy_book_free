package com.only.tech.activity.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.activity.mapper.StartPageMapper;
import com.only.tech.constant.Constants;
import com.only.tech.entity.activity.StartPage;
import ooh.chaos.service.OSSPicService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * 服务实现类-开屏页
 * @author shutong
 * @since 2019/05/06
 */
@Service
public class StartPageServiceImpl extends ServiceImpl<StartPageMapper, StartPage> implements StartPageService {

    @Autowired
    private OSSPicService oSSPicService;

    @Override
    public void deleteById(Long id) {

        //查询开屏页信息,获取文件名
        StartPage startPage=this.getById(id);
        if(startPage==null){
            return ;
        }

        //删除oss文件
        String fileUrl=startPage.getFileUrl();
        if(StringUtils.isNotBlank(fileUrl)){
            String fileName=fileUrl.substring(fileUrl.lastIndexOf("/"),fileUrl.length());
            this.oSSPicService.deleteFile(Constants.OSS_STARTPAGE,fileName);
        }

        //删除开屏页信息
        super.removeById(id);

    }

    @Override
    public StartPage getCurStartPage(String channelCode, String clientType) {

        QueryWrapper<StartPage> wrapper = new QueryWrapper<StartPage>();

        wrapper.eq("status", 1);

        if (StringUtils.isNotBlank(channelCode)) {
            wrapper.apply("( channelCodes like '%"+channelCode+"%' or channelCodes = '' )");
        }

        if(StringUtils.isNotBlank(clientType) && !"all".equalsIgnoreCase(clientType)){
            wrapper.apply("( clientType = '"+clientType+"' or clientType = 'all' or clientType = '' )");
        }

        Date now=new Date();
        wrapper.le("beginDate",now);
        wrapper.ge("endDate",now);


        List<StartPage> resultList=super.list(wrapper);

        if( resultList!=null && resultList.size()>0){
            return resultList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<StartPage> listByStatusAndChannelCode(String status, String channelCode) {

        QueryWrapper<StartPage> wrapper = new QueryWrapper<StartPage>();

        if (StringUtils.isNotBlank(status) && !"all".equalsIgnoreCase(status)) {
            wrapper.eq("status", status);
        }

        if(StringUtils.isNotBlank(channelCode) && !"all".equalsIgnoreCase(channelCode)){
            wrapper.like("channelCodes",channelCode);
        }

        return super.list(wrapper);
    }





}
