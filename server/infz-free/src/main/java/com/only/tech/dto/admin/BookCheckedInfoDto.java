package com.only.tech.dto.admin;

import com.only.tech.entity.book.BookInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 书籍检查对象
 * @author shutong
 * @since 2019-03-03
 */
@Data
@ApiModel
public class BookCheckedInfoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("ID")
	private Long id;

	@ApiModelProperty("书籍列表")
	private List<BookInfo> bookList;

	@ApiModelProperty("异常bid列表")
	private List<Long> errorBidList;




}
