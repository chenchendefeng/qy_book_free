package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.user.InvitationRecord;

import java.util.List;

/**
 * <p>
 * 邀请记录 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-14
 */
public interface InvitationRecordService extends IService<InvitationRecord> {

    InvitationRecord getByCuidAndInvitedCuid(Long cuId, Long invitedCuid);

    List<InvitationRecord> listByCuid(Long cuId);

    InvitationRecord getByInvitedCuid(Long cuId);

    /**
     * 邀请好友ID信息
     * @param cuId
     * @return
     */
    List<Long> listInvitedCuid(Long cuId);
}
