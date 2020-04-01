package com.nan.threadpool;

public class Main {
	
	public static void main(String[] args) {
		
		ThreadPoolUtils.getPool().execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("静态代码块");
				System.out.println(Thread.currentThread().getName());
			}
		});
		
		ThreadPoolSingle.getInstance().getPool().execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("单例模式-饿汉");
				System.out.println(Thread.currentThread().getName());
			}
		});;
		
		
	}

}
