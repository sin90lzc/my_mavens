package com.sin90lzc.training.training_collection;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SimpleHashSetTest {
	private MySet<Object> simpleSet;

	private static final String[] DATA = "good good study day day up good good study day day up good good study day day up good good study day day up good good study day day up"
			.split(" ");

	private static final Cat[] CATS = new Cat[] {
			new Cat("tim", true, (short) 18),
			new Cat("rain", false, (short) 18),
			new Cat("tom", true, (short) 21),
			new Cat("billy", true, (short) 17),
			new Cat("tom", true, (short) 20),
			new Cat("billy", false, (short) 17),
			new Cat("tim", true, (short) 18),
			new Cat("rain", false, (short) 18), };

	private static final Integer[] ints = new Integer[] { 0, 1, 2, 3, 4, 5, 6,
			7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
			24, 25, 26, 27, 28, 29 };

	private static Random rand = new Random(47);

	@Before
	public void setup() {

	}

	@Test
	public void testInteger() {
		System.out
				.println("----------------Testing Integer Type----------------");
		testObject(ints, 3);
		testObject(ints, 31);
	}

	@Test
	public void testString() {
		System.out
				.println("----------------Testing String Type----------------");
		testObject(DATA, 3);
		testObject(DATA, 31);
	}

	@Test
	public void testCat() {
		System.out.println("----------------Testing Cat Type----------------");
		testObject(CATS, 3);
		testObject(CATS, 31);
	}

	private void testObject(Object[] objs, int capacity) {
		simpleSet = new SimpleHashSet<Object>(capacity);

		for (int i = 0; i < 1000; i++) {
			simpleSet.add(objs[rand.nextInt(objs.length)]);
		}

		System.out.println(simpleSet);
		long start = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			simpleSet.contains(objs[rand.nextInt(objs.length)]);
		}
		System.out.println("HashSet with capacity "+capacity+":"
				+ (System.currentTimeMillis() - start));
	}
}
