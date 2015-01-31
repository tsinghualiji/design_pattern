package com.adobe.www.create.singleton;

/**
 * 饿汉单例模式
   在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快
 * @author Mac
 *
 */
public class ESingleton {
	
	private static ESingleton instance= new ESingleton();
	
	private ESingleton(){}
	
	/*静态，不用同步（类加载时已初始化，不会有多线程的问题）*/
	public static ESingleton getInstance(){
		return instance;
	}

}
