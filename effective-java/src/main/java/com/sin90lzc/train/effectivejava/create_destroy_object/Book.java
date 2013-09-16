package com.sin90lzc.train.effectivejava.create_destroy_object;

/**
 * ������ʹ��ʾ��
 * 
 * ������Book��һ���ж�����ԵĶ�����������4�����ԣ����ʹ�ù�������book����ʵ���������Ҫд5���������ˡ�
 * �����ͨ��һ���м��Builder��ʵ�������󣬻����öࡣ
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
