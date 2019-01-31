package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Service;

@JobHandler(value="firstTestJobHandler")
@Service
public class FirstTestJobHandler extends IJobHandler {

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		XxlJobLogger.log("--------- 测试批处理执行--------- ");
		return ReturnT.SUCCESS;
	}
}
