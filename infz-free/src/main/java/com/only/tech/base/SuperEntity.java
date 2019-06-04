//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.only.tech.base;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

@Data
public class SuperEntity<T extends Model> extends Model<T> {

    @TableId("id")
    private Long id;

    protected Serializable pkVal() {
        return this.id;
    }

}
