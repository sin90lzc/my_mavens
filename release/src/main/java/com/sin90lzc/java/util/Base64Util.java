/**
 * 
 */
package com.sin90lzc.java.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.sin90lc.java.exception.ArgumentIllegalityException;

/**
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
		StringBuffer sb=new StringBuffer(4*b.length/3+4);
		
		for(int i=0;i<b.length;i+=3){
			if(b.length-i<3){
				int leftChars=b.length-i;
				switch(leftChars){
				case 1:
					byte i0=b[i];
					int c0=i0>>2;
					int c1=(i0<<4 & 0x30);
					sb.append(base64char(c0)).append(base64char(c1)).append('=').append('=');
					break;
				case 2:
					i0=b[i];
					byte i1=b[i+1];
					c0=i0>>2;
					c1=(i0<<4 & 0x30 ) | (i1 >>4);
					int c2=(i1 << 2 & 0x3c);
					sb.append(base64char(c0)).append(base64char(c1)).append(base64char(c2)).append('=');
					break;
				}
			}else{
				byte i0=b[i];
				byte i1=b[i+1];
				byte i2=b[i+2];
				
				int c0=i0>>2;
				int c1=(i0<<4 & 0x30 ) | (i1 >>4);
				int c2=(i1 << 2 & 0x3c) | (i2 >> 6);
				int c3=i2&0x3f;
				sb.append(base64char(c0)).append(base64char(c1)).append(base64char(c2)).append(base64char(c3));
			}
		}
		
		return sb.toString();
	}
	
	public static byte[] decode(String encode){
		
		ByteArrayOutputStream bos=new ByteArrayOutputStream(encode.length()/4*3);
		byte[] bytes=new byte[encode.length()/4*3];
		for(int i=0,j=0;i<encode.length();i+=4,j+=3){
			byte[] b=new byte[3];
			char c0=encode.charAt(i);
			char c1=encode.charAt(i+1);
			char c2=encode.charAt(i+2);
			char c3=encode.charAt(i+3);
			
			if(c0!='='){
				byte b1=(byte)(c0<<2);
				if(c1!='='){
					
				}
			}
			b[j]=(byte)(c0<<2 | c1>>4);
			b[j+1]=(byte)(c1<<4 | c2>>2);
			b[j+2]=(byte)(c2<<6 | c3);
			
		}
		return bos.toByteArray();
	}
	
	private static char base64char(int i){
		if(i>=0 && i<='z'-'a'){
			return (char)('A'+i);
		}
		if(i>'z'-'a' && i<=26*2-1){
			return (char)('a'+i-26);
		}
		if(i>26*2-1 && i<=26*2+9){
			return (char)('0'+(i-26*2));
		}
		if(i==62){
			return '+';
		}
		if(i==63){
			return '/';
		}
		return ' ';
	}
}
