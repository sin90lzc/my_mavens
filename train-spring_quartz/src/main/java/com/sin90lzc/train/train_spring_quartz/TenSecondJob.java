package com.sin90lzc.train.train_spring_quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 注意，如果是通过实现{@link org.quartz.Job}或继续{@link QuartzJobBean}创建的
 * {@link org.quartz.Job}， 每次{@link org.quartz.Scheduler}触发执行任务时，都会重新实例化
 * {@link org.quartz.Job}
 * 
 * @author Tim
 * 
 */
public class TenSecondJob extends QuartzJobBean {
	private static int times = 0;

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		int seconds = (times++) * 10;
		System.out.println("10 seconds trigger:" + seconds + "秒已经过去了！");
	}

}
