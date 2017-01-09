package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppResponseLogin extends JSONWrapper{
	public static final int ID = 11;
	public static final String NAME = "AppResponseLogin";
	public String		requestKey;	//요청 키
	public String		result;	//요청 처리 결과값
	public String		resultMessage;	//처리 오류 상세 메시지
	public String		userid;	//사용자 아이디
	public String		password;	//사용자 암호 *******
	public String		comment;	//로그인 비고
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppResponseLogin d ){
		this.requestKey = d.requestKey;
		this.result = d.result;
		this.resultMessage = d.resultMessage;
		this.userid = d.userid;
		this.password = d.password;
		this.comment = d.comment;
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
			if( userid != null ){ obj.put("userid",userid); }
			else{ obj.put("userid",""); }
			if( password != null ){ obj.put("password",password); }
			else{ obj.put("password",""); }
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
	public static AppResponseLogin decoding(JSONObject obj) {
		AppResponseLogin wrapper = new AppResponseLogin();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("result") ){ wrapper.result = obj.getString("result"); }
			if( obj.has("resultMessage") ){ wrapper.resultMessage = obj.getString("resultMessage"); }
			if( obj.has("userid") ){ wrapper.userid = obj.getString("userid"); }
			if( obj.has("password") ){ wrapper.password = obj.getString("password"); }
			if( obj.has("comment") ){ wrapper.comment = obj.getString("comment"); }
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
			obj.put("requestObjectName", AppResponseLogin.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
