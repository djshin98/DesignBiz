package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRequestLogin extends JSONWrapper{
	public static final int ID = 8;
	public static final String NAME = "AppRequestLogin";
	public String		requestKey;	//요청 키
	public String		userid;	//사용자 아이디
	public String		password;	//사용자 암호 *******
	public String		deviceKey;	//디바이스 키
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRequestLogin d ){
		this.requestKey = d.requestKey;
		this.userid = d.userid;
		this.password = d.password;
		this.deviceKey = d.deviceKey;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( requestKey != null ){ obj.put("requestKey",requestKey); }
			else{ obj.put("requestKey",""); }
			if( userid != null ){ obj.put("userid",userid); }
			else{ obj.put("userid",""); }
			if( password != null ){ obj.put("password",password); }
			else{ obj.put("password",""); }
			if( deviceKey != null ){ obj.put("deviceKey",deviceKey); }
			else{ obj.put("deviceKey",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppRequestLogin decoding(JSONObject obj) {
		AppRequestLogin wrapper = new AppRequestLogin();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("userid") ){ wrapper.userid = obj.getString("userid"); }
			if( obj.has("password") ){ wrapper.password = obj.getString("password"); }
			if( obj.has("deviceKey") ){ wrapper.deviceKey = obj.getString("deviceKey"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( requestKey != null ){
			System.out.println(prefix+"requestKey : " + requestKey);
		}else{
			System.out.println(prefix+"requestKey : null" );
		}
		if( userid != null ){
			System.out.println(prefix+"userid : " + userid);
		}else{
			System.out.println(prefix+"userid : null" );
		}
		if( password != null ){
			System.out.println(prefix+"password : " + password);
		}else{
			System.out.println(prefix+"password : null" );
		}
		if( deviceKey != null ){
			System.out.println(prefix+"deviceKey : " + deviceKey);
		}else{
			System.out.println(prefix+"deviceKey : null" );
		}
		if( language != null ){
			System.out.println(prefix+"language : " + language);
		}else{
			System.out.println(prefix+"language : null" );
		}

		System.out.println(prefix+"}");
	}
	public JSONObject toMessage(){
		JSONObject obj = new JSONObject();
		try {
			obj.put("requestObjectName", AppRequestLogin.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
