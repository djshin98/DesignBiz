package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppLaborAttendance extends JSONWrapper{
	public static final int ID = 19;
	public static final String NAME = "AppLaborAttendance";
	public String		group;	//구분
	public String		jickjong;	//직종
	public String		name;	//이름
	public Timestamp		attendTime;	//출근 시간 정보
	public Timestamp		closingTime;	//퇴근 시간 정보
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppLaborAttendance d ){
		this.group = d.group;
		this.jickjong = d.jickjong;
		this.name = d.name;
		this.attendTime = d.attendTime;
		this.closingTime = d.closingTime;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( group != null ){ obj.put("group",group); }
			else{ obj.put("group",""); }
			if( jickjong != null ){ obj.put("jickjong",jickjong); }
			else{ obj.put("jickjong",""); }
			if( name != null ){ obj.put("name",name); }
			else{ obj.put("name",""); }
			if( attendTime != null ){ obj.put("attendTime",DATE.toJSON(attendTime) ); }
			else{ obj.put("attendTime",""); }
			if( closingTime != null ){ obj.put("closingTime",DATE.toJSON(closingTime) ); }
			else{ obj.put("closingTime",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppLaborAttendance decoding(JSONObject obj) {
		AppLaborAttendance wrapper = new AppLaborAttendance();
		try {
			if( obj.has("group") ){ wrapper.group = obj.getString("group"); }
			if( obj.has("jickjong") ){ wrapper.jickjong = obj.getString("jickjong"); }
			if( obj.has("name") ){ wrapper.name = obj.getString("name"); }
			if( obj.has("attendTime") ){
				String str = obj.getString("attendTime");
				if( str != null && !str.isEmpty() ){
					wrapper.attendTime = Timestamp.valueOf( str );
				}
			}
			if( obj.has("closingTime") ){
				String str = obj.getString("closingTime");
				if( str != null && !str.isEmpty() ){
					wrapper.closingTime = Timestamp.valueOf( str );
				}
			}
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( group != null ){
			System.out.println(prefix+"group : " + group);
		}else{
			System.out.println(prefix+"group : null" );
		}
		if( jickjong != null ){
			System.out.println(prefix+"jickjong : " + jickjong);
		}else{
			System.out.println(prefix+"jickjong : null" );
		}
		if( name != null ){
			System.out.println(prefix+"name : " + name);
		}else{
			System.out.println(prefix+"name : null" );
		}
		System.out.println(prefix+"attendTime : " + attendTime);
		System.out.println(prefix+"closingTime : " + closingTime);
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
			obj.put("requestObjectName", AppLaborAttendance.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
