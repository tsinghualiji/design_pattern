package com.adobe.www.structure.decorator;
/**
 * 装饰器模式的应用场景：

	1、需要扩展一个类的功能。

	2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）

	缺点：产生过多相似的对象，不易排错
 * @author Mac
 *
 */
public class DecoratorTest {

}

interface Sourceable{
	
	public void method();
	
}

class Source implements Sourceable{

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("This is the method from source");
	}
	
}

class Decorator implements Sourceable{
	
	private Source source;
	
	public Decorator(Source source){
		super();
		this.source = source;
	}
	
	@Override
	public void method() {

		System.out.println("Before decorator");
		
		source.method();
		
		System.out.println("After decorator");
		
	}
	
}