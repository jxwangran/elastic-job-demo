package com.fifthmonth.himalya;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;

/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */

/**    
* @Title: QuartzApplication.java  
* @Package   
* @Description: 
* @author wangran 
* @date 2018年9月26日 下午2:31:07  
* @version V1.0    
*/
@SpringBootApplication
@EnableScheduling
public class QuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartzApplication.class, args);
	}
	
	
	
}
