package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRequestSCRRegisterVoice extends JSONWrapper{
	public static final int ID = 79;
	public static final String NAME = "AppRequestSCRRegisterVoice";
	public String		requestKey;	//요청 키
	public String		sitecode;	//현장 코드값
	public String		userid;	//사용자 아이디
	public String		yymm;	//
	public int		ser;	//문서 NO
	public AppVoice		voice;	//음성 녹음
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRequestSCRRegisterVoice d ){
		this.requestKey = d.requestKey;
		this.sitecode = d.sitecode;
		this.userid = d.userid;
		this.yymm = d.yymm;
		this.ser = d.ser;
		this.voice = d.voice;
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
			if( yymm != null ){ obj.put("yymm",yymm); }
			else{ obj.put("yymm",""); }
			obj.put("ser",ser);
			if( voice != null ){ obj.put("voice",voice.encoding() ); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppRequestSCRRegisterVoice decoding(JSONObject obj) {
		AppRequestSCRRegisterVoice wrapper = new AppRequestSCRRegisterVoice();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("sitecode") ){ wrapper.sitecode = obj.getString("sitecode"); }
			if( obj.has("userid") ){ wrapper.userid = obj.getString("userid"); }
			if( obj.has("yymm") ){ wrapper.yymm = obj.getString("yymm"); }
			if( obj.has("ser") ){ wrapper.ser = obj.getInt("ser"); }
			if( obj.has("voice") ){ wrapper.voice = (AppVoice) AppVoice.decoding( obj.getJSONObject("voice") ); }
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
		if( yymm != null ){
			System.out.println(prefix+"yymm : " + yymm);
		}else{
			System.out.println(prefix+"yymm : null" );
		}
		System.out.println(prefix+"ser : " + ser);
		if( voice != null ){
			System.out.println(prefix+"voice : ");
			voice.print("	"+prefix);
		}else{
			System.out.println(prefix+"voice : null" );
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
			obj.put("requestObjectName", AppRequestSCRRegisterVoice.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
