/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.fifthmonth.himalya.configuration;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;

/**    
* @Title: ElasticJobConfigurationHandler.java  
* @Package com.fifthmonth.himalya.configuration  
* @Description: 
* @author wangran 
* @date 2018年9月28日 下午2:11:15  
* @version V1.0    
*/
public class ElasticJobConfigurationHandler {
	
	public static Builder newBuilder() {
		return new Builder();
	}
	
	public static class Builder {
		private JobCoreConfiguration coreConfig;
		private JobTypeConfiguration jobTypeConfig;
		
		public Builder buildJobCoreConfig(String jobName, String cron, int shardingTotalCount) {
			this.coreConfig = JobCoreConfiguration.newBuilder(jobName, cron, shardingTotalCount).build();
			return this;
		}
		
		public Builder buildJobTypeConfig(String jobClass) {
			if (this.coreConfig == null) {
				throw new RuntimeException("coreConfig不能为空！");
			}
			this.jobTypeConfig = new SimpleJobConfiguration(this.coreConfig, jobClass);
			return this;
		}
		
		public LiteJobConfiguration build() {
			if (this.coreConfig == null) {
				throw new RuntimeException("coreConfig不能为空！");
			}
			if (this.jobTypeConfig == null) {
				throw new RuntimeException("jobTypeConfig不能为空！");
			}
			return LiteJobConfiguration.newBuilder(jobTypeConfig).build(); 
		}
		
	}
	
}
