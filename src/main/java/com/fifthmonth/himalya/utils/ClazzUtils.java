/**   
 * Copyright © 2018 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.fifthmonth.himalya.utils;

import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**    
* @Title: ClazzUtils.java  
* @Package com.yijiupi.himalaya.utils  
* @Description: 
* @author wangran 
* @date 2018年9月26日 下午3:54:06  
* @version V1.0    
*/
public final class ClazzUtils {

	public static SimpleJob getClass(String clazzName) throws Exception {
		Class<?> clazz = Class.forName(clazzName);
		return (SimpleJob)clazz.newInstance();
	}
	
}
