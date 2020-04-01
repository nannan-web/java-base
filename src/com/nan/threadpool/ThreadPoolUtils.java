package com.nan.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {

	private static ExecutorService pool;

	static {
		// 核心线程数
		int corePoolSize = 5;
		// 最大线程数
		int maximumPoolSize = 10;
		// 线程获取不到任务时的超时时间
		int keepAliveTime = 10;
		// 对应超时时间的单位
		TimeUnit unit = TimeUnit.HOURS;
		// 创建队列
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
		// 线程工厂
//		ThreadFactory threadFactory =Executors.defaultThreadFactory();//默认
		ThreadFactory threadFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setName("线程名称");
				t.setDaemon(true);// 是否是守护进程
				return t;
			}
		};
		// 线程拒绝策略
//		RejectedExecutionHandler handler = new RejectedExecutionHandler() {
//			
//			@Override
//			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//				
//				
//			}
//		};
		RejectedExecutionHandler handler = (t, p) -> {
		};
		ExecutorService executorServicepool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
				workQueue, threadFactory, handler);
		pool = executorServicepool;
	}

	public static ExecutorService getPool() {
//		System.out.println("11111");
		return pool;
	}
}
