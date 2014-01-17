package activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

public class LauncherUtil {

	private static final int DISPLAY_TIME = 2000;
	private static Intent intent;

	
	/**
	 * @author se
	 * @version 2014. 1. 17.   
	 * @param activity
	 * @param cls 
	 * start activity with delay & animation

	 */
	public static void go(final Activity activity, final Class<?> cls) {
		Handler handler;

		handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				intent = new Intent(activity, cls);
				activity.startActivity(intent);
				activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
				activity.finish();
			}
		}, DISPLAY_TIME);
	}



}
