package com.only.tech.entity.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.only.tech.base.SuperEntityWithIntegerID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("a_group_user")
public class UserGroupRelativeEntity extends SuperEntityWithIntegerID<UserGroupRelativeEntity> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer rid;
    private Integer gid;

    public UserGroupRelativeEntity(Integer rid, Integer gid) {
        super();
        this.rid = rid;
        this.gid = gid;
    }

    public UserGroupRelativeEntity() {
        super();
    }
}
