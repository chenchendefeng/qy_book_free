package com.only.tech.exposeinfz.admin.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2018/12/20
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ApiModel(value = "书籍修改记录")
public class BookUpdateRecordDto implements Serializable {

    private Long cBID;

    private Integer userId;

    private String userName;

    private String operation;

    private Date createTime;

}
