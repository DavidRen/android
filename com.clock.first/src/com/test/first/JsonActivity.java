package com.test.first;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JsonActivity extends Activity implements OnClickListener {

	private String jsonData = "";
	private static final String TAG = "JSONUtil";
	public String address = "http://config.anyan.com:80/sdk.json";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);
		Button b1 = (Button) findViewById(R.id.button_get_json);
		b1.setOnClickListener(this);
	}

	/**
	 * 从指定的URL中获取数组
	 * 
	 * @param urlPath
	 * @return
	 * @throws Exception
	 */
	public static String readParse(String urlPath) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = 0;
		URL url = new URL(urlPath);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		InputStream inStream = conn.getInputStream();
		while ((len = inStream.read(data)) != -1) {
			outStream.write(data, 0, len);
		}
		inStream.close();
		return new String(outStream.toByteArray());// 通过out.Stream.toByteArray获取到写的数据
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_get_json: {
			try {
				new Thread() {
					@Override
					public void run() {
						try {
							//List<Person> mlists = new ArrayList<Person>();
							String str = readParse(address);
							ren(str);
							//JSONObject array = new JSONObject(str);
//			                for (int i = 0; i < array.length(); i++) {
//			                        JSONObject item = array.getJSONObject(i);
//			                        String docArr = item.getString("doc");
//			                        String hfileArr = item.getString("hfile");
//			                        int toolArr = item.getInt("tool");
//			                        //mlists.add(new Person(name, address, age));
//			                }

			                //return mlists;
							Log.v(TAG, jsonData);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}.start();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			}
		}
	}
	
	public static void ren(String str) {
//		String str = "{'TI':[{'value':'aa1','count':10},{'value':'aa2','count':15},{'value':'aa3','count':20}]," +
//				"'AB':[{'value':'ab','count':110},{'value':'ab2','count':115},{'value':'ab3','count':210}]}";
		JSONArray newArray = new JSONArray();
		JSONObject newJson = new JSONObject();
		try {
			JSONObject obj = new JSONObject(str);
			Iterator it = obj.keys();
//			while (it.hasNext()) {
//				String key = (String) it.next();
			//	String value = obj.getString("sdk");
				JSONArray array = obj.getJSONArray("sdk");
				for(int i=0;i<array.length();i++){
					JSONObject jsonobject = array.getJSONObject(i);
					jsonobject.put("name", key);
					jsonobject.put("exp", key+"="+jsonobject.getString("value"));
					newArray.put(jsonobject);
				}
//			}
			newJson.put("groups",newArray);
			System.out.println(newJson);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	

}
