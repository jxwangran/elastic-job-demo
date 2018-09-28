/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.fifthmonth.himalya.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dangdang.ddframe.job.lite.lifecycle.api.JobOperateAPI;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobStatisticsAPI;
import com.dangdang.ddframe.job.lite.lifecycle.internal.operate.JobOperateAPIImpl;
import com.dangdang.ddframe.job.lite.lifecycle.internal.statistics.JobStatisticsAPIImpl;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.fifthmonth.himalya.job.MySimpleJob;

/**    
* @Title: ElasticJobConfiguration.java  
* @Package com.fifthmonth.himalya.configuration  
* @Description: 
* @author wangran 
* @date 2018年9月28日 上午10:53:59  
* @version V1.0    
*/
@Configuration
public class ElasticJobConfiguration {
	
	@Autowired
	private MySimpleJob mySimpleJob;
	
	@Bean(name="zookeeperConfiguration")
	public ZookeeperConfiguration initZookeeperConfiguration(@Value("${elastic.zookeeper.address}") String serverLists,@Value("${elastic.namespace}") String namespace) {
		ZookeeperConfiguration zkConfiguration = new ZookeeperConfiguration(serverLists, namespace);
		zkConfiguration.setBaseSleepTimeMilliseconds(3000);
		zkConfiguration.setConnectionTimeoutMilliseconds(3000);
		return zkConfiguration;
	}
	
	@Bean(name="zookeeperRegistryCenter")
	public ZookeeperRegistryCenter initZookeeperRegistryCenter(ZookeeperConfiguration zookeeperConfiguration) {
		ZookeeperRegistryCenter center = new ZookeeperRegistryCenter(zookeeperConfiguration);
		center.init();
		return center;
	}
	
	@Bean
	public JobStatisticsAPI initJobStatisticsAPIImpl(ZookeeperRegistryCenter registerCenter) {
		JobStatisticsAPIImpl imple = new JobStatisticsAPIImpl(registerCenter);
		return imple;
	}
	
	@Bean
	public JobOperateAPI initJobOperateAPI(ZookeeperRegistryCenter registerCenter) {
		JobOperateAPIImpl impl = new JobOperateAPIImpl(registerCenter);
		return impl;
	}
	
//	@Bean
//	public SpringJobScheduler initSpringJobScheduler(ZookeeperRegistryCenter zookeeperRegistryCenter) {
//		JobCoreConfiguration core = JobCoreConfiguration.newBuilder("mysimpleJob", "0/10 * * * * ?", 1).build();
//		JobTypeConfiguration jobTypeConfig = new SimpleJobConfiguration(core, mySimpleJob.getClass().getName());
//		LiteJobConfiguration jobConfig = LiteJobConfiguration.newBuilder(jobTypeConfig).build(); 
//		SpringJobScheduler scheduler = new SpringJobScheduler(mySimpleJob, zookeeperRegistryCenter, jobConfig, new ElasticJobListener() {
//			@Override
//			public void beforeJobExecuted(ShardingContexts shardingContexts) {
//				
//			}
//			@Override
//			public void afterJobExecuted(ShardingContexts shardingContexts) {
//			
//			}
//		});
//		scheduler.init();
//		return scheduler;
//	}
	
	
	
}
