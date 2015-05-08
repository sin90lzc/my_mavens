/**
 * 
 */
package com.sin90lzc.java.util;

import java.util.Arrays;

import com.sin90lc.java.exception.ArgumentIllegalityException;

/**
 * copyright PPMoney
 * 
 * 
 * @author liangzhicong
 * 
 *         create at 2015年4月23日 下午1:16:55
 */
public class Base64Util {

	public static String encode(byte[] b, int offset, int length)
			throws Exception {

		if (b == null || b.length < 1) {
			return "";
		}

		if(offset<0){
			throw new ArgumentIllegalityException();
		}
		
		if(length<0){
			throw new ArgumentIllegalityException();
		}
		
		if (b.length < offset + length) {
			throw new ArgumentIllegalityException();
		}
		//按base64编码对齐数据,字节数应该是3的倍数
		int tailCount=length%3;
		byte[] buf=null;
		if(tailCount>0){
			buf=new byte[b.length+tailCount];
			System.arraycopy(b, 0, buf, 0, b.length);
			for(int i=b.length,j=tailCount;j>0;j--,i++){
				buf[i]=0;
			}
		}else{
			buf=b;
		}

		StringBuffer sb=new StringBuffer(buf.length/3+buf.length);
		
		for(int i=0;i<buf.length;i+=3){
			byte i0=buf[i];
			byte i1=buf[i+1];
			byte i2=buf[i+2];
			
			int c0=i0>>2;
			int c1=(i0<<4 &0x3f ) | (i1 >>4);
			int c2=(i1 << 4) | (i2 >> 6);
			int c3=i2&0x3f;
			
		}
		
		return null;
	}

	
	private static char base64char(int i){
		if(i>=0 && i<='z'-'a'){
			return (char)('a'+i);
		}
		if(i>'z'-'a' && i<=26*2-1){
			return (char)('A'+i-26);
		}
		if(i>26*2-1 && i<=26*2+9){
			return (char)(i-26*2);
		}
		if(i==63){
			return '+';
		}
		if(i==64){
			return '/';
		}
		return ' ';
	}
}
