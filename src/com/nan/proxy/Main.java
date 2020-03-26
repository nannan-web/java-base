package com.nan.proxy;

public class Main {

	public static void main(String[] args) {
		// 代理的真是对象
		UserServer realUserService = new UserServerImpl();

		UserServer proxy = (UserServer) new MyInvocationHandler().bind(realUserService);
		proxy.work();
//		UserServer stuProxy = (UserServer) Proxy.newProxyInstance(UserServer.class.getClassLoader(), new Class<?>[]{UserServer.class}, myInvocationHandler);
//		stuProxy.work();
	}

}
