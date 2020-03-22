package com.nan.serializable;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 请注意，一个类的对象要想序列化成功，必须满足两个条件：
	 * (1)该类必须实现 java.io.Serializable 接口。
	 * (2)该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是短暂的transient。无赋值时变量的值被设为初始值，如 int 型的是 0，对象型的是 null
	 * (3)静态变量属于类的状态，因此 序列化并不保存静态变量
	 * 如果你想知道一个 Java 标准类是否是可序列化的，请查看该类的文档。检验一个类的实例是否能序列化十分简单， 只需要查看该类有没有实现 java.io.Serializable接口。
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String name;

	public int age;
	
	public static int staticVar = 5;
	
	public transient int num;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", num=" + num + "]";
	}


}
