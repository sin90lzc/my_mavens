package com.sin90lzc.jndi.dns;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

/**
 * ����������ʹ��jndi������dns������ 
 * �õ���spi��service provider interface)��ʹ�õ�����{@com.sun.jndi.dns.DnsContextFactory}
 * �����ԭ����jre��rt.jar���£���ϸ����com.sun.jndi�İ��£�����ldap�ȵ�spi��
 * @author Tim
 *
 */
@SuppressWarnings("restriction")
public class DnsParser {

	private static InitialDirContext dnsContext;

	static {
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				com.sun.jndi.dns.DnsContextFactory.class.getName());
		try {
			dnsContext = new InitialDirContext(env);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
/**
 * ����������������ip��ַ
 * @param dnsServer DNS������ip��ַ
 * @param domainName ����
 * @return
 * @throws NamingException
 */
	public static Set<String> parseDomainName(String dnsServer,
			String domainName) throws NamingException {
		Hashtable table = dnsContext.getEnvironment();
		if (table.containsKey(Context.PROVIDER_URL))
			dnsContext.removeFromEnvironment(Context.PROVIDER_URL);
		else
			dnsContext.addToEnvironment(Context.PROVIDER_URL, "dns://"
					+ dnsServer);

		Attributes attrs = dnsContext.getAttributes(domainName,
				new String[] { "A" });
		Set<String> ips = new HashSet<String>();
		for (NamingEnumeration<? extends Attribute> e = attrs.getAll(); e
				.hasMoreElements();) {
			Attribute attr = e.next();
			int s = attr.size();
			for (int i = 0; i < s; i++) {
				ips.add(String.valueOf(attr.get(i)));
			}
		}
		return ips;

	}

	public static void main(String[] args) throws Exception {
		Set<String> ips = parseDomainName("202.96.134.33", "www.baidu.com");
		for (Iterator<String> it = ips.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
