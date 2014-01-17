package activity;

import android.app.Activity;
import android.widget.Toast;

/**
 * @author se
 * tab a back button with in a 2 seconds, app will be existed
 */
public class BackPressCloseHandler {

	private long backKeyPressedTime = 0;
	private Toast toast;

	private Activity activity;

	public BackPressCloseHandler(Activity context) {
		this.activity = context;
	}

	public void onBackPressed() {
		if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
			backKeyPressedTime = System.currentTimeMillis();
			showGuide();
			return;
		}
		if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
			activity.finish();
			toast.cancel();
		}

	}


	private void showGuide() {
		/* do something before app is exited ... */
	}


}
