package com.adobe.www.create.factory;

/**
 * 静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 * @author Mac
 *
 */
public class StatciFactoryMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticMethodFactory.produceSmsSender().send();
	}

}

class StaticMethodFactory{
	
	public static Sender produceMailSender(){
		return new MailSender();
	}
	
	public static Sender produceSmsSender(){
		return new SmsSender();
	}
}