package com.test.first;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;

public class ActivityUtil extends Activity {

	
		 /**
		 * 返回当前屏幕是否为竖屏。
		 * @param context
		 * @return 当且仅当当前屏幕为竖屏时返回true,否则返回false。
		 */
		 public static boolean isScreenOriatationPortrait(Context context) {
		 return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
		 }
}
