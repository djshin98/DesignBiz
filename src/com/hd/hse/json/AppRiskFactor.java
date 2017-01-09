package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRiskFactor extends JSONWrapper{
	public static final int ID = 32;
	public static final String NAME = "AppRiskFactor";
	public String		writer;	//작성자
	public String		comment;	//코멘트
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRiskFactor d ){
		this.writer = d.writer;
		this.comment = d.comment;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( writer != null ){ obj.put("writer",writer); }
			else{ obj.put("writer",""); }
			if( comment != null ){ obj.put("comment",comment); }
			else{ obj.put("comment",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppRiskFactor decoding(JSONObject obj) {
		AppRiskFactor wrapper = new AppRiskFactor();
		try {
			if( obj.has("writer") ){ wrapper.writer = obj.getString("writer"); }
			if( obj.has("comment") ){ wrapper.comment = obj.getString("comment"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( writer != null ){
			System.out.println(prefix+"writer : " + writer);
		}else{
			System.out.println(prefix+"writer : null" );
		}
		if( comment != null ){
			System.out.println(prefix+"comment : " + comment);
		}else{
			System.out.println(prefix+"comment : null" );
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
			obj.put("requestObjectName", AppRiskFactor.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
