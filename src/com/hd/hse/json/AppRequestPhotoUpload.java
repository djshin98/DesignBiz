package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRequestPhotoUpload extends JSONWrapper{
	public static final int ID = 12;
	public static final String NAME = "AppRequestPhotoUpload";
	public String		requestKey;	//요청 키
	public byte[]		photo;	//사진 파일 데이터
	public String		name;	//사진 파일
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRequestPhotoUpload d ){
		this.requestKey = d.requestKey;
		this.photo = d.photo;
		this.name = d.name;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( requestKey != null ){ obj.put("requestKey",requestKey); }
			else{ obj.put("requestKey",""); }
			if (photo != null) {
				obj.put("photo", Base64.encodeBase64(photo));
			} else {
				obj.put("photo", "");
			}
			if( name != null ){ obj.put("name",name); }
			else{ obj.put("name",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppRequestPhotoUpload decoding(JSONObject obj) {
		AppRequestPhotoUpload wrapper = new AppRequestPhotoUpload();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if (obj.has("photo")) {
				String temp = obj.getString("photo");
				if( temp.length() > 0 ){
					wrapper.photo = Base64.decodeBase64(temp.getBytes());
				}
			}
			if( obj.has("name") ){ wrapper.name = obj.getString("name"); }
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
		if( photo != null ){
			System.out.println(prefix+"photo : (size="+photo.length+" bytes)" + "...");
		}else{
			System.out.println(prefix+"photo : null" );
		}
		if( name != null ){
			System.out.println(prefix+"name : " + name);
		}else{
			System.out.println(prefix+"name : null" );
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
			obj.put("requestObjectName", AppRequestPhotoUpload.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
