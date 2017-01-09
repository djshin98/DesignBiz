package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppResponseSCCheckListDelete extends JSONWrapper{
	public static final int ID = 52;
	public static final String NAME = "AppResponseSCCheckListDelete";
	public String		requestKey;	//요청 키
	public String		result;	//요청 처리 결과값
	public String		resultMessage;	//처리 오류 상세 메시지
	public String		sitecode;	//현장 코드값
	public String		userid;	//사용자 아이디
	public Timestamp		date;	//작업일시
	public String		work;	//작업
	public Timestamp		checkDate;	//요청일시
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppResponseSCCheckListDelete d ){
		this.requestKey = d.requestKey;
		this.result = d.result;
		this.resultMessage = d.resultMessage;
		this.sitecode = d.sitecode;
		this.userid = d.userid;
		this.date = d.date;
		this.work = d.work;
		this.checkDate = d.checkDate;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( requestKey != null ){ obj.put("requestKey",requestKey); }
			else{ obj.put("requestKey",""); }
			if( result != null ){ obj.put("result",result); }
			else{ obj.put("result",""); }
			if( resultMessage != null ){ obj.put("resultMessage",resultMessage); }
			else{ obj.put("resultMessage",""); }
			if( sitecode != null ){ obj.put("sitecode",sitecode); }
			else{ obj.put("sitecode",""); }
			if( userid != null ){ obj.put("userid",userid); }
			else{ obj.put("userid",""); }
			if( date != null ){ obj.put("date",DATE.toJSON(date) ); }
			else{ obj.put("date",""); }
			if( work != null ){ obj.put("work",work); }
			else{ obj.put("work",""); }
			if( checkDate != null ){ obj.put("checkDate",DATE.toJSON(checkDate) ); }
			else{ obj.put("checkDate",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppResponseSCCheckListDelete decoding(JSONObject obj) {
		AppResponseSCCheckListDelete wrapper = new AppResponseSCCheckListDelete();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("result") ){ wrapper.result = obj.getString("result"); }
			if( obj.has("resultMessage") ){ wrapper.resultMessage = obj.getString("resultMessage"); }
			if( obj.has("sitecode") ){ wrapper.sitecode = obj.getString("sitecode"); }
			if( obj.has("userid") ){ wrapper.userid = obj.getString("userid"); }
			if( obj.has("date") ){
				String str = obj.getString("date");
				if( str != null && !str.isEmpty() ){
					wrapper.date = Timestamp.valueOf( str );
				}
			}
			if( obj.has("work") ){ wrapper.work = obj.getString("work"); }
			if( obj.has("checkDate") ){
				String str = obj.getString("checkDate");
				if( str != null && !str.isEmpty() ){
					wrapper.checkDate = Timestamp.valueOf( str );
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
		if( result != null ){
			System.out.println(prefix+"result : " + result);
		}else{
			System.out.println(prefix+"result : null" );
		}
		if( resultMessage != null ){
			System.out.println(prefix+"resultMessage : " + resultMessage);
		}else{
			System.out.println(prefix+"resultMessage : null" );
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
		System.out.println(prefix+"date : " + date);
		if( work != null ){
			System.out.println(prefix+"work : " + work);
		}else{
			System.out.println(prefix+"work : null" );
		}
		System.out.println(prefix+"checkDate : " + checkDate);
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
			obj.put("requestObjectName", AppResponseSCCheckListDelete.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
