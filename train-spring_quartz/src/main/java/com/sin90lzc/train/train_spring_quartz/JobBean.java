package com.sin90lzc.train.train_spring_quartz;

/**
 * 该Bean会由spring aop或通过代理方式生成一个 {@link org.quartz.Job}的代理对象,然后把这个代理对象，提供给
 * {@link org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean}
 * 生成一个{@link org.quartz.JobDetail}对象<br />
 * 
 * @author Tim
 * 
 */
public class JobBean {
	private int second = 0;

	public void printPerSecond() {
		System.out.println("second trigger:" + (second++) + "过去了！");
	}
}
