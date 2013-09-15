package com.sin90lzc.train.effectivejava.create_destroy_object;

/**
 * 构建器使用示例
 * 
 * 在这里Book是一个有多个属性的对象，如这里有4个属性，如果使用构造器对book进行实例化，这就要写5个构造器了。
 * 而如果通过一个中间件Builder来实例化对象，会灵活得多。
 * 
 * @author Tim
 *
 */
public class Book {
	private final String name;
	private final int pages;
	private int version;
	private String language;

	private Book(Builder builder) {
		this.name = builder.name;
		this.pages = builder.pages;
		this.version = builder.version;
		this.language = builder.language;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public int getPages() {
		return pages;
	}

	public static Builder getBuilder(String name, int pages) {
		return new Builder(name, pages);
	}

	public static class Builder {
		private final String name;
		private final int pages;
		private int version;
		private String language;

		private Builder(String name, int pages) {
			this.name = name;
			this.pages = pages;
		}

		public Builder version(int version) {
			this.version = version;
			return this;
		}

		public Builder language(String language) {
			this.language = language;
			return this;
		}

		public Book build() {
			return new Book(this);
		}
	}
}
