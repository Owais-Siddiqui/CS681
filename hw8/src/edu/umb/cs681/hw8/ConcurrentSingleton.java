package edu.umb.cs681.hw8;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton implements Runnable{
	private ConcurrentSingleton() {};
	private static ConcurrentSingleton instance = null;
	private static ReentrantLock lock = new ReentrantLock();
	
	public static ConcurrentSingleton getInstance() {
		lock.lock();
		try {
			if(instance == null) {
				instance = new ConcurrentSingleton();
				System.out.println("Class ConcurrentSingleton instance created.");
			}
		}finally {
			lock.unlock();
		}
		return instance;
	}

	@Override
	public void run() {
		System.out.println("Thread Running...");
		ConcurrentSingleton csi = ConcurrentSingleton.getInstance();
		System.out.println("current instance: " + ConcurrentSingleton.getInstance());
		System.out.println(Thread.currentThread().getId() + "Thread Terminating...");
	}
	
	public static void main(String[] args) {
		Thread thread_1 = new Thread(new ConcurrentSingleton());
		Thread thread_2 = new Thread(new ConcurrentSingleton());
		Thread thread_3 = new Thread(new ConcurrentSingleton());
		Thread thread_4 = new Thread(new ConcurrentSingleton());
		thread_1.start();
		thread_2.start();
		thread_3.start();
		thread_4.start();
		try {
			thread_1.join();
			thread_2.join();
			thread_3.join();
			thread_4.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
