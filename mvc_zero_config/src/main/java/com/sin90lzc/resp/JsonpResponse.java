/**
 *
 * 
 * @author Tim Leung
 */
package com.sin90lzc.resp;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sin90lzc.util.GsonFactory;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * 
 * @author Tim Leung
 */
public final class JsonpResponse{

	private static HttpHeaders headers;
	public static final ResponseEntity<String> build(String callback,Object o){
		if(o==null){
			return null;
		}
		String resp = callback+"("+ GsonFactory.getInstance().toJson(o)+")";
		return new ResponseEntity<String>(resp,getJsonpHeader(),HttpStatus.OK);
	}
	
	public static final HttpHeaders getJsonpHeader(){
		if(headers==null){
			headers=new HttpHeaders();
			headers.set("Content-Type","application/json;charset=UTF-8");
		}
		return headers;
	}
}
