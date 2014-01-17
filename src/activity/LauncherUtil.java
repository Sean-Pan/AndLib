package activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

public class LauncherUtil {

	private static final int DISPLAY_TIME = 2000;
	private static Intent intent;

	/**
	 * 특정 시간동안 화면을 보여주고 다음 엑티비티로 이동한다.
	 *
	 * @param activity 호출하는쪽 액티비티
	 * @param cls      호출되는 쪽의 클래스
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
