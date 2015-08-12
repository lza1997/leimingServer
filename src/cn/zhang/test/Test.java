package cn.zhang.test;

import org.json.JSONException;
import org.json.JSONObject;

public class Test{

	@org.junit.Test
	public void TestJsonObject(){
		try {
			JSONObject ob = new JSONObject("111");  //会报错的,格式不对
			System.out.println(ob.get("loginState"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
