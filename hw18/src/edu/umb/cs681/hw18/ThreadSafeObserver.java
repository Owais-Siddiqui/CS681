package edu.umb.cs681.hw18;

@FunctionalInterface
public interface ThreadSafeObserver {
	public void update(ThreadSafeObservable obs, Object obj);
}
