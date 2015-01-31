package com.adobe.www.behavior.state;

/**
 * 
 * 核心思想就是：当对象的状态改变时，同时改变其行为
 * 根据这个特性，状态模式在日常开发中用的挺多的，尤其是做网站的时候，我们有时希望根据对象的某一属性，区别开他们的一些功能，比如说简单的权限控制等
 * @author Mac
 *
 */
public class StateDemo {

	public static void main(String[] args){
		
		State state = new State();
		state.setValue("state2");
		State state2 = new State("no state");
		
		Context context = new Context(state);
		context.method();
		Context context2 = new Context(state2);
		context2.method();
		
	}
	
}

/**
 * 状态类 : 当状态类的状态改变的时候，Context类可以实现不同的输出
 * @author Mac
 *
 */
class State{
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public State(){}
	
	public State(String value){
		
		this.value = value;
	
	}
	
	public void method1(){
		
		System.out.println("Executing the first method");
		
	}
	
	public void method2(){
		
		System.out.println("Executing the second method");
		
	}
}

/**
 * Context类用来实现状态的切换
 * @author Mac
 *
 */
class Context{
	
	private State state;
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Context(State state){
		
		this.state = state;
		
	}
	
	public void method(){
		
		if("state1".equals(state.getValue())){
			state.method1();
		}else if("state2".equals(state.getValue())){
			state.method2();
		}else{
			System.out.println("No state and mehtod exists");
		}
		
	}
}