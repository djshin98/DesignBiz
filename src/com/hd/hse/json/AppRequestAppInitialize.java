package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRequestAppInitialize extends JSONWrapper{
	public static final int ID = 3;
	public static final String NAME = "AppRequestAppInitialize";
	public String		requestKey;	//요청 키
	public String		devicePlatform;	//안드로이드는 android , 아이폰은 ios 
	public String		deviceKey;	//각 디바이스 키 정보
	public String		os;	//operating system 명
	public String		osversion;	//디바이스 의 OS 버젼 정보
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRequestAppInitialize d ){
		this.requestKey = d.requestKey;
		this.devicePlatform = d.devicePlatform;
		this.deviceKey = d.deviceKey;
		this.os = d.os;
		this.osversion = d.osversion;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( requestKey != null ){ obj.put("requestKey",requestKey); }
			else{ obj.put("requestKey",""); }
			if( devicePlatform != null ){ obj.put("devicePlatform",devicePlatform); }
			else{ obj.put("devicePlatform",""); }
			if( deviceKey != null ){ obj.put("deviceKey",deviceKey); }
			else{ obj.put("deviceKey",""); }
			if( os != null ){ obj.put("os",os); }
			else{ obj.put("os",""); }
			if( osversion != null ){ obj.put("osversion",osversion); }
			else{ obj.put("osversion",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppRequestAppInitialize decoding(JSONObject obj) {
		AppRequestAppInitialize wrapper = new AppRequestAppInitialize();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("devicePlatform") ){ wrapper.devicePlatform = obj.getString("devicePlatform"); }
			if( obj.has("deviceKey") ){ wrapper.deviceKey = obj.getString("deviceKey"); }
			if( obj.has("os") ){ wrapper.os = obj.getString("os"); }
			if( obj.has("osversion") ){ wrapper.osversion = obj.getString("osversion"); }
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
		if( devicePlatform != null ){
			System.out.println(prefix+"devicePlatform : " + devicePlatform);
		}else{
			System.out.println(prefix+"devicePlatform : null" );
		}
		if( deviceKey != null ){
			System.out.println(prefix+"deviceKey : " + deviceKey);
		}else{
			System.out.println(prefix+"deviceKey : null" );
		}
		if( os != null ){
			System.out.println(prefix+"os : " + os);
		}else{
			System.out.println(prefix+"os : null" );
		}
		if( osversion != null ){
			System.out.println(prefix+"osversion : " + osversion);
		}else{
			System.out.println(prefix+"osversion : null" );
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
			obj.put("requestObjectName", AppRequestAppInitialize.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
