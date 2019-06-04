package com.only.tech.user.mapper;

import com.only.tech.entity.user.InvitationRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 邀请记录 Mapper 接口
 * </p>
 *
 * @author zzb
 * @since 2019-05-14
 */
public interface InvitationRecordMapper extends BaseMapper<InvitationRecord> {

    /**
     * 邀请好友ID信息
     * @param cuId
     * @return
     */
    List<Long> listInvitedCuid(@Param("cuId") Long cuId);
}
