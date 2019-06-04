package com.only.tech.exposeinfz.payment.task;

import com.only.tech.exposeinfz.ExecuteService;

public interface WxPayTaskInfz extends ExecuteService{

	void executeCheckBill(String param);
}
