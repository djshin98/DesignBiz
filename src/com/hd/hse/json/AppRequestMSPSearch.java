package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRequestMSPSearch extends JSONWrapper{
	public static final int ID = 30;
	public static final String NAME = "AppRequestMSPSearch";
	public String		requestKey;	//요청 키
	public String		sitecode;	//현장 코드값
	public String		userid;	//사용자 아이디
	public Timestamp		work_date;	//작업일시
	public String		sub_code;	//서브 코드
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRequestMSPSearch d ){
		this.requestKey = d.requestKey;
		this.sitecode = d.sitecode;
		this.userid = d.userid;
		this.work_date = d.work_date;
		this.sub_code = d.sub_code;
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
			if( work_date != null ){ obj.put("work_date",DATE.toJSON(work_date) ); }
			else{ obj.put("work_date",""); }
			if( sub_code != null ){ obj.put("sub_code",sub_code); }
			else{ obj.put("sub_code",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppRequestMSPSearch decoding(JSONObject obj) {
		AppRequestMSPSearch wrapper = new AppRequestMSPSearch();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("sitecode") ){ wrapper.sitecode = obj.getString("sitecode"); }
			if( obj.has("userid") ){ wrapper.userid = obj.getString("userid"); }
			if( obj.has("work_date") ){
				String str = obj.getString("work_date");
				if( str != null && !str.isEmpty() ){
					wrapper.work_date = Timestamp.valueOf( str );
				}
			}
			if( obj.has("sub_code") ){ wrapper.sub_code = obj.getString("sub_code"); }
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
		System.out.println(prefix+"work_date : " + work_date);
		if( sub_code != null ){
			System.out.println(prefix+"sub_code : " + sub_code);
		}else{
			System.out.println(prefix+"sub_code : null" );
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
			obj.put("requestObjectName", AppRequestMSPSearch.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
