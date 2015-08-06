/**
 * 
 */
package com.sin90lzc.java.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ≈≈–Úπ§æﬂ¿‡
 * @author liangzhicong
 * 
 * create at 2015ƒÍ8‘¬5»’ œ¬ŒÁ5:04:23
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
	 * @category √∞≈›≈≈–ÚÀ„∑®
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
	 * @category √∞≈›≈≈–ÚÀ„∑®
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
	 * @category √∞≈›≈≈–ÚÀ„∑®
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
	 * @category √∞≈›≈≈–ÚÀ„∑®
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
	 * @category √∞≈›≈≈–ÚÀ„∑®
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
	
	private static <K,T extends Comparable<K>> void sortByKuaiPai(List<T> src,SortDirect direct){
		
	}
	
	private static <K,T extends Comparable<K>> void sortByKuaiPai(T[] src,SortDirect direct){
		
	}
	
	private static void sortByKuaiPai(int[] src,SortDirect direct){
		if(src==null || src.length<1){
			return;
		}
		sortByKuaiPai(src, 0, src.length-1, direct);
	}
	
	private static void sortByKuaiPai(int[] src,int startPoint,int endPoint,SortDirect direct){
		int base=src[startPoint];
		int leftPoint=0;
		int rightPoint=endPoint;
		boolean isLeft=false;
		while(leftPoint!=rightPoint&&leftPoint<endPoint&&rightPoint>startPoint){
			if(src[rightPoint]<base&&!isLeft){
				src[leftPoint]=src[rightPoint];
				isLeft=true;
			}else{
				rightPoint--;
			}
			if(src[leftPoint]>base&&isLeft){
				src[rightPoint]=src[leftPoint];
				isLeft=false;
			}else{
				leftPoint++;
			}
		}
		if(startPoint!=leftPoint)
			sortByKuaiPai(src,startPoint,leftPoint,direct);
		if(endPoint!=rightPoint)
			sortByKuaiPai(src,rightPoint,endPoint,direct);
	}
	
	private static void sortByKuaiPai(long[] src,SortDirect direct){
		
	}
	private static void sortByKuaiPai(float[] src,SortDirect direct){
		
	}
	private static void sortByKuaiPai(double[] src,SortDirect direct){
		
	}
	public static void main(String[] args) {
		int[] arr=new int[]{8,0,1,4,3,5,8};
//		List<Integer> list=new ArrayList<Integer>();
//		list.add(8);
//		list.add(0);
//		list.add(1);
//		list.add(4);
//		list.add(3);
//		list.add(5);
//		list.add(8);
		sortByKuaiPai(arr,ASC);
		for(Integer a:arr){
			System.out.print(a);
			System.out.print(",");
		}
	}
}
