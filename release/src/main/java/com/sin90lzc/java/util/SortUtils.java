/**
 * 
 */
package com.sin90lzc.java.util;

import java.util.ArrayList;
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
	
	private static <T extends Comparable> List<T> sortByMaoPao(List<T> src,SortDirect direct,boolean isNew) {
		
		List<T> dest=null;
		if(isNew){
			if(src==null || src.size()<1){
				return new ArrayList<T>();
			}else{
				dest=new ArrayList<T>(src);
			}
		}else{
			dest=src;
		}
		if(direct==ASC){
			for(int i=0;i<dest.size()-1;i++){
				for(int j=dest.size()-1;j>=1;j--){
					T last=dest.get(j);
					T pre=dest.get(j-1);
					if(last.compareTo(pre)<0){
						dest.set(j-1, last);
						dest.set(j,pre);
					}
				}
			}
		}else{
			for(int i=0;i<dest.size()-1;i++){
				for(int j=dest.size()-1;j>=1;j--){
					T last=dest.get(j);
					T pre=dest.get(j-1);
					if(last.compareTo(pre)>0){
						dest.set(j-1, last);
						dest.set(j,pre);
					}
				}
			}
		}
		
		return dest;
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
	
	public static void main(String[] args) {
//		double[] arr=new double[]{8,0,1,4,3,5,8};
		List<Integer> list=new ArrayList<Integer>();
		list.add(8);
		list.add(0);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(5);
		list.add(8);
		List<Integer> abc=	sortByMaoPao(list,DESC,true);
		for(Integer a:list){
			System.out.print(a);
			System.out.print(",");
		}
	}
}
