/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.fifthmonth.himalya.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobOperateAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobStatisticsAPI;
import com.dangdang.ddframe.job.lite.lifecycle.domain.JobBriefInfo;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.fifthmonth.himalya.configuration.ElasticJobConfigurationHandler;
import com.fifthmonth.himalya.dto.JobDTO;
import com.fifthmonth.himalya.utils.ClazzUtils;
import com.google.common.base.Optional;

/**
 * @Title: JobApiService.java
 * @Package com.fifthmonth.himalya.service
 * @Description:
 * @author wangran
 * @date 2018年9月28日 下午2:56:40
 * @version V1.0
 */
@Service
public class JobApiService {

	@Autowired
	private ZookeeperRegistryCenter zookeeperRegistryCenter;
	@Autowired
	private JobStatisticsAPI jobStatisticsAPI;
	@Autowired
	private JobOperateAPI jobOperateAPI;

	public void addJob(JobDTO jobDTO) throws Exception {
		LiteJobConfiguration jobConfig = ElasticJobConfigurationHandler.newBuilder()
				.buildJobCoreConfig(jobDTO.getJobName(), jobDTO.getCron(), jobDTO.getShardingTotalCount())
				.buildJobTypeConfig(jobDTO.getClassName()).build();

		SpringJobScheduler scheduler = new SpringJobScheduler(ClazzUtils.getClass(jobDTO.getClassName()),
				zookeeperRegistryCenter, jobConfig, new ElasticJobListener() {
					@Override
					public void beforeJobExecuted(ShardingContexts shardingContexts) {

					}

					@Override
					public void afterJobExecuted(ShardingContexts shardingContexts) {

					}
				});
		scheduler.init();
	}

	public Collection<JobBriefInfo> list() {
		Collection<JobBriefInfo> list = jobStatisticsAPI.getAllJobsBriefInfo();
		return list;
	}
	
	public void execute(String jobName, String serverIp) {
		jobOperateAPI.trigger(Optional.of(jobName), Optional.fromNullable(serverIp));
	}
	
	public void removeJob(String jobName, String serverIp) {
		jobOperateAPI.remove(Optional.of(jobName), Optional.fromNullable(serverIp));
	}
	
	public void enableJob(String jobName, String serverIp) {
		jobOperateAPI.enable(Optional.of(jobName), Optional.fromNullable(serverIp));
	}
	
	public void disableJob(String jobName, String serverIp) {
		jobOperateAPI.disable(Optional.of(jobName), Optional.fromNullable(serverIp));
	}
	
}
