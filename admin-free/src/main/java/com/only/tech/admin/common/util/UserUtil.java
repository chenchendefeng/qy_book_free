package com.only.tech.admin.common.util;

import com.only.tech.dto.admin.UserAdminDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ZHI ZUN BAO
 * @since 2018/12/21
 */
public class UserUtil {


    /**
     * 获取当前用户id
     * @param request
     * @return
     */
    public static UserAdminDto getUser(HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserAdminDto user = (UserAdminDto)session.getAttribute("user");
        return user;
    }

    /**
     * 获取当前用户id
     * @param request
     * @return
     */
    public static Integer getUserId(HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserAdminDto user = (UserAdminDto)session.getAttribute("user");
        return user.getId();
    }


    /**
     * 当前用户名
     * @param request
     * @return
     */
    public static String getUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserAdminDto user = (UserAdminDto)session.getAttribute("user");
        return user.getUserName();
    }
}
