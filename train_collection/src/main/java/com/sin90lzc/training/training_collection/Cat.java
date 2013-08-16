package com.sin90lzc.training.training_collection;

/**
 * 这个类展示了如何重写{@link Object#hashCode()} {@link Object#equals(Object)} <br />
 * 具体的hashCode()常用编写公式可以参考《Java编程思想》496页
 * 
 * @author tim
 * 
 */
public class Cat {
	private String name;
	private boolean sex;
	private short age;

	public Cat(String name, boolean sex, short age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cat)) {
			return false;
		}
		Cat c = (Cat) obj;
		if (!this.name.equals(c.name) || this.sex != c.sex && this.age != c.age) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 37;
		result = result + name.hashCode();
		result = result + (sex ? 0 : 1);
		result = result + age;
		return result;
	}

	@Override
	public String toString() {
		return "{ name : " + name + " ,age :" + age + " ,sex : "
				+ (sex ? "boy" : "girl") + "}";
	}
}
