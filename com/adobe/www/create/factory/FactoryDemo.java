package com.adobe.www.create.factory;

/**
 *  普通工厂模式，对实现了同一接口的一些类进行实例的创建
 */
public class FactoryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Factory factory = new Factory();
		factory.produce("mail").send();
	}

}


interface Sender{	
	public void send();
}

class MailSender implements Sender{

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("This is mail sender");
	}
	
}

class SmsSender implements Sender{

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("This is SMS sender");
	}
	
}

class Factory{
	
	public Sender produce(String type){
		
		if("mail".equals(type)){
			return new MailSender();
		}else if("sms".equals(type)){
			return new SmsSender();
		}else{
			System.out.println("请输入正确的类型");
			return null;
		}
	}
	
	
}