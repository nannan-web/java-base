package com.nan.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo {

	/**
	 * /**
	 * 请注意，一个类的对象要想序列化成功，必须满足两个条件：
	 * (1)该类必须实现 java.io.Serializable 接口。
	 * (2)该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是短暂的transient。无赋值时变量的值被设为初始值，如 int 型的是 0，对象型的是 null
	 * (3)静态变量属于类的状态，因此 序列化并不保存静态变量
	 * 如果你想知道一个 Java 标准类是否是可序列化的，请查看该类的文档。检验一个类的实例是否能序列化十分简单， 只需要查看该类有没有实现 java.io.Serializable接口。
	 * 
	 */
	public static void main(String[] args) {
		serialize();
		deserialize();
	}
	
	public static void serialize() {
		User user = new User();
		user.setName("张三");
		user.setAge(10);
		user.setNum(1);
		try {
			FileOutputStream fileOut = new FileOutputStream(
					"/Users/snn/dev/eclipse-workspace/java-base/doc/SerializeDemoUser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(user);
			out.close();
			fileOut.close();
			User.staticVar = 10;
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	
	
	public static void deserialize() {
		User user = new User();
		try {
			FileInputStream fileIn = new FileInputStream("/Users/snn/dev/eclipse-workspace/java-base/doc/SerializeDemoUser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			user = (User) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.err.println(user.toString());
	}


}
