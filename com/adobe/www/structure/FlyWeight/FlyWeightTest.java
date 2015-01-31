package com.adobe.www.structure.flyweight;

/**
 * 享元模式的主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用。
 * @author Mac
 * 数据库连接池
 *
 */
public class FlyWeightTest {

	public static void main(String[] args){
		
		Integer i1 = 127;
		Integer i2 = 127;
		Integer i3 = 128;
		Integer i4 = 128;
		Integer i5 = 129;
		Integer i6 = 129;
		
		System.out.println(i1 == i2);
		System.out.println(i3 == i4);
		System.out.println(i5 == i6);
	}
	
}
