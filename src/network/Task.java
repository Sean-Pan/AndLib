package network;

import android.os.Handler;


public abstract class Task {

	protected Object result;
	protected boolean isCancel;
	private Handler handler;

	public interface OnProcessCompletedListener {
		void onCompleted(Task task);
	}

	OnProcessCompletedListener mListener;

	public void setOnCompleteListener(OnProcessCompletedListener listener) {
		this.mListener = listener;
	}

	// give a abstraction to sub classes
	public abstract Object getResult();
	protected abstract void doTask() ;

	protected boolean isCanceled() {
		return isCancel;
	}

	public void cancelTask() {
		isCancel = true;
		notifyTaskDone();
	}

	private void notifyTaskDone() {
		if (mListener != null) {
			mListener.onCompleted(this);
		}
	}

	protected void process() {

		if (handler != null) {
			handler.post(new Runnable() {

				@Override
				public void run() {

					// execute concurrent task
					doTask();

					// notify task is done
					notifyTaskDone();
				}
			});
		} else {
			notifyTaskDone();
		}

	}
}
