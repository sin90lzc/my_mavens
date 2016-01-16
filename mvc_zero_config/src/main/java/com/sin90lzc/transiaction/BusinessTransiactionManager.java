/**
 *
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
 * 
 * @author Tim Leung
 */
public class BusinessTransiactionManager {
	
	public static void addBusinessTransiaction(BusinessTransiaction bt){
		TransactionSynchronizationManager.registerSynchronization(bt);
	}
	
}
