package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppEducation extends JSONWrapper{
	public static final int ID = 92;
	public static final String NAME = "AppEducation";
	public int		ser;	//NO
	public String		name;	//교육명
	public Timestamp		date;	//교육일자
	public String		gubun;	//교육구분
	public Timestamp		start;	//교육시작시간
	public Timestamp		end;	//교육종료시간
	public String		place;	//현장 교육장소
	public String		speaker;	//강사
	public String		method;	//교육방법
	public String		content;	//교육내용
	public byte[]		sign;	//서명
	public String		userid;	//작성자사번
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppEducation d ){
		this.ser = d.ser;
		this.name = d.name;
		this.date = d.date;
		this.gubun = d.gubun;
		this.start = d.start;
		this.end = d.end;
		this.place = d.place;
		this.speaker = d.speaker;
		this.method = d.method;
		this.content = d.content;
		this.sign = d.sign;
		this.userid = d.userid;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("ser",ser);
			if( name != null ){ obj.put("name",name); }
			else{ obj.put("name",""); }
			if( date != null ){ obj.put("date",DATE.toJSON(date) ); }
			else{ obj.put("date",""); }
			if( gubun != null ){ obj.put("gubun",gubun); }
			else{ obj.put("gubun",""); }
			if( start != null ){ obj.put("start",DATE.toJSON(start) ); }
			else{ obj.put("start",""); }
			if( end != null ){ obj.put("end",DATE.toJSON(end) ); }
			else{ obj.put("end",""); }
			if( place != null ){ obj.put("place",place); }
			else{ obj.put("place",""); }
			if( speaker != null ){ obj.put("speaker",speaker); }
			else{ obj.put("speaker",""); }
			if( method != null ){ obj.put("method",method); }
			else{ obj.put("method",""); }
			if( content != null ){ obj.put("content",content); }
			else{ obj.put("content",""); }
			if (sign != null) {
				obj.put("sign", Base64.encodeBase64(sign));
			} else {
				obj.put("sign", "");
			}
			if( userid != null ){ obj.put("userid",userid); }
			else{ obj.put("userid",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppEducation decoding(JSONObject obj) {
		AppEducation wrapper = new AppEducation();
		try {
			if( obj.has("ser") ){ wrapper.ser = obj.getInt("ser"); }
			if( obj.has("name") ){ wrapper.name = obj.getString("name"); }
			if( obj.has("date") ){
				String str = obj.getString("date");
				if( str != null && !str.isEmpty() ){
					wrapper.date = Timestamp.valueOf( str );
				}
			}
			if( obj.has("gubun") ){ wrapper.gubun = obj.getString("gubun"); }
			if( obj.has("start") ){
				String str = obj.getString("start");
				if( str != null && !str.isEmpty() ){
					wrapper.start = Timestamp.valueOf( str );
				}
			}
			if( obj.has("end") ){
				String str = obj.getString("end");
				if( str != null && !str.isEmpty() ){
					wrapper.end = Timestamp.valueOf( str );
				}
			}
			if( obj.has("place") ){ wrapper.place = obj.getString("place"); }
			if( obj.has("speaker") ){ wrapper.speaker = obj.getString("speaker"); }
			if( obj.has("method") ){ wrapper.method = obj.getString("method"); }
			if( obj.has("content") ){ wrapper.content = obj.getString("content"); }
			if (obj.has("sign")) {
				String temp = obj.getString("sign");
				if( temp.length() > 0 ){
					wrapper.sign = Base64.decodeBase64(temp.getBytes());
				}
			}
			if( obj.has("userid") ){ wrapper.userid = obj.getString("userid"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		System.out.println(prefix+"ser : " + ser);
		if( name != null ){
			System.out.println(prefix+"name : " + name);
		}else{
			System.out.println(prefix+"name : null" );
		}
		System.out.println(prefix+"date : " + date);
		if( gubun != null ){
			System.out.println(prefix+"gubun : " + gubun);
		}else{
			System.out.println(prefix+"gubun : null" );
		}
		System.out.println(prefix+"start : " + start);
		System.out.println(prefix+"end : " + end);
		if( place != null ){
			System.out.println(prefix+"place : " + place);
		}else{
			System.out.println(prefix+"place : null" );
		}
		if( speaker != null ){
			System.out.println(prefix+"speaker : " + speaker);
		}else{
			System.out.println(prefix+"speaker : null" );
		}
		if( method != null ){
			System.out.println(prefix+"method : " + method);
		}else{
			System.out.println(prefix+"method : null" );
		}
		if( content != null ){
			System.out.println(prefix+"content : " + content);
		}else{
			System.out.println(prefix+"content : null" );
		}
		if( sign != null ){
			System.out.println(prefix+"sign : (size="+sign.length+" bytes)" + "...");
		}else{
			System.out.println(prefix+"sign : null" );
		}
		if( userid != null ){
			System.out.println(prefix+"userid : " + userid);
		}else{
			System.out.println(prefix+"userid : null" );
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
			obj.put("requestObjectName", AppEducation.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
