/**
 *
 * 
 * @author Tim Leung
 */
package com.sin90lzc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sin90lzc.resp.CorsResponse;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * 
 * @author Tim Leung
 */
@Controller
public class AngularTestController {

	/**
	 * @category CORS的所有options请求都通过该方法返回
	 *  
	 * @author Tim Leung
	 * 
	 * created on 2015年11月22日 上午10:18:41
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="cors/*",method={RequestMethod.OPTIONS})
	public HttpHeaders cors(String id,HttpServletRequest request) {
		return CorsResponse.getCorsHeaders();
	}
	
	
	@RequestMapping(value="cors/getData",method={RequestMethod.POST})
	public ResponseEntity<String> getData(){
		Map<String,Object> ret=new HashMap<String,Object>();
		
		ret.put("name", "Tim");
		ret.put("mobile", "18520581357");
		
		return CorsResponse.build(ret);
	}
	
	
	
	/**
	 * @category 是否登录
	 *  
	 * @author Tim Leung
	 * 
	 * create on 2015 2015年11月22日 上午10:19:20
	 * @return
	 */
	@RequestMapping(value="cors/isLogin",method={RequestMethod.POST})
	public ResponseEntity<String> isLogin(String id,HttpServletRequest request) {
		request.getMethod();
		id = request.getParameter("id");
		
		Map<String,Object> ret=new HashMap<String,Object>();
		if(id!=null && id.equals("Tim")){
			ret.put("status", true);
			ret.put("msg", "��¼�ɹ�");
			ret.put("user", "Tim");
		}else{
			ret.put("status", false);
			ret.put("msg", "���¼");
		}
		
		return CorsResponse.build(ret);
	}
	public static class Req{
		public String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
	}
	/**
	 * @category 获取书本列表
	 *  
	 * @author Tim Leung
	 * 
	 * create on 2015 2015年11月22日 上午10:31:49
	 * @return
	 */
	@RequestMapping(value="cors/getBookList",method={RequestMethod.POST})
	public ResponseEntity<String> getBookList(){
		List<Book> bookList=new ArrayList<Book>();
		for(int i=0;i<5;i++){
			Book b=new Book();
			b.id=i;
			b.name="book_"+i;
			bookList.add(b);
		}
		return CorsResponse.build(bookList);
	}
	
	/**
	 * @category 获取书本明细
	 *  
	 * @author Tim Leung
	 * 
	 * create on 2015 2015��11��22�� ����10:31:49
	 * @return
	 */
	@RequestMapping(value="cors/getBookDetail",method={RequestMethod.POST})
	public ResponseEntity<String> getBookDetail(Integer id){
		Book b=new Book();
		b.id=id;
		b.name="book_"+id;
		
		return CorsResponse.build(b);
	}
	
	public static class Book{
		public int id;
		public String name;
	}
	
}
