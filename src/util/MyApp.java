package util;

import android.app.Application;
import android.content.Context;

/**
 * Explanation : helper class for get a app context
 * @version : 2014. 1. 17.
 * @author : se
 * AndLib / package util;
 */

public class MyApp extends Application {

	private static Context context;
	
	public void onCreate() {
		context = this;
	}
	
	public static Context getContext(){
		return context;
	}
	
	
	
}
