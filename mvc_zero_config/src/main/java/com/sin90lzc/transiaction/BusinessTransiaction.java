/**
 *
 * created on 2015年8月9日 下午3:40:53
 * 
 * @author Tim Leung
 */
package com.sin90lzc.transiaction;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;

/**
 * copyright 
 * 
 * 业务逻辑事务
 * 
 * all right reserved.
 * 
 * created on 2015年8月9日 下午3:40:53
 * 
 * @author Tim Leung
 */
public abstract class BusinessTransiaction extends TransactionSynchronizationAdapter{

	/**
	 * 为我们提供了一个时机，可以在事务提交后处理一些事情
	 *  
	 * @author Tim Leung
	 * 
	 * create on 2015 2015年8月9日 下午3:57:08
	 */
	public abstract void doAfterCommit();
	
	/**
	 * 为我们提供了一个时机，可以在事务回滚后处理一些事情
	 *  
	 * @author Tim Leung
	 * 
	 * create on 2015 2015年8月9日 下午3:57:52
	 */
	public abstract void doAfterRollBack();
	
	/**
	 * 为我们提供了一个时机，可以在事务回滚前或提交前处理一些事情
	 *  
	 * @author Tim Leung
	 * 
	 * create on 2015 2015年8月9日 下午4:01:01
	 */
	protected void doBeforeCommit(){
		
	}
	
	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public void afterCompletion(int status) {
		if(status==STATUS_COMMITTED)
			doAfterCommit();
		else
			doAfterRollBack();
	}
	
	/**
	 * 
	 * override by Tim Leung
	 **/
	@Override
	public void beforeCompletion() {
		super.beforeCompletion();
		doBeforeCommit();
	}
}
