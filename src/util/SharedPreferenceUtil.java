package util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class SharedPreferenceUtil {

	private static final String TAG = "SharedPreferenceUtil";
	private static SharedPreferenceUtil SPUtil = new SharedPreferenceUtil();
	private Context context;

	public static SharedPreferenceUtil getInstance(Context context) {
		SPUtil.context = context;
		return SPUtil;
	}

	/**
	 * String형의 값을 저장하는 함수
	 * 
	 * @param key
	 *            키
	 * @param value
	 *            값
	 */
	public void putSharedPreference(String key, String value) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(key, value);
		editor.commit();
	}

	/**
	 * int형의 값을 저장하는 함수
	 * 
	 * @param key
	 *            키
	 * @param value
	 *            값
	 */
	public void putSharedPreference(String key, int value) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	/**
	 * Boolean형의 값을 저장하는 함수
	 * 
	 * @param key
	 *            키
	 * @param value
	 *            값
	 */
	public void putSharedPreference(String key, Boolean value) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	/**
	 * long형의 값을 저장하는 함수
	 * 
	 * @param key
	 *            키
	 * @param value
	 *            값
	 */
	public void putSharedPreference(String key, long value) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putLong(key, value);
		editor.commit();
	}

	/**
	 * float형의 값을 저장하는 함수
	 * 
	 * @param key
	 *            키
	 * @param value
	 *            값
	 */
	public void putSharedPreference(String key, float value) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putFloat(key, value);
		editor.commit();
	}

	/**
	 * String형의 값을 가져옵니다.
	 * 
	 * @param key
	 *            키
	 * @return String key에 해당되는 값이 존재할때 value, 존재하지 않으면 ""
	 */
	public String getStringSharedPreference(String key) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		return prefs.getString(key, "");
	}


	/**
	 * int형의 값을 가져옵니다.
	 * 
	 * @param key
	 *            키
	 * @return int key에 해당되는 값이 존재할때 value, 존재하지 않으면 0
	 */
	public int getIntSharedPreference(String key) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		return prefs.getInt(key, 0);
	}

	/**
	 * Boolean형의 값을 가져옵니다.
	 * 
	 * @param key
	 *            키
	 * @return Boolean key에 해당되는 값이 존재할때 value, 존재하지 않으면 false
	 */
	public Boolean getBooleanSharedPreference(String key) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		return prefs.getBoolean(key, false);
	}

	/**
	 * long형의 값을 가져옵니다.
	 * 
	 * @param key
	 *            키
	 * @return long key에 해당되는 값이 존재할때 value, 존재하지 않으면 0
	 */
	public long getLongSharedPreference(String key) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		return prefs.getLong(key, 0);
	}

	/**
	 * float형의 값을 가져옵니다.
	 * 
	 * @param key
	 *            키
	 * @return float key에 해당되는 값이 존재할때 value, 존재하지 않으면 0
	 */
	public float getFloatSharedPreference(String key) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		return prefs.getFloat(key, 0);
	}

	/**
	 * key값에 해당되는 value값이 존재하는가?
	 * 
	 * @param key
	 *            키
	 * @return Boolean 존재할경우 true, 아님 false
	 */
	public Boolean hasPreference(String key) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		return prefs.contains(key);
	}

	public void removePreference(String key) {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		if (hasPreference(key)) {
			editor.remove(key);
			Log.e(TAG, "key값과 value값을 삭제했습니다.");
		} else {
			Log.e(TAG, "key값이 존재하지 않습니다.");
		}
	}
}