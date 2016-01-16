/**
 *
 * 
 * @author Tim Leung
 */
package com.sin90lzc.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * 
 * @author Tim Leung
 */
public class GsonFactory {
	
	private static Gson gs;
	
	public static Gson getInstance(){
		if(gs==null){
			gs=new GsonBuilder().create();
		}
		return gs;
	}
}
