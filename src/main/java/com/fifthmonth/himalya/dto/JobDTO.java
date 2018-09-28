/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.fifthmonth.himalya.dto;

/**
 * @Title: JobDTO.java
 * @Package com.fifthmonth.himalya.dto
 * @Description:
 * @author wangran
 * @date 2018年9月28日 下午2:55:57
 * @version V1.0
 */
public class JobDTO {

	private String jobName;

	private String className;

	private String cron;

	private Integer shardingTotalCount;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public Integer getShardingTotalCount() {
		return shardingTotalCount;
	}

	public void setShardingTotalCount(Integer shardingTotalCount) {
		this.shardingTotalCount = shardingTotalCount;
	}

}
