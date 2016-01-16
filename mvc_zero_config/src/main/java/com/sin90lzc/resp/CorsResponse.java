/**
 *
 * created on 2015年11月21日 下午5:52:17
 * 
 * @author Tim Leung
 */
package com.sin90lzc.resp;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.sin90lzc.util.GsonFactory;

/**
 * copyright
 * 
 * all right reserved.
 * 
 * created on 2015年11月21日 下午5:52:17
 * 
 * @author Tim Leung
 */
public final class CorsResponse {

	private static HttpHeaders headers;
	
	public static final ResponseEntity<String> build(Object o) {
		if (o == null) {
			return null;
		}
		Gson gs = GsonFactory.getInstance();
		return new ResponseEntity<String>(")]}',\n"+gs.toJson(o), getCorsHeaders(), HttpStatus.OK);
	}
	
	public final static HttpHeaders getCorsHeaders(){
		if(headers==null){
			headers = new HttpHeaders();
			headers.set("Access-Control-Allow-Origin", "*");
			headers.set("Access-Control-Allow-Methods", "POST");
//			headers.set("Access-Control-Max-Age", "60");
//			headers.set("Access-Control-Allow-Headers", "Content-Type,*");
//			headers.set("Access-Control-Allow-Credentials", "true");
//			headers.set("Content-Type", "application/json;charset=UTF-8");
		}
		return headers;
	}

}
