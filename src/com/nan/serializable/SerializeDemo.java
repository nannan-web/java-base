package com.nan.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo {

	public static void main(String[] args) {
		serialize();
		deserialize();
	}
	
	public static void serialize() {
		User user = new User();
		user.setName("张三");
		user.setAge(10);
//		user.setNum(1);
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
		System.err.println(User.staticVar);
	}
	
	
	
	public static void deserialize() {
		User user = null;
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
		System.out.println(user.toString());
		System.out.println(user.staticVar);
		System.out.println(User.staticVar);
	}


}
