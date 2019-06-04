package com.only.tech.user.service.facade;

import com.only.tech.entity.user.WxRenewaResultRecord;
import com.only.tech.user.service.biz.WxRenewaResultRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/17
 */
@Slf4j
@Service
public class WxRenewaResultRecordFacade {

	@Autowired
	private WxRenewaResultRecordService wxRenewaResultRecordService;

	public boolean save(WxRenewaResultRecord wxRenewaResultRecord) {
		if (wxRenewaResultRecord == null) {
			return false;
		}
		wxRenewaResultRecord.setCreateDate(new Date());
		return wxRenewaResultRecordService.save(wxRenewaResultRecord);
	}

}
