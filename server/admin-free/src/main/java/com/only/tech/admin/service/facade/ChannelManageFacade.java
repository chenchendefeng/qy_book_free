package com.only.tech.admin.service.facade;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.only.tech.admin.service.biz.IChannleManageService;
import com.only.tech.dto.admin.ChannleDto;
import com.only.tech.entity.admin.ChannleManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HUA MAN LOU
 * @since 2019/5/15
 */
@Slf4j
@Service
public class ChannelManageFacade {

    @Autowired
    private IChannleManageService iChannleManageService;

    public List<ChannleDto> getList() {

        List<ChannleDto> resultData = new ArrayList<>();

        Wrapper qw = new QueryWrapper<ChannleManage>();
        List<ChannleManage> list = iChannleManageService.list(qw);
        if (list != null && !list.isEmpty()){

            list.stream().forEach(channle -> {
                ChannleDto channleDto = new ChannleDto();
                channleDto.setChannle(channle.getChannle());
                channleDto.setName(channle.getName());
                resultData.add(channleDto);
            });
        }

        return resultData;
    }
    
    public Map<String, String> getChannelMap() {
    	
    	Map<String, String> resultData = new HashMap<>();
    	Wrapper qw = new QueryWrapper<ChannleManage>();
    	List<ChannleManage> list = iChannleManageService.list(qw);
    	if (list != null && !list.isEmpty()){
    		
    		list.stream().forEach(channle -> {
    			resultData.put(channle.getChannle(), channle.getName());
    		});
    	}
    	
    	return resultData;
    }


    public List<String> getChannelList() {
        Wrapper qw = new QueryWrapper<ChannleManage>();
        List<ChannleManage> list = iChannleManageService.list(qw);
        List<String> channelList = new ArrayList<>();
        if (list != null && !list.isEmpty()){
            list.stream().forEach(channle -> {
                channelList.add(channle.getChannle());
            });
        }
        return channelList;
    }
}
