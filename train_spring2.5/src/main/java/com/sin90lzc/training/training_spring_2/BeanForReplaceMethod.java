package com.sin90lzc.training.training_spring_2;

/**
 * 用于测试Spring方法注入的Bean
 * @author tim
 *
 */
public class BeanForReplaceMethod extends SimpleBean{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String printMessage(){
		return message;
	}
	
}
