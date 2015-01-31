package com.adobe.www.behavior.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 解释器模式定义语言的文法，并且建立一个解释器来解释该语言中的句子。它属于类的行为模式。这里的语言意思是使用规定格式和语法的代码。
 * 应用环境：
 * 如果一种特定类型的问题发生的频率足够高，那么可能就值得将该问题的各个实例表述为一个简单语言中的句子。
 * 这样就可以构建一个解释器，该解释器通过解释这些句子来解决该问题。而且当文法简单、效率不是关键问题的时候效果最好。
 * 优点：
	
	解释器是一个简单语法分析工具，它最显著的优点就是扩展性，修改语法规则只要修改相应的非终结符表达式就可以了，若扩展语法，则只要增加非终结符类就可以了。

   缺点：
	
	解释器模式会引起类膨胀，每个语法都要产生一个非终结符表达式，语法规则比较复杂时，可能产生大量的类文件，难以维护。
	解释器模式采用递归调用方法，它导致调试非常复杂。
	解释器由于使用了大量的循环和递归，所以当用于解析复杂、冗长的语法时，效率是难以忍受的.
	
注意事项：
尽量不要在重要模块中使用解释器模式，因为维护困难。在项目中，可以使用shell,JRuby,Groovy等脚本语言来代替解释器模式。	
 *
 */
public class InterpreterDemo {
	
	
	private static Expression ex;
	
	private static Context con;	

	public static void main(String[] args){
		
		con  = new Context();
		//设置变量
		Variable a = new Variable();
		Variable b = new Variable();
		//设置常量
		Constant c = new Constant(2);
		//为变量赋值
		con.addValue(a, 5);
		con.addValue(b, 7);
		//运算，对句子的结构我们自己来分析，构造
		ex = new Add(new Add(c,a),new Add(c,b));
		System.out.println(ex.intercept(con));

	}
	
	
}
/**
 * 上下文（环境）角色，使用HashMap来存储变量对应的值
 * @author Mac
 *
 */
class Context{
	
	private Map valueMap = new HashMap();
	
	public void addValue(Variable x, int y){
		
		valueMap.put(x, new Integer(y));
		
	}
	
	public int lookupValue(Variable x){
		
		return ((Integer)valueMap.get(x)).intValue();
		
	}
	
}

/**
 * 抽象表达式角色，也可以用接口来实现
 * @author Mac
 *
 */
abstract class Expression{
	
	public abstract int intercept(Context con);
	
}

/**
 * 定义终结符表达式角色
 */
class Constant extends Expression{
	
	
	private int i;
	
	public Constant(int i){
		
		this.i = i;
	
	}

	@Override
	public int intercept(Context con) {
		
		return i;
		
	}

}

/**
 * 定义变量
 * @author Mac
 *
 */
class Variable extends Expression{

	@Override
	public int intercept(Context con) {

		return con.lookupValue(this);
		
	}
	
}

/**
 * 非终结符表达式
 * @author Mac
 *
 */
class Add extends Expression{
	
	private Expression left,right;
	
	public Add(Expression left, Expression right){
		
		this.left = left;
		this.right = right;
		
	}

	@Override
	public int intercept(Context con) {
		
		return left.intercept(con) + right.intercept(con);
		
	}
	
}

/**
 * 非终结符表达式
 * @author Mac
 *
 */
class Subtract extends Expression{
	
	private Expression left,right;
	
	public Subtract(Expression left, Expression right){
		this.left = left;
		this.right = right;
	}

	@Override
	public int intercept(Context con) {

		return left.intercept(con) - right.intercept(con);
	
	}
	
	
}