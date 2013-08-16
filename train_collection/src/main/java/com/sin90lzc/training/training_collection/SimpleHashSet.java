package com.sin90lzc.training.training_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 这是一个使用散列码实现的快速查询的简单Set（这里只实现了两个方法{@link this#add(Object)}和{@link
 * this#contains(Object)})<br />
 * <br />
 * 关于java中所有的{@link HashSet} {@link HashMap}等带Hash字样的容器，其实现原理都可以这样理解的：<br />
 * 1.数据结构：一个指定容量的数组，其每个元素都是一个{@link Collection}的引用，容器中的实际元素是保存在
 * {@link Collection}中。<br />
 * 2.如何找到数组对应的slot(槽位)：这个定位当然必须依赖于散列码，一个方法是通过（散列码%数组大小）<br />
 * <br />
 * 
 * 因此，散列码分布地越均匀，容器的查询速度越快。一般来说，使用质数来定义数组的大小是一个比较好的选择。
 * 
 * @author tim
 * 
 * @param <T>
 */
public class SimpleHashSet<T> implements MySet<T> {
	private final int SIZE;

	private List<T>[] buckets;

	@SuppressWarnings("unchecked")
	public SimpleHashSet() {
		SIZE = 997;
		buckets = new List[SIZE];
	}

	@SuppressWarnings("unchecked")
	public SimpleHashSet(int capacity) {
		SIZE = capacity;
		buckets = new List[SIZE];
	}

	public void add(T element) {
		int hashCode = Math.abs(element.hashCode());
		int location = hashCode % SIZE;
		List<T> slot = buckets[location];
		if (slot == null) {
			slot = new ArrayList<T>();
			buckets[location] = slot;
		}
		if (!slot.contains(element)) {
			slot.add(element);
		}
	}

	public boolean contains(T element) {
		int hashCode = Math.abs(element.hashCode());
		int location = hashCode % SIZE;
		List<T> slot = buckets[location];
		return slot != null && slot.contains(element);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (List<T> slot : buckets) {
			if (slot != null) {
				sb.append(slot);
				sb.append(",");
			}
		}
		if (sb.lastIndexOf(",") != -1) {
			sb.deleteCharAt(sb.lastIndexOf(","));
		}
		sb.append("]");
		return sb.toString();
	}
}
