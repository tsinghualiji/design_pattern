package com.adobe.www.structure.adapter;

/**
 * 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，而是持有Source类的实例，以达到解决兼容性的问题
 * @author Mac
 *
 */
public class ObjectAdapter implements Targetable{

	private Source source;
	
	public ObjectAdapter(Source source){
		super();
		this.source = source;
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("对对象的适配： This is the method2 from OjbectAdapter");
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		source.method1();
	}

}
