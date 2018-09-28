/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.fifthmonth.himalya.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dangdang.ddframe.job.lite.lifecycle.domain.JobBriefInfo;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.fifthmonth.himalya.dto.JobDTO;
import com.fifthmonth.himalya.dto.JobOpDTO;
import com.fifthmonth.himalya.service.JobApiService;

/**
 * @Title: JobController.java
 * @Package com.fifthmonth.himalya.controller
 * @Description:
 * @author wangran
 * @date 2018年9月28日 下午2:52:47
 * @version V1.0
 */
@RestController
public class JobController {
	
	@Autowired
	private JobApiService jobApiService;
	@Autowired
	private ZookeeperRegistryCenter zookeeperRegistryCenter;
	
	@RequestMapping(path = "/job/addJob", method = RequestMethod.POST)
	public void addJob(@RequestBody JobDTO jobDTO) throws Exception {
		jobApiService.addJob(jobDTO);
	}
	
	@RequestMapping(path = "/job/listJob", method = RequestMethod.POST)
	public Collection<JobBriefInfo> listJob(@RequestBody JobDTO jobDTO) throws Exception {
		return jobApiService.list();
	}
	
	@RequestMapping(path = "/job/execute", method = RequestMethod.POST)
	public void execute(@RequestBody JobOpDTO dto) throws Exception {
		jobApiService.execute(dto.getJobName(), dto.getServerIp());
	}
	
	@RequestMapping(path = "/job/removeJob", method = RequestMethod.POST)
	public void removeJob(@RequestBody JobOpDTO dto) throws Exception {
		jobApiService.removeJob(dto.getJobName(), dto.getServerIp());
	}
	
	@RequestMapping(path = "/job/enableJob", method = RequestMethod.POST)
	public void enableJob(@RequestBody JobOpDTO dto) throws Exception {
		jobApiService.enableJob(dto.getJobName(), dto.getServerIp());
	}
	
	@RequestMapping(path = "/job/disableJob", method = RequestMethod.POST)
	public void disableJob(@RequestBody JobOpDTO dto) throws Exception {
		jobApiService.disableJob(dto.getJobName(), dto.getServerIp());
	}

}
