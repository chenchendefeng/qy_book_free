package com.only.tech.entity.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("a_user")
public class UserEntity extends SuperEntityWithIntegerID<UserEntity> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String loginName;

    private String password;
    private String userName;
    /**
     * 最近登录ip
     */
    private String lastLoginIp;
    /**
     * 最近登录时间
     */
    private Date lastLoginTime;
    private Date dateCreate;
    private Date dateUpdate;
}
