package com.sin90lzc.train.java_network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import junit.framework.Assert;
import junit.framework.TestCase;

public class URLTest extends TestCase{
	
	public static final String URLString="http://sin90lzc.iteye.com:80/blog/1529889?name=tim&sexy=man#110";
	public static final String PROTOCAL="http";
	public static final String HOST="sin90lzc.iteye.com";
	public static final int PORT=80;
	public static final String FILE="/blog/1529889?name=tim&sexy=man";
	public static final String PATH="/blog/1529889";
	public static final String AUTHORITY="sin90lzc.iteye.com:80";
	public static final int DEFAULTPORT=80;
	public static final String QUERY="name=tim&sexy=man";
	public static final String REFERENCE="110";
	//public static final String USERINFO="";
	
	/**
	 * 测试URL的创建，及URL中各参数的含义
	 * @throws Exception
	 */
	public void testURL() throws Exception{
		URL url=new URL(URLString);
		checkURL(url);
		url=new URL(new URL("http://sin90lzc.iteye.com:80"), "/blog/1529889?name=tim&sexy=man#110");
		checkURL(url);
	}
	
	/**
	 * 测试通过URLConnection读取网络信息
	 * @throws Exception
	 */
	public void testReadFromURL() throws Exception{
		URL url=new URL(URLString);
		URLConnection conn=url.openConnection();
		//需要添加请求参数User-Agent，不然iteye会认为这是爬虫程序
		conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.57 Safari/536.11");
		conn.setDoInput(true);
		conn.setRequestProperty("ACCEPT", "text/html");
		InputStream is=conn.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(is));
		String content=null;
		while((content=reader.readLine())!=null){
			System.out.println(content);
		}
		is.close();
		reader.close();
	}
	
	/**
	 * 检查url的各项属性
	 * @param url
	 */
	private void checkURL(URL url){
		//检查URL的协议（如http,file,ftp等等)
		Assert.assertEquals(PROTOCAL, url.getProtocol());
		//检查URL中的主机信息（不包含端口）
		Assert.assertEquals(HOST, url.getHost());
		//检查URL中的端口号（如果url中没明确定义，则返回-1)
		Assert.assertEquals(PORT, url.getPort());
		//检查URL协议对应的默认端口号。如http为80
		Assert.assertEquals(DEFAULTPORT, url.getDefaultPort());
		//检查Authority,暂时理解是Host+Port
		Assert.assertEquals(AUTHORITY, url.getAuthority());
		//检查URL表示的File信息，它等于PATH+QUERY
		Assert.assertEquals(FILE, url.getFile());
		//检查URL中的PATH，它为Port与QUERY之间的字符串
		Assert.assertEquals(PATH, url.getPath());
		//检查URL中的Query,它为URL的参数段
		Assert.assertEquals(QUERY, url.getQuery());
		//检查URL中的引用，它即是achor,在"#"之后的字符串
		Assert.assertEquals(REFERENCE, url.getRef());
		//暂时还不知道userinfo是什么
		Assert.assertNull(url.getUserInfo());
	}
}
