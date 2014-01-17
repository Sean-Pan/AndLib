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
<<<<<<< HEAD
		/* do something before app is exited ... */
=======
		// do something before app is exit ...
>>>>>>> b4c1140d7bef696ca6d74d5ec31dc17c87047230
	}


}
