package com.only.tech.book.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.only.tech.entity.book.ReadProcess;

/**
 * <p>
 * 书籍阅读进度表 服务类
 * </p>
 *
 * @author zzb
 * @since 2019-05-08
 */
public interface ReadProcessService extends IService<ReadProcess> {

    ReadProcess getByCuidAndBid(Long cuId, Long bid);
}
