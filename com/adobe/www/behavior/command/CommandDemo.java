package com.adobe.www.behavior.command;

/**
 * 在程序设计中，
 * 
 * 经常设计到一个对象需要请求另外一个对象调用其方法达到某种目的，如果请求这不希望或不直接和被请求者打交道，既请求者不包含被请求者的引用，那么就可以使用命令模式。
 * 例如在军队中，指挥官请求三连偷袭敌人，但是指挥官不希望或无法直接与三连取得联系，那么可以将该请求形成一个命令，该命令的核心是让三连偷袭敌人。只要能让该命令被执行，就会实现偷袭敌人的目的。

   命令模式是关于怎样处理一个对象请求到另一个对象调用其方法完成某项任务的一种成熟的模式，这里称提出请求的对象为请求者，被请求的对象为接收者。
   在命令模式中，当一个对象请求另一个对象其调用方法时，
   
   不和被请求的对象直接打交道，
   
   而是把这这种请求封装到一个命令的对象中，起封装的手段是将请求封装在命令对象的一个方法中。命令模式的核心就是使用命令对象来封装方法调用。既请求者的请求，接受者调用方法
 * @author Mac
 * 
 * 
 * 命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开，熟悉Struts的同学应该知道，Struts其实就是一种将请求和呈现分离的技术，其中必然涉及命令模式的思想
 *
 */
public class CommandDemo {

	public static void main(String[] args){
		
		Receiver receiver = new Receiver();
		Command cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
		
	}
	
}


class Invoker{
	
	
	private Command command;
	
	public Invoker(Command command){
		
		this.command = command;
		
	}
	
	public void action(){
		
		System.out.println("Commander sends command");
		command.exec();
		
	}
	
}


interface Command{
	
	void exec();
	
}

class MyCommand implements Command{

	
	private Receiver receiver;
	
	public MyCommand(Receiver receiver){
		
		this.receiver = receiver;
		
	}
	
	@Override
	public void exec() {
		// TODO Auto-generated method stub
		receiver.action();
	}
	
}

class Receiver{

	public void action(){
		
		System.out.println("command received!!!!!");
		
	}
	
}