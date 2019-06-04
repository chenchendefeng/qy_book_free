package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.only.tech.entity.user.Feedback;
import com.only.tech.entity.user.FeedbackReply;
import com.only.tech.user.common.model.PaginationDto;
import com.only.tech.user.common.model.PaginationQueryDto;
import com.only.tech.user.common.utils.DateUtils;
import com.only.tech.user.dto.FeedbackReplyRespDto;
import com.only.tech.user.dto.FeedbackReqDto;
import com.only.tech.user.dto.FeedbackRespDto;
import com.only.tech.user.mapper.FeedbackMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 意见反馈服务
 */
@Service(value = "feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackMapper feedbackMapper;

	@Autowired
	private FeedbackReplyService feedbackReplyService;

	/**
	 * 根据用户ID查询反馈
	 *
	 * @param uid
	 * @return
	 */
	@Override
	public List<Feedback> selectFeedbackByUid(Long uid) {
		List<Feedback> feedbacks = feedbackMapper.selectFeedbackByUid(uid);
		return feedbacks;
	}

	/**
	 * 分页查询反馈列表
	 *
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@Override
	public PaginationDto<FeedbackRespDto> selectFeedbackByPage(Long cuId, Integer page, Integer pageSize) {
		int total = countFeedback(cuId);
		PaginationQueryDto paginationQueryDto = new PaginationQueryDto().setPage(page).setPageSize(pageSize);
		List<Feedback> feedbacks = feedbackMapper.selectFeedbackByPage(cuId, paginationQueryDto);

		List<FeedbackRespDto> respDtos = new ArrayList<>();
		feedbacks.stream().forEach(feedback -> {
			FeedbackRespDto feedbackRespDto = new FeedbackRespDto();
			BeanUtils.copyProperties(feedback, feedbackRespDto);

			// 查询反馈回复列表
			// TODO 可以优化
			Wrapper wrapper = new QueryWrapper<FeedbackReply>().eq("feedbackId", feedback.getFid())
					.orderByAsc("createTime");
			List<FeedbackReply> replyList = feedbackReplyService.list(wrapper);
			List<FeedbackReplyRespDto> replyRespDtos = Lists.transform(replyList,
					new Function<FeedbackReply, FeedbackReplyRespDto>() {
						@Override
						public FeedbackReplyRespDto apply(FeedbackReply reply) {
							FeedbackReplyRespDto replyRespDto = new FeedbackReplyRespDto();
							BeanUtils.copyProperties(reply, replyRespDto);
							replyRespDto.setCreateTime(DateUtils.localDateTime2Date(reply.getCreateTime()));
							return replyRespDto;
						}
					});
			feedbackRespDto.setReplyList(replyRespDtos);
			respDtos.add(feedbackRespDto);
		});

		PaginationDto paginationDto = new PaginationDto();
		paginationDto.setPage(paginationQueryDto.getPage()).setTotal(total).setData(respDtos);
		return paginationDto;
	}

	/**
	 * 保存反馈
	 *
	 * @param dto
	 */
	@Override
	public void saveFeedback(FeedbackReqDto dto) {
		Feedback feedback = new Feedback();
		BeanUtils.copyProperties(dto, feedback);
		feedbackMapper.saveFeedback(feedback);
	}

	/**
	 * 查询反馈总数
	 *
	 * @return
	 */
	@Override
	public Integer countFeedback(Long cuId) {
		return feedbackMapper.countFeedback(cuId);
	}

}
