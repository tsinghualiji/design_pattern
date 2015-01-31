package com.adobe.www.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class DynamicProxy1{

	public static Object getProxy(final Object src){
		
		Object proxyObject =
				Proxy.newProxyInstance(DynamicProxy1.class.getClassLoader(),
						src.getClass().getInterfaces(),
						new InvocationHandler(){
							@Override
							public Object invoke(Object proxy, Method method,
									Object[] args) throws Throwable {
								// TODO Auto-generated method stub
								return method.invoke(src, args);
							}
				});

		return proxyObject;
	}

}
//此类不但是代理类也是执行句柄
class DynamicProxy2 implements InvocationHandler{

	//声明被代理的类
	private Object src;
	
	private DynamicProxy2(Object src){
		this.src = src;
	}
	
	//提供一个静态方法返回代理对象
	public static Object factory(Object src){
		Object proxyObj = Proxy.newProxyInstance(
				DynamicProxy2.class.getClassLoader(), 
				src.getClass().getInterfaces(),
				new DynamicProxy2(src)
				);
		return proxyObj;
	}
	
	//实现执行拦截方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println("正在执行的方法是：" + method.getName());
		Object rtValue = method.invoke(src, args);
		return rtValue;
	}
	
}

public class DynamicProxy{
	
	
	public static void main(String[] args){
		
		//声明被代理的对象
		final List list = new ArrayList();
		final Map map = new HashMap();
		//生成代理类
		Object obj = Proxy.newProxyInstance(
				DynamicProxy.class.getClassLoader(),
				new Class[]{List.class},
				new InvocationHandler(){

					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("正在被执行的方法是："+method.getName());
						return method.invoke(list, args);
					}
				});
		List list2 = (List)obj;
		list2.add("添加了一个字符串");
		System.out.println(list2.getClass());
		
	}

}