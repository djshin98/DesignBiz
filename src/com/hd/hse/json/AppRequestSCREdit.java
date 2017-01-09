package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRequestSCREdit extends JSONWrapper{
	public static final int ID = 71;
	public static final String NAME = "AppRequestSCREdit";
	public String		requestKey;	//요청 키
	public String		sitecode;	//현장 코드값
	public String		userid;	//사용자 아이디
	public Timestamp		date;	//작업일시
	public AppNCRDetail		doc;	//부적합보고서
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRequestSCREdit d ){
		this.requestKey = d.requestKey;
		this.sitecode = d.sitecode;
		this.userid = d.userid;
		this.date = d.date;
		this.doc = d.doc;
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
			if( date != null ){ obj.put("date",DATE.toJSON(date) ); }
			else{ obj.put("date",""); }
			if( doc != null ){ obj.put("doc",doc.encoding() ); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppRequestSCREdit decoding(JSONObject obj) {
		AppRequestSCREdit wrapper = new AppRequestSCREdit();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("sitecode") ){ wrapper.sitecode = obj.getString("sitecode"); }
			if( obj.has("userid") ){ wrapper.userid = obj.getString("userid"); }
			if( obj.has("date") ){
				String str = obj.getString("date");
				if( str != null && !str.isEmpty() ){
					wrapper.date = Timestamp.valueOf( str );
				}
			}
			if( obj.has("doc") ){ wrapper.doc = (AppNCRDetail) AppNCRDetail.decoding( obj.getJSONObject("doc") ); }
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
		System.out.println(prefix+"date : " + date);
		if( doc != null ){
			System.out.println(prefix+"doc : ");
			doc.print("	"+prefix);
		}else{
			System.out.println(prefix+"doc : null" );
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
			obj.put("requestObjectName", AppRequestSCREdit.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
