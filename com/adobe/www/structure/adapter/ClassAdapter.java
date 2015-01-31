package com.adobe.www.structure.adapter;
/**
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式
 * @author Mac
 *
 */
public class ClassAdapter extends Source implements Targetable {

	/*
	 * 对类的适配器模式的核心思想就是：有一个Source类，拥有一个方法，待适配，目标接口时Targetable，通过Adapter类，将Source的功能扩展到Targetable里，看代码：
	 * */
	public void method2(){
		System.out.println("对类的适配： This is the method 2 from targetable");
	}
	
}
