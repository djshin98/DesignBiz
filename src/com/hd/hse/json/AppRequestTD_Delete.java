package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRequestTD_Delete extends JSONWrapper{
	public static final int ID = 97;
	public static final String NAME = "AppRequestTD_Delete";
	public String		requestKey;	//요청 키
	public String		sitecode;	//현장 코드값
	public String		userid;	//사용자 아이디
	public int		ser;	//
	public Timestamp		date;	//
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRequestTD_Delete d ){
		this.requestKey = d.requestKey;
		this.sitecode = d.sitecode;
		this.userid = d.userid;
		this.ser = d.ser;
		this.date = d.date;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( requestKey != null ){ obj.put("requestKey",requestKey); }
			else{ obj.put("requestKey",""); }
			if( sitecode != null ){ obj.put("sitecode",sitecode); }
			else{ obj.put("sitecode",""); }
			if( userid != null ){ obj.put("userid",userid); }
			else{ obj.put("userid",""); }
			obj.put("ser",ser);
			if( date != null ){ obj.put("date",DATE.toJSON(date) ); }
			else{ obj.put("date",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppRequestTD_Delete decoding(JSONObject obj) {
		AppRequestTD_Delete wrapper = new AppRequestTD_Delete();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("sitecode") ){ wrapper.sitecode = obj.getString("sitecode"); }
			if( obj.has("userid") ){ wrapper.userid = obj.getString("userid"); }
			if( obj.has("ser") ){ wrapper.ser = obj.getInt("ser"); }
			if( obj.has("date") ){
				String str = obj.getString("date");
				if( str != null && !str.isEmpty() ){
					wrapper.date = Timestamp.valueOf( str );
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
		if( requestKey != null ){
			System.out.println(prefix+"requestKey : " + requestKey);
		}else{
			System.out.println(prefix+"requestKey : null" );
		}
		if( sitecode != null ){
			System.out.println(prefix+"sitecode : " + sitecode);
		}else{
			System.out.println(prefix+"sitecode : null" );
		}
		if( userid != null ){
			System.out.println(prefix+"userid : " + userid);
		}else{
			System.out.println(prefix+"userid : null" );
		}
		System.out.println(prefix+"ser : " + ser);
		System.out.println(prefix+"date : " + date);
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
			obj.put("requestObjectName", AppRequestTD_Delete.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
