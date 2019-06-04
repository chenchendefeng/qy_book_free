package com.only.tech.exposeinfz.user.task;

import com.only.tech.exposeinfz.ExecuteService;

public interface UserAliveTaskInfz extends ExecuteService {
	//用户留存分析
	void executeUserAliveAnalysis(String param);
}
