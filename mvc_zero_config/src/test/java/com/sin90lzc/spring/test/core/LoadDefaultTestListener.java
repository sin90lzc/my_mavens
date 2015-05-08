/**
 *
 * created on 2015年4月19日 下午2:54:00
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.core;

import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;

import com.sin90lzc.spring.test.base.BaseTest;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * created on 2015年4月19日 下午2:54:00
 * 
 * 测试从@TestExecutionListeners的使用
 * 
 * 
 * @author Tim Leung
 */
@TestExecutionListeners(listeners={TestLogListerner.class},mergeMode=MergeMode.MERGE_WITH_DEFAULTS)
public class LoadDefaultTestListener extends BaseTest {
	
	
	
	@Test
	public void test(){
		
	}
	
}
