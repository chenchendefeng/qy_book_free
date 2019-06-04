package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.FeedbackReply;
import com.only.tech.user.mapper.FeedbackReplyMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 反馈回复 服务实现类
 * </p>
 *
 * @author HUA MAN LOU
 * @since 2019-5-14
 */
@Service("feedbackReplyService")
public class FeedbackReplyServiceImpl extends ServiceImpl<FeedbackReplyMapper, FeedbackReply> implements FeedbackReplyService {

}
