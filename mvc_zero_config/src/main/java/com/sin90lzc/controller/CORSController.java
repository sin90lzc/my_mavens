/**
 *
 * created on 2015��11��21�� ����2:03:43
 * 
 * @author Tim Leung
 */
package com.sin90lzc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * 
 * @author Tim Leung
 */
@Controller
public class CORSController {

//	@RequestMapping(value="**",method={RequestMethod.OPTIONS})
//	public HttpHeaders responseCORSRequest(){
//		HttpHeaders ret=new HttpHeaders();
//		ret.set("Access-Control-Allow-Origin", "*");
//		ret.set("Access-Control-Allow-Methods", "POST");
//		ret.set("Access-Control-Max-Age", "60");
//		ret.set("Access-Control-Allow-Headers", "Content-Type,*");
//		ret.set("Access-Control-Allow-Credentials", "true");
//		
//		return ret;
//	}
	

	public static class Book{
		public int id;
		public String bookName;
	}
	@RequestMapping(value="/getBook",method={RequestMethod.POST})
	public ResponseEntity<String> getBook(){
		Gson gs=new Gson();
		Book book=new Book();
		book.id=1;
		book.bookName="人生格言";
		HttpHeaders ret=new HttpHeaders();
		ret.set("Access-Control-Allow-Origin", "*");
		ret.set("Access-Control-Allow-Methods", "POST");
		ret.set("Access-Control-Max-Age", "60");
		ret.set("Access-Control-Allow-Headers", "Content-Type,*");
		ret.set("Access-Control-Allow-Credentials", "true");
		ret.set("Content-Type","application/json;charset=UTF-8");
		return new ResponseEntity<String>(gs.toJson(book), ret,HttpStatus.OK);
	}
}
