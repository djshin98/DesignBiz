package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppVoice extends JSONWrapper{
	public static final int ID = 54;
	public static final String NAME = "AppVoice";
	public byte[]		data;	//음성
	public String		dataType;	//음성파일타입
	public String		fileName;	//음성파일명
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppVoice d ){
		this.data = d.data;
		this.dataType = d.dataType;
		this.fileName = d.fileName;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if (data != null) {
				obj.put("data", Base64.encodeBase64(data));
			} else {
				obj.put("data", "");
			}
			if( dataType != null ){ obj.put("dataType",dataType); }
			else{ obj.put("dataType",""); }
			if( fileName != null ){ obj.put("fileName",fileName); }
			else{ obj.put("fileName",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppVoice decoding(JSONObject obj) {
		AppVoice wrapper = new AppVoice();
		try {
			if (obj.has("data")) {
				String temp = obj.getString("data");
				if( temp.length() > 0 ){
					wrapper.data = Base64.decodeBase64(temp.getBytes());
				}
			}
			if( obj.has("dataType") ){ wrapper.dataType = obj.getString("dataType"); }
			if( obj.has("fileName") ){ wrapper.fileName = obj.getString("fileName"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( data != null ){
			System.out.println(prefix+"data : (size="+data.length+" bytes)" + "...");
		}else{
			System.out.println(prefix+"data : null" );
		}
		if( dataType != null ){
			System.out.println(prefix+"dataType : " + dataType);
		}else{
			System.out.println(prefix+"dataType : null" );
		}
		if( fileName != null ){
			System.out.println(prefix+"fileName : " + fileName);
		}else{
			System.out.println(prefix+"fileName : null" );
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
			obj.put("requestObjectName", AppVoice.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
