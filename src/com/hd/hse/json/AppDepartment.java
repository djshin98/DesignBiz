package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppDepartment extends JSONWrapper{
	public static final int ID = 57;
	public static final String NAME = "AppDepartment";
	public String		code;	//부서 코드
	public String		name;	//부서 명
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppDepartment d ){
		this.code = d.code;
		this.name = d.name;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( code != null ){ obj.put("code",code); }
			else{ obj.put("code",""); }
			if( name != null ){ obj.put("name",name); }
			else{ obj.put("name",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppDepartment decoding(JSONObject obj) {
		AppDepartment wrapper = new AppDepartment();
		try {
			if( obj.has("code") ){ wrapper.code = obj.getString("code"); }
			if( obj.has("name") ){ wrapper.name = obj.getString("name"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( code != null ){
			System.out.println(prefix+"code : " + code);
		}else{
			System.out.println(prefix+"code : null" );
		}
		if( name != null ){
			System.out.println(prefix+"name : " + name);
		}else{
			System.out.println(prefix+"name : null" );
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
			obj.put("requestObjectName", AppDepartment.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
