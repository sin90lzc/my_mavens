package com.sin90lzc.jndi;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sin90lzc.test.Bike;
/**
 * jndi服务器环境:jboss final 7.1.1
 * 
 * 要点：
 * 1.依赖的客户端类库，看pom.xml
 * 
 * 2.连接jndi服务器需要安全认证，所以要先在服务器端调用add-user.sh添加application-user，
 * 	并在客户端设置Context.SECURITY_PRINCIPAL/Context.SECURITY_CREDENTIALS作为用户名/密码
 * 
 * 3.jboss的jndi服务器是一个只读的环境，向jndi容器写数据，需要使用jboss中的jboss-cli.sh命令写入数据，如
 * $ ./jboss-cli.sh -c --controller=localhost:9999
 * /subsystem=naming/binding=java\:jboss\/exported\/simple/:add(binding-type=simple,value=100,type=int)	-->简单对象
 * /subsystem=naming/binding=java\:jboss\/exported\/bike/:add(binding-type=object-factory,module=com.sin90lzc,class=com.sin90lzc.test.BikeFactory)
 * 
 * 
 * 注意：远程访问jboss7中的jndi只能访问命名空间java:jboss/exported下的数据
 * 
 * 在jboss的jndi服务器中绑定一个复杂对象的办法：
 * 1.编写ObjectFactory的实现类
 * 2.把实现类及依赖的类打包后放到${jboss_home}/module/package/main目录下
 * 3.${jboss_home}/module/package/main目录下添加文件module.xml，内容如下：
 * <?xml version="1.0" encoding="UTF-8"?> 
 * <module xmlns="urn:jboss:module:1.1" name="test.jndi.demo"> 
 * <resources> <resource-root path="testJndiBinding.jar"/> </resources> 
 * <dependencies> <module name="javax.api"/> </dependencies> 
 * </module>
 * 4.重启服务器，并使用jboss-cli.sh添加对象
 * /subsystem=naming/binding=java\:jboss\/exported\/bike/:add(binding-type=object-factory,module=com.sin90lzc,class=com.sin90lzc.test.BikeFactory)
 * 
 * 
 * 参考文章：http://middlewaremagic.com/jboss/?p=1690
 * 
 * @author Tim
 *
 */
public class UseTest {
	
	private static Context remoteContext;
	

	@BeforeClass
	public static void initTest() throws Exception {
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				org.jboss.naming.remote.client.InitialContextFactory.class
						.getName());
		env.put(Context.PROVIDER_URL, "remote://localhost:4447");
		env.put(Context.SECURITY_PRINCIPAL, "tim");
		env.put(Context.SECURITY_CREDENTIALS, "123");
		remoteContext = new InitialContext(env);
	}

	private static void initContext() throws NamingException  {
		Context xxx=remoteContext.createSubcontext("java:global/xxx");
		xxx.bind("tim", "Tim Leung");
		String tim=(String)remoteContext.lookup("xxx/tim");
		System.out.println(tim);
	}
	@Test
	public void testJNDI() throws NamingException{
		Context c=UseTest.remoteContext;
		Integer simple=(Integer)c.lookup("simple");
		Assert.assertTrue(simple==100);
		Object b=c.lookup("bike");
		System.out.println(b.getClass().equals(Bike.class));
		
	}
	
	
}
