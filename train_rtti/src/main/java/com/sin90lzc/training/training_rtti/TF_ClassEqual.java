package com.sin90lzc.training.training_rtti;

/**
 * 这个类用于确定Class的等价性
 * 结论：只要是同一个对象的类型，不管是”==“还是equals，都是返回true
 * @author tim
 * @version 1.0
 */
public class TF_ClassEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Building building = new Building();
		House house1 = new House();
		House house2 = new House();
		System.out.println("building.getClass().equals(Building.class) : "
				+ "[" + building.getClass().equals(Building.class) + "]");
		System.out.println("building.getClass()==Building.class : " + "["
				+ (building.getClass() == Building.class) + "]");
		System.out.println("house1.getClass().equals(House.class) : " + "["
				+ house1.getClass().equals(House.class) + "]");
		System.out.println("house1.getClass()==House.class : " + "["
				+ (house1.getClass() == House.class) + "]");
		System.out.println("house1.getClass().equals(house2.getClass()) : "
				+ "[" + house1.getClass().equals(house2.getClass()) + "]");
		System.out.println("house1.getClass()==house2.getClass() : " + "["
				+ (house1.getClass() == house2.getClass()) + "]");
	}

}
