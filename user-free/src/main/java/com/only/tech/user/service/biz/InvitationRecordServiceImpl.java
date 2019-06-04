package com.only.tech.user.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only.tech.entity.user.InvitationRecord;
import com.only.tech.user.mapper.InvitationRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 邀请记录 服务实现类
 * </p>
 *
 * @author zzb
 * @since 2019-05-14
 */
@Service
public class InvitationRecordServiceImpl extends ServiceImpl<InvitationRecordMapper, InvitationRecord> implements InvitationRecordService {

    @Autowired
    InvitationRecordMapper invitationRecordMapper;

    @Override
    public InvitationRecord getByCuidAndInvitedCuid(Long cuId, Long invitedCuid) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        qw.eq("invitedCuid",invitedCuid);

        return this.getOne(qw);
    }

    @Override
    public List<InvitationRecord> listByCuid(Long cuId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("cuId",cuId);
        qw.orderByDesc("createTime");
        return this.list(qw);
    }

    @Override
    public InvitationRecord getByInvitedCuid(Long invitedCuid) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("invitedCuid",invitedCuid);

        return this.getOne(qw);
    }

    /**
     * 邀请好友ID信息
     * @param cuId
     * @return
     */
    @Override
    public List<Long> listInvitedCuid(Long cuId) {
        return this.invitationRecordMapper.listInvitedCuid(cuId);
    }
}
