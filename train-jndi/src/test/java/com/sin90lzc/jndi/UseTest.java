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
 * jndi����������:jboss final 7.1.1
 * 
 * Ҫ�㣺
 * 1.�����Ŀͻ�����⣬��pom.xml
 * 
 * 2.����jndi��������Ҫ��ȫ��֤������Ҫ���ڷ������˵���add-user.sh���application-user��
 * 	���ڿͻ�������Context.SECURITY_PRINCIPAL/Context.SECURITY_CREDENTIALS��Ϊ�û���/����
 * 
 * 3.jboss��jndi��������һ��ֻ���Ļ�������jndi����д���ݣ���Ҫʹ��jboss�е�jboss-cli.sh����д�����ݣ���
 * $ ./jboss-cli.sh -c --controller=localhost:9999
 * /subsystem=naming/binding=java\:jboss\/exported\/simple/:add(binding-type=simple,value=100,type=int)	-->�򵥶���
 * /subsystem=naming/binding=java\:jboss\/exported\/bike/:add(binding-type=object-factory,module=com.sin90lzc,class=com.sin90lzc.test.BikeFactory)
 * 
 * 
 * ע�⣺Զ�̷���jboss7�е�jndiֻ�ܷ��������ռ�java:jboss/exported�µ�����
 * 
 * ��jboss��jndi�������а�һ�����Ӷ���İ취��
 * 1.��дObjectFactory��ʵ����
 * 2.��ʵ���༰������������ŵ�${jboss_home}/module/package/mainĿ¼��
 * 3.${jboss_home}/module/package/mainĿ¼������ļ�module.xml���������£�
 * <?xml version="1.0" encoding="UTF-8"?> 
 * <module xmlns="urn:jboss:module:1.1" name="test.jndi.demo"> 
 * <resources> <resource-root path="testJndiBinding.jar"/> </resources> 
 * <dependencies> <module name="javax.api"/> </dependencies> 
 * </module>
 * 4.��������������ʹ��jboss-cli.sh��Ӷ���
 * /subsystem=naming/binding=java\:jboss\/exported\/bike/:add(binding-type=object-factory,module=com.sin90lzc,class=com.sin90lzc.test.BikeFactory)
 * 
 * 
 * �ο����£�http://middlewaremagic.com/jboss/?p=1690
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
