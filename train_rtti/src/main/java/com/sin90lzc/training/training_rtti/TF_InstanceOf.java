package com.sin90lzc.training.training_rtti;

/**
 * 该类用于比较instanceof,{@link java.lang.Class#isInstance(Object)},
 * {@link java.lang.Class#isAssignableFrom(Class)}的区别
 * <p>
 * 结论如下：
 * <ul>
 * <li>
 * A instanceof B:表示A是否是B的一个实例。</li>
 * <li>A.isInstance(B)：表示B对象是否是A类型的对象的一个实例。</li>
 * <li>
 * A.isAssignableFrom(B):表示B类型的对象是否可以赋值给A类型的对象。</li>
 * </ul>
 * </p>
 * 
 * @author tim
 * @version 1.0
 */
public class TF_InstanceOf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Building house = new House();
		Building building = new Building();
		System.out.println("building instanceof Building : " + "["
				+ (building instanceof Building) + "]");
		System.out.println("building instanceof House : " + "["
				+ (building instanceof House) + "]");
		System.out.println("house instanceof Building : " + "["
				+ (house instanceof Building) + "]");
		System.out.println("house instanceof House : " + "["
				+ (house instanceof House) + "]");
		System.out.println("------------------------------------");
		System.out.println("building.getClass().isInstance(building) : " + "["
				+ (building.getClass().isInstance(building)) + "]");
		System.out.println("building.getClass().isInstance(house) : " + "["
				+ (building.getClass().isInstance(house)) + "]");
		System.out.println("house.getClass().isInstance(building) : " + "["
				+ (house.getClass().isInstance(building)) + "]");
		System.out.println("house.getClass().isInstance(house) : " + "["
				+ (house.getClass().isInstance(house)) + "]");
		System.out.println("------------------------------------");
		System.out
				.println("building.getClass().isAssignableFrom(building.getClass()) : "
						+ "["
						+ (building.getClass().isAssignableFrom(building
								.getClass())) + "]");
		System.out
				.println("building.getClass().isAssignableFrom(house.getClass()) : "
						+ "["
						+ (building.getClass().isAssignableFrom(house
								.getClass())) + "]");
		System.out
				.println("house.getClass().isAssignableFrom(building.getClass()) : "
						+ "["
						+ (house.getClass().isAssignableFrom(building
								.getClass())) + "]");
		System.out
				.println("house.getClass().isAssignableFrom(house.getClass()) : "
						+ "["
						+ (house.getClass().isAssignableFrom(house.getClass()))
						+ "]");
	}

}
