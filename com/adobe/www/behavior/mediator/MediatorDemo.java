package com.adobe.www.behavior.mediator;

/**
 * 中介者模式的优点
	适当地使用中介者模式可以避免同事类之间的过度耦合，使得各同事类之间可以相对独立地使用。
	使用中介者模式可以将对象间一对多的关联转变为一对一的关联，使对象间的关系易于理解和维护。
	使用中介者模式可以将对象的行为和协作进行抽象，能够比较灵活的处理对象间的相互作用
 
 * 中介者模式也是用来降低类类之间的耦合的，因为如果类类之间有依赖关系的话，不利于功能的拓展和维护，因为只要修改一个对象，
 * 其它关联的对象都得进行修改。如果使用中介者模式，只需关心和Mediator类的关系，具体类类之间的关系及调度交给Mediator就行，
 * 这有点像spring容器的作用
 * 
 * @author Mac
 *
 */
public class MediatorDemo {

	AbColleague collA = new ColleagueA();  
	AbColleague collB = new ColleagueB();  
      
	AbMediator am = new Mediator(collA, collB);  
//	其实就是把原来处理对象关系的代码重新封装到一个中介类中，通过这个中介类来处理对象间的关系 	
//    System.out.println("==========通过设置A影响B==========");  
//    collA.setNumber(1000, am);  
//    System.out.println("collA的number值为："+collA.getNumber());  
//    System.out.println("collB的number值为A的10倍："+collB.getNumber());  
//
//    System.out.println("==========通过设置B影响A==========");  
//    collB.setNumber(1000, am);  
//    System.out.println("collB的number值为："+collB.getNumber());  
//    System.out.println("collA的number值为B的0.1倍："+collA.getNumber()); 
}

abstract class AbMediator{
	
	AbColleague A;
	AbColleague B;
	
	public AbMediator(AbColleague A, AbColleague B){
		
		this.A = A;
		this.B = B;
		
	}
	
	//中介者将A B两对象的关系影响 封装到了中介者中去
	public abstract void AaffectB();
	public abstract void BaffectA();
	
}

class Mediator extends AbMediator{
	
	public Mediator(AbColleague a, AbColleague b){
		
		super(a, b);
		
	}
	
	public void AaffectB(){
		
		int number = A.getNumber();
		B.setNumber(number*100);
		
	}
	
	public void BaffectA(){
		
		int number = B.getNumber();
		A.setNumber(number/100);
	}
	
}

abstract class AbColleague{
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	int number;
	
	public abstract void setNumber(int number,AbMediator am);
	
}

class ColleagueA extends AbColleague{  
	  
	@Override
	public void setNumber(int number, AbMediator am) {
		
		this.number = number;
		am.AaffectB();
		
	}  
}  
  
class ColleagueB extends AbColleague{  

	@Override
	public void setNumber(int number, AbMediator am) {
		// TODO Auto-generated method stub
		this.number = number;
		am.BaffectA();
	}  
}  