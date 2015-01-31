package com.adobe.www.create.factory;

/**
 * 多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象
 * @author Mac
 *
 */
public class MultiFactoryMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiMethodFacotry mmf = new MultiMethodFacotry();
		mmf.produceSmsSender().send();
	}

}

class MultiMethodFacotry{
	
	public Sender produceMailSender(){
		return new MailSender();
	}
	
	public Sender produceSmsSender(){
		return new SmsSender();
	}
	
}