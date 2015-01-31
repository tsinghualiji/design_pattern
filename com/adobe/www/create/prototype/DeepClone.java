package com.adobe.www.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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