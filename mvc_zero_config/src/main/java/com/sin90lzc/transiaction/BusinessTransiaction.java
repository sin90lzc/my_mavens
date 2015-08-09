/**
 *
 * created on 2015��8��9�� ����3:40:53
 * 
 * @author Tim Leung
 */
package com.sin90lzc.transiaction;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;

/**
 * copyright 
 * 
 * ҵ���߼�����
 * 
 * all right reserved.
 * 
 * created on 2015��8��9�� ����3:40:53
 * 
 * @author Tim Leung
 */
public abstract class BusinessTransiaction extends TransactionSynchronizationAdapter{

	/**
	 * Ϊ�����ṩ��һ��ʱ���������������ύ����һЩ����
	 *  
	 * @author Tim Leung
	 * 
	 * create on 2015 2015��8��9�� ����3:57:08
	 */
	public abstract void doAfterCommit();
	
	/**
	 * Ϊ�����ṩ��һ��ʱ��������������ع�����һЩ����
	 *  
	 * @author Tim Leung
	 * 
	 * create on 2015 2015��8��9�� ����3:57:52
	 */
	public abstract void doAfterRollBack();
	
	/**
	 * Ϊ�����ṩ��һ��ʱ��������������ع�ǰ���ύǰ����һЩ����
	 *  
	 * @author Tim Leung
	 * 
	 * create on 2015 2015��8��9�� ����4:01:01
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
