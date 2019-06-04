package com.only.tech.user.service.facade;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import com.only.tech.base.PageData;
import com.only.tech.base.PageReq;
import com.only.tech.entity.user.AppVersionManage;
import com.only.tech.exposeinfz.admin.dto.AppVersionDto;
import com.only.tech.user.common.constant.Constants;
import com.only.tech.user.dto.VersionManageDto;
import com.only.tech.user.service.biz.AppVersionManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2018/12/26
 */
@Service
@Slf4j
public class AppVersionManageFacade {

    @Autowired
    private AppVersionManageService appVersionManageService;


    public AppVersionManage getByVersion(String version) {
        Wrapper qw = new QueryWrapper<AppVersionManage>().eq("version",version);
        AppVersionManage appVersionManage = appVersionManageService.getOne(qw);
        return appVersionManage;
    }

    public AppVersionManage getByVersionCodeAndClientType(Integer versionCode, String clientType) {
        Wrapper qw = new QueryWrapper<AppVersionManage>().eq("versionCode",versionCode).eq("clientType",clientType);
        AppVersionManage appVersionManage = appVersionManageService.getOne(qw);
        return appVersionManage;

    }

    /**
     * 是否审核
     * @param versionCode
     * @param clientType
     * @return
     */
    public boolean check(Integer versionCode, String clientType) {
        AppVersionManage versionManage = getByVersionCodeAndClientType(versionCode,clientType);

        if (versionManage == null){
            return false;
        }

        Integer audit = versionManage.getAudit();
        if (audit == 1){
            return true;
        }
        return false;

    }



    public PageData<AppVersionDto> getPage(PageReq pageReq) {

        Page page = PageHelper.startPage(pageReq.getPageNo(), pageReq.getPageSize());
        Wrapper qw = new QueryWrapper<AppVersionManage>().orderByDesc("createDate");
        List<AppVersionManage> list = appVersionManageService.list(qw);

        PageData<AppVersionDto> pageData = new PageData(page);

        List<AppVersionDto> resultData = new ArrayList<>();

        if (list != null && !list.isEmpty()){
            list.stream().forEach(record -> {
                AppVersionDto dto = new AppVersionDto();

                BeanUtils.copyProperties(record,dto);

                resultData.add(dto);
            });
        }
        pageData.setData(resultData);

        return pageData;
    }


    public AppVersionDto getById(Integer id) {

        AppVersionManage versionManage = appVersionManageService.getById(id);
        if (versionManage != null){
            AppVersionDto appVersionDto = new AppVersionDto();
            BeanUtils.copyProperties(versionManage,appVersionDto);
            return appVersionDto;
        }
        return null;
    }

    public Boolean updateVsersion(AppVersionDto appVersionDto) {
        if (appVersionDto != null){
            Integer id = appVersionDto.getId();
            AppVersionManage versionManage = appVersionManageService.getById(id);
            if (versionManage == null){
                return false;
            }

            BeanUtils.copyProperties(appVersionDto,versionManage);

            String dtoVersion = appVersionDto.getVersion();
            Integer versionCode = getVersionCodeByVersion(dtoVersion);
            if (versionCode == null){
                return false;
            }
            versionManage.setVersionCode(versionCode);

            String miniVersion = appVersionDto.getMiniVersion();

            if (!StringUtils.isNullOrEmpty(miniVersion)){
                Integer miniVersionCode = getVersionCodeByVersion(miniVersion);
                if (miniVersionCode == null){
                    return false;
                }
                versionManage.setMiniVersionCode(miniVersionCode);
            }

            Date now = new Date();
            versionManage.setUpdateDate(now);


            boolean update = appVersionManageService.updateById(versionManage);
            return update;
        }
        return false;
    }

    public Boolean deleteVsersion(Integer id) {
        boolean remove = appVersionManageService.removeById(id);
        return remove;
    }

    public Boolean insertVsersion(AppVersionDto appVersionDto) {
        if (appVersionDto != null){
            String version = appVersionDto.getVersion();
            if (StringUtils.isNullOrEmpty(version)){
                return false;
            }
            AppVersionManage versionManage = getByVersion(version);
            if (versionManage != null){
                return false;
            }

            AppVersionManage appVersionManage = new AppVersionManage();
            BeanUtils.copyProperties(appVersionDto,appVersionManage);

            String dtoVersion = appVersionDto.getVersion();
            Integer versionCode = getVersionCodeByVersion(dtoVersion);
            if (versionCode == null){
                return false;
            }
            appVersionManage.setVersionCode(versionCode);

            String miniVersion = appVersionDto.getMiniVersion();

            if (!StringUtils.isNullOrEmpty(miniVersion)){
                Integer miniVersionCode = getVersionCodeByVersion(miniVersion);
                if (miniVersionCode == null){
                    return false;
                }
                appVersionManage.setMiniVersionCode(miniVersionCode);
            }

            Date now = new Date();
            appVersionManage.setCreateDate(now);
            appVersionManage.setUpdateDate(now);
            boolean save = appVersionManageService.save(appVersionManage);
            return save;
        }
        return false;
    }

    public Integer getVersionCodeByVersion(String dtoVersion) {

        Integer versionCode = null;
        String versionStr = dtoVersion.replace(".", "");
        try {
            versionCode = Integer.parseInt(versionStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return versionCode;
    }


    /**
     * 校验是否是最新版本，最新版本的更新信息
     * @param versionCode
     * @param clientType
     * @return
     */
    public VersionManageDto checkUpdate(Integer versionCode, String clientType) {
        //检查更新返回数据
        VersionManageDto versionManageDto = new VersionManageDto();

        //查询客户当前版本
        AppVersionManage clientVersion = getByVersionCodeAndClientType(versionCode,clientType);

        //查询当前最新版本
        AppVersionManage newVersionManage = getNewVersion(clientType);

        if (clientVersion != null){
            if (newVersionManage != null){

                Integer currentVersionCode = clientVersion.getVersionCode();
                Integer newVersionCode = newVersionManage.getVersionCode();

                String des = newVersionManage.getDes();
                versionManageDto.setDes(des);
                versionManageDto.setTitle(newVersionManage.getTitle());
                versionManageDto.setIntervalTime(newVersionManage.getIntervalTime());


                //最新版本无需更新
                if (newVersionCode.equals(currentVersionCode)){
                    versionManageDto.setType(Constants.VERSION_NO_UPDATE);
                } else {

                    Integer miniVersionCode = newVersionManage.getMiniVersionCode();

                    //强制更新
                    if (miniVersionCode > currentVersionCode){
                        versionManageDto.setType(Constants.VERSION_MANDATORY_UPDATE);
                    }else {
                        //提示更新
                        versionManageDto.setType(Constants.VERSION_PROMPT_UPDATE);
                    }
                    versionManageDto.setUrl(newVersionManage.getDownloadUrl());

                }
                return versionManageDto;
            }

        }else {
            //当前版本不存在，强制更新至最新版本
            if (newVersionManage != null){


                Integer newVersionCode = newVersionManage.getVersionCode();

                if (versionCode < newVersionCode ){
                    versionManageDto.setType(Constants.VERSION_MANDATORY_UPDATE);
                    versionManageDto.setUrl(newVersionManage.getDownloadUrl());
                    String des = newVersionManage.getDes();
                    versionManageDto.setDes(des);
                    versionManageDto.setTitle(newVersionManage.getTitle());
                    versionManageDto.setIntervalTime(newVersionManage.getIntervalTime());
                    return versionManageDto;
                }
            }
        }
        return null;
    }

    /**
     * 最新的可用版本
     * @return
     */
    public AppVersionManage getNewVersion(String clientType) {
        Wrapper qw = new QueryWrapper<AppVersionManage>().eq("clientType",clientType)
                .eq("enable",1).eq("audit",1).orderByDesc("versionCode");

        AppVersionManage versionManage = appVersionManageService.getOne(qw);

        return versionManage;
    }
}
