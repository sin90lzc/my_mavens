package com.sin90lzc.training.training_spring_2;

/**
 * 用于测试Spring的属性外在化
 * @author Tim
 *
 */
public class PlaceHolderBean extends SimpleBean {
	private String url;
	private String driver;
	private String username;
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
