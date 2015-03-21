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
 * 这里演试了使用jndi来访问dns服务器 
 * 用到的spi（service provider interface)来使用的类是{@com.sun.jndi.dns.DnsContextFactory}
 * 这个类原来在jre的rt.jar包下，仔细看下com.sun.jndi的包下，还有ldap等的spi。
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
 * 根据域名解析它的ip地址
 * @param dnsServer DNS服务器ip地址
 * @param domainName 域名
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
