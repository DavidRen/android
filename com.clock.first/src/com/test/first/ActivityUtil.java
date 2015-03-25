package com.test.first;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;

public class ActivityUtil extends Activity {

	
		 /**
		 * ���ص�ǰ��Ļ�Ƿ�Ϊ������
		 * @param context
		 * @return ���ҽ�����ǰ��ĻΪ����ʱ����true,���򷵻�false��
		 */
		 public static boolean isScreenOriatationPortrait(Context context) {
		 return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
		 }
}
