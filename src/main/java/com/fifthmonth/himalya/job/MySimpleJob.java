/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.fifthmonth.himalya.job;

import org.springframework.stereotype.Component;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @Title: MySimpleJob.java
 * @Package com.fifthmonth.himalya.job
 * @Description:
 * @author wangran
 * @date 2018年9月28日 上午9:53:11
 * @version V1.0
 */
@Component
public class MySimpleJob implements SimpleJob {

	@Override
	public void execute(ShardingContext context) {
		switch (context.getShardingItem()) {
		case 0:
			System.err.println("00000000000000000");
			print(context);
			break;
		case 1:
			System.err.println("11111111111111111");
			print(context);
			break;
		case 2:
			System.err.println("22222222222222222");
			print(context);
			break;
		}
	}

	private void print(ShardingContext content) {
		System.out.println("---------------------------------------");
		System.out.println("JobName:" + content.getJobName());
		System.out.println("JobParameter:" + content.getJobParameter());
		System.out.println("ShardingItem:" + content.getShardingItem());
		System.out.println("ShardingParameter:" + content.getShardingParameter());
		System.out.println("ShardingTotalCount:" + content.getShardingTotalCount());
		System.out.println("TaskId:" + content.getTaskId());
		System.out.println("---------------------------------------");

	}

}
