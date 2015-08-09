/**
 *
 * created on 2015年8月9日 下午3:40:25
 * 
 * @author Tim Leung
 */
package com.sin90lzc.transiaction;

import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年8月9日 下午3:40:25
 * 
 * @author Tim Leung
 */
public class BusinessTransiactionManager {
	
	public static void addBusinessTransiaction(BusinessTransiaction bt){
		TransactionSynchronizationManager.registerSynchronization(bt);
	}
	
}
