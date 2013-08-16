package com.sin90lzc.training.training_rtti;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.regex.Pattern;

/**
 * 该类用于测试java中的动态代理的机制。从输出信息中可以得出下面的结论：
 * <ul>
 * <li>
 * 通过
 * {@link java.lang.reflect.Proxy#newProxyInstance(ClassLoader, Class[], InvocationHandler)}
 * 方法生成的代理对象与
 * {@link java.lang.reflect.InvocationHandler#invoke(Object, Method, Object[])}
 * 中第一个参数是同一个对象。</li>
 * <li>
 * 生成的代理对象除了代理接口中定义的方法之外，它还会自动地代理{@link java.lang.Object#equals(Object)}、
 * {@link java.lang.Object#hashCode()}、{@link java.lang.Object#toString()}
 * 方法。意思是通过代理对象调用equals、hashCode、toString方法时，实际的调用为
 * {@link java.lang.reflect.InvocationHandler#invoke(Object, Method, Object[])}</li>
 * <li>
 * 生成的代理对象继承于{@link java.lang.reflect.Proxy}</li>
 * <li>
 * 	生成的代理类会自带一个构造函数Proxy$0(InvocationHandler)形式
 * </li>
 * </ul>
 * 
 * @author tim
 * @version 1.0
 */
public class TF_Proxy {

	/**
	 * 需要代理的接口，它提供3个方法。play()、stop()、pause()
	 * @author tim
	 *
	 */
	public interface Music {
		void play();

		void stop();

		void pause();
	}

	/**
	 * 实现Music接口的类
	 * @author tim
	 *
	 */
	public static class RealMusic implements Music {

		public String toString() {
			return "RealMusic";
		}

		public void play() {
			System.out.println(this + " play()");
		}

		public void stop() {
			System.out.println(this + " stop()");
		}

		public void pause() {
			System.out.println(this + " pause()");
		}

	}

	/**
	 * InvocationHandler的实现
	 * @author tim
	 *
	 */
	public static class MusicInvokeHandler implements InvocationHandler {

		private Music music;
		private Pattern pattern = Pattern.compile("\\w+\\.");

		private Object proxy;

		public MusicInvokeHandler(Music music) {
			this.music = music;
		}

		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			this.proxy = proxy;
			System.out.println("before invoke:"
					+ pattern.matcher(method.toString()).replaceAll(""));
			Object result = method.invoke(music, args);
			System.out.println("after invoke:"
					+ pattern.matcher(method.toString()).replaceAll(""));
			System.out
					.println("-------------------------------------------------------");
			return result;
		}

		public Object getProxy() {
			return proxy;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MusicInvokeHandler handler = new MusicInvokeHandler(new RealMusic());
		Music musicProxy = (Music) Proxy.newProxyInstance(
				Music.class.getClassLoader(), new Class[] { Music.class },
				handler);
		musicProxy.play();
		Object proxyInMethod = handler.getProxy();
		assert musicProxy == proxyInMethod;
		musicProxy.stop();
		musicProxy.pause();
		musicProxy.toString();
		musicProxy.equals(musicProxy);
		musicProxy.hashCode();
		musicProxy.getClass();
		System.out
				.println("--------------------------about the proxy object----------------------");
		Class<?> proxyClass = musicProxy.getClass();
		Method[] methods = proxyClass.getMethods();
		Class<?>[] faces = proxyClass.getInterfaces();
		Class<?> supClass = proxyClass.getSuperclass();
		Constructor<?>[] constructors = proxyClass.getConstructors();
		System.out.println("***proxy object's methods:");
		for (Method m : methods) {
			System.out.println(m.toString());
		}
		System.out.println("***proxy object's constructors:");
		for (Constructor<?> c : constructors) {
			System.out.println(c.toString());
		}
		System.out.println("***proxy object's interfaces:");
		for (Class<?> c : faces) {
			System.out.println(c.getSimpleName());
		}
		System.out.println("***proxy object's SuperClass:");
		System.out.println(supClass.getSimpleName());
	}

}
