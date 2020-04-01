package com.nan.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSingle {

	// 饿汉式
	private static ThreadPoolSingle threadPoolSingle = new ThreadPoolSingle();

	private static ExecutorService pool;

	private ThreadPoolSingle() {
		int corePoolSize = 5;
		int maximumPoolSize = 10;
		int keepAliveTime = 10;
		TimeUnit unit = TimeUnit.HOURS;
		BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		ExecutorService pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
				threadFactory);
		setPool(pool);
	};

	public static ThreadPoolSingle getInstance() {
		return threadPoolSingle;
	}

	public ExecutorService getPool() {
		return pool;
	}

	public void setPool(ExecutorService pool) {
		ThreadPoolSingle.pool = pool;
	}

}
