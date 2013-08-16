package com.sin90lzc.training.training_rtti;

/**
 * Class类中提供了新的转型方法:
 * <ul>
 * <li>
 * {@link java.lang.Class#cast(Object)}它可以把Ojbect转换成Class所引用的对象。</li>
 * <li>
 * {@link java.lang.Class#asSubclass(Class)}它可以把一个类像转换成更具体的类对象。</li>
 * </ul>
 * 
 * @author tim
 * 
 */
public class TF_ClassCast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Building b = new House();
		Class<House> classHouse = House.class;
		System.out.println(classHouse);
		House house = classHouse.cast(b);
		Class<? extends Building> clazz = classHouse.asSubclass(b.getClass());
		System.out.println(clazz.equals(classHouse));
	}

}
