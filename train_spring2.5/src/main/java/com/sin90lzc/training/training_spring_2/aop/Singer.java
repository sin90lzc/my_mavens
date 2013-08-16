package com.sin90lzc.training.training_spring_2.aop;

public class Singer implements Artist {
	private static int times = 0;

	public void perform() {
		if (++times < 2)
			System.out.println("a singer is singing!");
		else
			throw new RuntimeException("the singer singed more than one time! ");
	}
}
