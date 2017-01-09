package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppSupplierAttendance extends JSONWrapper{
	public static final int ID = 16;
	public static final String NAME = "AppSupplierAttendance";
	public Timestamp		workdate;	//요청 일(시간) 정보
	public String		supcode;	//협력사 코드
	public String		company;	//협력사 명
	public int		todayCount;	//입출입 카운트
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppSupplierAttendance d ){
		this.workdate = d.workdate;
		this.supcode = d.supcode;
		this.company = d.company;
		this.todayCount = d.todayCount;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( workdate != null ){ obj.put("workdate",DATE.toJSON(workdate) ); }
			else{ obj.put("workdate",""); }
			if( supcode != null ){ obj.put("supcode",supcode); }
			else{ obj.put("supcode",""); }
			if( company != null ){ obj.put("company",company); }
			else{ obj.put("company",""); }
			obj.put("todayCount",todayCount);
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppSupplierAttendance decoding(JSONObject obj) {
		AppSupplierAttendance wrapper = new AppSupplierAttendance();
		try {
			if( obj.has("workdate") ){
				String str = obj.getString("workdate");
				if( str != null && !str.isEmpty() ){
					wrapper.workdate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("supcode") ){ wrapper.supcode = obj.getString("supcode"); }
			if( obj.has("company") ){ wrapper.company = obj.getString("company"); }
			if( obj.has("todayCount") ){ wrapper.todayCount = obj.getInt("todayCount"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		System.out.println(prefix+"workdate : " + workdate);
		if( supcode != null ){
			System.out.println(prefix+"supcode : " + supcode);
		}else{
			System.out.println(prefix+"supcode : null" );
		}
		if( company != null ){
			System.out.println(prefix+"company : " + company);
		}else{
			System.out.println(prefix+"company : null" );
		}
		System.out.println(prefix+"todayCount : " + todayCount);
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
			obj.put("requestObjectName", AppSupplierAttendance.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
