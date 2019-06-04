package com.only.tech.user.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ZHI ZUN BAO
 * @since 2018/10/27
 */
@Data
public class ReqParam {

	private String uid;

	private String cbid;

	private List<String> ccidList;

}
