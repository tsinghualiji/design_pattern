package com.adobe.www.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 原型模式的优点
     原型模式允许在运行时动态改变具体的实现类型。原型模式可以在运行期间，由客户来注册符合原型接口的实现类型，也可以动态地改变具体的实现类型，看起来接口没有任何变化，
     但其实运行的已经是另外一个类实例了。因为克隆一个原型就类似于实例化一个类。

   原型模式的缺点
     原型模式最主要的缺点是每一个类都必须配备一个克隆方法。配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类来说不是很难，
     而对于已经有的类不一定很容易，特别是当一个类引用不支持序列化的间接对象，或者引用含有循环结构的时候
 * @author Mac
 *
 */
public class DeepClone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

/**
 * 要实现深复制，需要采用流的形式读入当前对象的二进制输入，再写出二进制数据对应的对象。
 * @author Mac
 */
class DeepPrototype implements Cloneable,Serializable{
	
	private static final long serialVersionID = 1L;
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public SerializableObject getObj() {
		return obj;
	}

	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}

	private String string;
	
	private SerializableObject obj;
	
	/*浅复制*/
	public Object clone() throws CloneNotSupportedException{
		
		return (DeepPrototype)super.clone();
	}
	
	/*深复制*/
	public Object deepClone() throws IOException,ClassNotFoundException{
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream ous = new ObjectOutputStream(baos);
		ous.writeObject(this);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object o = ois.readObject();

		return o;
	}
	
}

class SerializableObject implements Serializable{

	private static final long serialVersionUID = 1L;
	
}