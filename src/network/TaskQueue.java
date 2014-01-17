package network;
import java.util.ArrayList;

public class TaskQueue {

	private static TaskQueue instance;
	
	// task queue with 
	private ArrayList<Task> workList = new ArrayList<Task>();
		
	// get a instance with a singleton pattern
	public static TaskQueue getInstance() {
		if(instance == null) {
			return new TaskQueue();
		}
		return instance;
	}

	private TaskQueue() {}

	public synchronized void enqueue(Task task) {

		// declare a maximum task size, default is 5
		final int MAX_TASK_SIZE = 5;

		if(workList.size() <= MAX_TASK_SIZE) {
			task.process();
			workList.add(task);
			notify();
		}
	}

	public Task dequeue() {

		while(workList.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return workList.remove(0);
	}

	public void removeTask(Task request) {
		workList.remove(request);
	}


}
