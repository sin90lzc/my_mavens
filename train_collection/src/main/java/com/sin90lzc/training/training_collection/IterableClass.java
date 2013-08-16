package com.sin90lzc.training.training_collection;

import java.util.Iterator;

/**
 * 实现了{@link Iterable}接口，因此可以用于foreach循环
 * 
 * @author tim
 * 
 * @param <T>
 */
public class IterableClass<T> implements Iterable<T> {

	private T[] slots;

	public IterableClass(T[] elements) {
		slots = elements;
	}

	public Iterator<T> iterator() {

		return new Iterator<T>() {
			int index = 0;

			public boolean hasNext() {
				return index < slots.length;
			}

			public T next() {
				return slots[index++];
			}

			public void remove() {
			}
		};
	}

}
