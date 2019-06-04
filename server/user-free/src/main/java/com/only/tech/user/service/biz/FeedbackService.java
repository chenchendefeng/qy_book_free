package com.only.tech.user.service.biz;

import com.only.tech.entity.user.Feedback;
import com.only.tech.user.common.model.PaginationDto;
import com.only.tech.user.dto.FeedbackReqDto;

import java.util.List;

/**
 * 意见反馈服务
 */
public interface FeedbackService {

	/**
	 * 根据用户ID查询反馈
	 *
	 * @param uid
	 * @return
	 */
	public List<Feedback> selectFeedbackByUid(Long uid);

	/**
	 * 分页查询反馈列表
	 *
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PaginationDto selectFeedbackByPage(Long cuId, Integer page, Integer pageSize);

	/**
	 * 保存反馈
	 *
	 * @param dto
	 */
	public void saveFeedback(FeedbackReqDto dto);

	/**
	 * 查询反馈总数
	 *
	 * @return
	 */
	public Integer countFeedback(Long cuId);

}
