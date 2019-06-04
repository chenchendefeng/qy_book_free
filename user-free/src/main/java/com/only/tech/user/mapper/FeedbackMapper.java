package com.only.tech.user.mapper;

import com.only.tech.entity.user.Feedback;
import com.only.tech.user.common.model.PaginationQueryDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackMapper {

	/**
	 * 根据用户ID查询反馈
	 *
	 * @param uid
	 * @return
	 */
	public List<Feedback> selectFeedbackByUid(@Param("uid") Long uid);

	/**
	 * 查询反馈总数
	 *
	 * @return
	 */
	public Integer countFeedback(@Param("cuId") Long cuId);

	/**
	 * 分页查询反馈列表
	 *
	 * @param paginationQueryDto
	 * @return
	 */
	public List<Feedback> selectFeedbackByPage(@Param("cuId") Long cuId,
                                               @Param("page") PaginationQueryDto paginationQueryDto);

	/**
	 * 保存反馈
	 *
	 * @param feedback
	 */
	public void saveFeedback(Feedback feedback);

}
