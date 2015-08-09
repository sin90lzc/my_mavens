/**
 * 
 */
package com.sin90lzc.java.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序工具类
 * @author liangzhicong
 * 
 * create at 2015年8月5日 下午5:04:23
 */
public class SortUtils {
	private enum SortDirect{
		ASC,DESC
	}
	
	public static final SortDirect ASC=SortDirect.ASC;
	public static final SortDirect DESC=SortDirect.DESC;
	
	private static <T extends Comparable> void sortByMaoPao(List<T> src,SortDirect direct) {
		
		if(direct==ASC){
			for(int i=0;i<src.size()-1;i++){
				for(int j=src.size()-1;j>=1;j--){
					T last=src.get(j);
					T pre=src.get(j-1);
					if(last.compareTo(pre)<0){
						src.set(j-1, last);
						src.set(j,pre);
					}
				}
			}
		}else{
			for(int i=0;i<src.size()-1;i++){
				for(int j=src.size()-1;j>=1;j--){
					T last=src.get(j);
					T pre=src.get(j-1);
					if(last.compareTo(pre)>0){
						src.set(j-1, last);
						src.set(j,pre);
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @category 冒泡排序算法
	 * @param src
	 * @param direct
	 * @return
	 *
	 * @author liangzhicong
	 */
	private static <T extends Comparable> void sortByMaoPao(T[] src,SortDirect direct){
		
		if(src==null || src.length<1){
			return;
		}
		if(direct==ASC){
			for(int i=0;i<src.length-1;i++){
				for(int j=src.length-1;j>=1;j--){
					if(src[j].compareTo((T)src[j-1])<0){
						T tmp=src[j-1];
						src[j-1]=src[j];
						src[j]=tmp;
					}
				}
			}
		}else{
			for(int i=0;i<src.length-1;i++){
				for(int j=src.length-1;j>=1;j--){
					if(src[j].compareTo((T)src[j-1])>0){
						T tmp=src[j-1];
						src[j-1]=src[j];
						src[j]=tmp;
					}
				}
			}
		}
	}
	/**
	 * 
	 * 
	 * @category 冒泡排序算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByMaoPao(int[] src,SortDirect direct){

		if(src==null || src.length<1){
			return;
		}
		if(direct==ASC){
			for(int i=0;i<src.length-1;i++){
				for(int j=src.length-1;j>=1;j--){
					if(src[j]<src[j-1]){
						src[j]=src[j]^src[j-1];
						src[j-1]=src[j]^src[j-1];
						src[j]=src[j]^src[j-1];
					}
				}
			}
		}else{
			for(int i=0;i<src.length-1;i++){
				for(int j=src.length-1;j>=1;j--){
					if(src[j]>src[j-1]){
						src[j]=src[j]^src[j-1];
						src[j-1]=src[j]^src[j-1];
						src[j]=src[j]^src[j-1];
					}
				}
			}
		}
	}
	/**
	 * 
	 * 
	 * @category 冒泡排序算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByMaoPao(long[] src,SortDirect direct){

		if(src==null || src.length<1){
			return;
		}
		if(direct==ASC){
			for(int i=0;i<src.length-1;i++){
				for(int j=src.length-1;j>=1;j--){
					if(src[j]<src[j-1]){
						src[j]=src[j]^src[j-1];
						src[j-1]=src[j]^src[j-1];
						src[j]=src[j]^src[j-1];
					}
				}
			}
		}else{
			for(int i=0;i<src.length-1;i++){
				for(int j=src.length-1;j>=1;j--){
					if(src[j]>src[j-1]){
						src[j]=src[j]^src[j-1];
						src[j-1]=src[j]^src[j-1];
						src[j]=src[j]^src[j-1];
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @category 冒泡排序算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByMaoPao(float[] src,SortDirect direct){

		if(src==null || src.length<1){
			return;
		}
		if(direct==ASC){
			for(int i=0;i<src.length-1;i++){
				for(int j=src.length-1;j>=1;j--){
					if(src[j]<src[j-1]){
						float tmp=src[j];
						src[j]=src[j-1];
						src[j-1]=tmp;
					}
				}
			}
		}else{
			for(int i=0;i<src.length-1;i++){
				for(int j=src.length-1;j>=1;j--){
					if(src[j]>src[j-1]){
						float tmp=src[j];
						src[j]=src[j-1];
						src[j-1]=tmp;
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @category 冒泡排序算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByMaoPao(double[] src,SortDirect direct){

		if(src==null || src.length<1){
			return;
		}
		if(direct==ASC){
			for(int i=0;i<src.length-1;i++){
				for(int j=src.length-1;j>=1;j--){
					if(src[j]<src[j-1]){
						double tmp=src[j];
						src[j]=src[j-1];
						src[j-1]=tmp;
					}
				}
			}
		}else{
			for(int i=0;i<src.length-1;i++){
				for(int j=src.length-1;j>=1;j--){
					if(src[j]>src[j-1]){
						double tmp=src[j];
						src[j]=src[j-1];
						src[j-1]=tmp;
					}
				}
			}
		}
	}
	/**
	 * 
	 * 
	 * @category 快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static <T extends Comparable<T>> void sortByQuick(List<T> src,SortDirect direct){
		if(src!=null && src.size()>0)
			sortByQuick(src, 0, src.size()-1, direct);
	}
	/**
	 * 
	 * 
	 * @category  快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static <T extends Comparable<T>> void sortByQuick(T[] src,SortDirect direct){
		if(src!=null && src.length>0)
			sortByQuick(src, 0, src.length-1, direct);
	}
	/**
	 * 
	 * 
	 * @category  快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByQuick(int[] src,SortDirect direct){
		if(src!=null && src.length>0)
			sortByQuick(src, 0, src.length-1, direct);
	}

	/**
	 * 
	 * 
	 * @category  快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByQuick(long[] src,SortDirect direct){
		if(src!=null && src.length>0)
			sortByQuick(src, 0, src.length-1, direct);
	}
	/**
	 * 
	 * 
	 * @category  快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByQuick(float[] src,SortDirect direct){
		if(src!=null && src.length>0)
			sortByQuick(src, 0, src.length-1, direct);
	}
	/**
	 * 
	 * 
	 * @category  快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByQuick(double[] src,SortDirect direct){
		if(src!=null && src.length>0)
			sortByQuick(src, 0, src.length-1, direct);
	}
	
	/**
	 * 
	 * 
	 * @category 快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static <T extends Comparable<T>> void sortByQuick(List<T> src,int startPoint,int endPoint,SortDirect direct){

		int leftPoint=0;
		int rightPoint=endPoint;
		if(direct==ASC){
			T base=src.get(startPoint);
			while(leftPoint<rightPoint){
				while(src.get(rightPoint).compareTo(base)>=0&&leftPoint<rightPoint){
					rightPoint--;
				}
				src.set(leftPoint, src.get(rightPoint));
				while(src.get(leftPoint).compareTo(base)<=0&&leftPoint<rightPoint){
					leftPoint++;
				}
				src.set(rightPoint, src.get(leftPoint));
			}
			src.set(leftPoint, base);
		}else{
			T base=src.get(endPoint);
			while(leftPoint<rightPoint){
				while(src.get(leftPoint).compareTo(base)>=0&&leftPoint<rightPoint){
					leftPoint++;
				}
				src.set(rightPoint, src.get(leftPoint));
				while(src.get(rightPoint).compareTo(base)<=0&&leftPoint<rightPoint){
					rightPoint--;
				}
				src.set(leftPoint,src.get(rightPoint));
			}
			src.set(leftPoint, base);
		}
		if(startPoint<leftPoint)
			sortByQuick(src,startPoint,leftPoint-1,direct);
		if(endPoint>rightPoint+1)
			sortByQuick(src,rightPoint+1,endPoint,direct);
	}
	/**
	 * 
	 * 
	 * @category  快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static <T extends Comparable<T>> void sortByQuick(T[] src,int startPoint,int endPoint,SortDirect direct){

		int leftPoint=0;
		int rightPoint=endPoint;
		if(direct==ASC){
			T base=src[startPoint];
			while(leftPoint<rightPoint){
				while(src[rightPoint].compareTo(base)>=0&&leftPoint<rightPoint){
					rightPoint--;
				}
				src[leftPoint]=src[rightPoint];
				while(src[leftPoint].compareTo(base)<=0&&leftPoint<rightPoint){
					leftPoint++;
				}
				src[rightPoint]=src[leftPoint];
			}
			src[leftPoint]=base;
		}else{
			T base=src[endPoint];
			while(leftPoint<rightPoint){
				while(src[leftPoint].compareTo(base)>=0&&leftPoint<rightPoint){
					leftPoint++;
				}
				src[rightPoint]=src[leftPoint];
				while(src[rightPoint].compareTo(base)<=0&&leftPoint<rightPoint){
					rightPoint--;
				}
				src[leftPoint]=src[rightPoint];
			}
			src[leftPoint]=base;
		}
		if(startPoint<leftPoint)
			sortByQuick(src,startPoint,leftPoint-1,direct);
		if(endPoint>rightPoint+1)
			sortByQuick(src,rightPoint+1,endPoint,direct);
	}

	/**
	 * 
	 * 
	 * @category  快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByQuick(long[] src,int startPoint,int endPoint,SortDirect direct){
		
		int leftPoint=0;
		int rightPoint=endPoint;
		if(direct==ASC){
			long base=src[startPoint];
			while(leftPoint<rightPoint){
				while(src[rightPoint]>=base&&leftPoint<rightPoint){
					rightPoint--;
				}
				src[leftPoint]=src[rightPoint];
				while(src[leftPoint]<=base&&leftPoint<rightPoint){
					leftPoint++;
				}
				src[rightPoint]=src[leftPoint];
			}
			src[leftPoint]=base;
		}else{
			long base=src[endPoint];
			while(leftPoint<rightPoint){
				while(src[leftPoint]>=base&&leftPoint<rightPoint){
					leftPoint++;
				}
				src[rightPoint]=src[leftPoint];
				while(src[rightPoint]<=base&&leftPoint<rightPoint){
					rightPoint--;
				}
				src[leftPoint]=src[rightPoint];
			}
			src[leftPoint]=base;
		}
		if(startPoint<leftPoint)
			sortByQuick(src,startPoint,leftPoint-1,direct);
		if(endPoint>rightPoint+1)
			sortByQuick(src,rightPoint+1,endPoint,direct);
	}
	/**
	 * 
	 * 
	 * @category  快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByQuick(float[] src,int startPoint,int endPoint,SortDirect direct){
		
		int leftPoint=0;
		int rightPoint=endPoint;
		if(direct==ASC){
			float base=src[startPoint];
			while(leftPoint<rightPoint){
				while(src[rightPoint]>=base&&leftPoint<rightPoint){
					rightPoint--;
				}
				src[leftPoint]=src[rightPoint];
				while(src[leftPoint]<=base&&leftPoint<rightPoint){
					leftPoint++;
				}
				src[rightPoint]=src[leftPoint];
			}
			src[leftPoint]=base;
		}else{
			float base=src[endPoint];
			while(leftPoint<rightPoint){
				while(src[leftPoint]>=base&&leftPoint<rightPoint){
					leftPoint++;
				}
				src[rightPoint]=src[leftPoint];
				while(src[rightPoint]<=base&&leftPoint<rightPoint){
					rightPoint--;
				}
				src[leftPoint]=src[rightPoint];
			}
			src[leftPoint]=base;
		}
		if(startPoint<leftPoint)
			sortByQuick(src,startPoint,leftPoint-1,direct);
		if(endPoint>rightPoint+1)
			sortByQuick(src,rightPoint+1,endPoint,direct);
	}
	/**
	 * 
	 * 
	 * @category  快排算法
	 * @param src
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByQuick(double[] src,int startPoint,int endPoint,SortDirect direct){
		
		int leftPoint=0;
		int rightPoint=endPoint;
		if(direct==ASC){
			double base=src[startPoint];
			while(leftPoint<rightPoint){
				while(src[rightPoint]>=base&&leftPoint<rightPoint){
					rightPoint--;
				}
				src[leftPoint]=src[rightPoint];
				while(src[leftPoint]<=base&&leftPoint<rightPoint){
					leftPoint++;
				}
				src[rightPoint]=src[leftPoint];
			}
			src[leftPoint]=base;
		}else{
			double base=src[endPoint];
			while(leftPoint<rightPoint){
				while(src[leftPoint]>=base&&leftPoint<rightPoint){
					leftPoint++;
				}
				src[rightPoint]=src[leftPoint];
				while(src[rightPoint]<=base&&leftPoint<rightPoint){
					rightPoint--;
				}
				src[leftPoint]=src[rightPoint];
			}
			src[leftPoint]=base;
		}
		if(startPoint<leftPoint)
			sortByQuick(src,startPoint,leftPoint-1,direct);
		if(endPoint>rightPoint+1)
			sortByQuick(src,rightPoint+1,endPoint,direct);
	}
	
	/**
	 * 
	 * 
	 * @category  快排算法
	 * @param src
	 * @param startPoint
	 * @param endPoint
	 * @param direct
	 *
	 * @author liangzhicong
	 */
	private static void sortByQuick(int[] src,int startPoint,int endPoint,SortDirect direct){
		
		int leftPoint=0;
		int rightPoint=endPoint;
		if(direct==ASC){
			int base=src[startPoint];
			while(leftPoint<rightPoint){
				while(src[rightPoint]>=base&&leftPoint<rightPoint){
					rightPoint--;
				}
				src[leftPoint]=src[rightPoint];
				while(src[leftPoint]<=base&&leftPoint<rightPoint){
					leftPoint++;
				}
				src[rightPoint]=src[leftPoint];
			}
			src[leftPoint]=base;
		}else{
			int base=src[endPoint];
			while(leftPoint<rightPoint){
				while(src[leftPoint]>=base&&leftPoint<rightPoint){
					leftPoint++;
				}
				src[rightPoint]=src[leftPoint];
				while(src[rightPoint]<=base&&leftPoint<rightPoint){
					rightPoint--;
				}
				src[leftPoint]=src[rightPoint];
			}
			src[leftPoint]=base;
		}
		if(startPoint<leftPoint)
			sortByQuick(src,startPoint,leftPoint-1,direct);
		if(endPoint>rightPoint+1)
			sortByQuick(src,rightPoint+1,endPoint,direct);
	}
	
	public static void main(String[] args) {
		int[] arr=new int[]{8,0,1,4,3,5,8,7};
//		List<Integer> list=new ArrayList<Integer>();
//		list.add(8);
//		list.add(0);
//		list.add(1);
//		list.add(4);
//		list.add(3);
//		list.add(5);
//		list.add(8);
		sortByQuick(arr,DESC);
		for(Integer a:arr){
			System.out.print(a);
			System.out.print(",");
		}
	}
}
