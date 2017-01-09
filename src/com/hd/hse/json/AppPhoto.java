package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppPhoto extends JSONWrapper{
	public static final int ID = 53;
	public static final String NAME = "AppPhoto";
	public byte[]		data;	//사진
	public String		dataType;	//사진파일타입
	public String		fileName;	//사진파일명
	public double		lat;	//위치경도
	public double		lon;	//위치위도
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppPhoto d ){
		this.data = d.data;
		this.dataType = d.dataType;
		this.fileName = d.fileName;
		this.lat = d.lat;
		this.lon = d.lon;
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
			obj.put("lat",lat);
			obj.put("lon",lon);
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppPhoto decoding(JSONObject obj) {
		AppPhoto wrapper = new AppPhoto();
		try {
			if (obj.has("data")) {
				String temp = obj.getString("data");
				if( temp.length() > 0 ){
					wrapper.data = Base64.decodeBase64(temp.getBytes());
				}
			}
			if( obj.has("dataType") ){ wrapper.dataType = obj.getString("dataType"); }
			if( obj.has("fileName") ){ wrapper.fileName = obj.getString("fileName"); }
			if( obj.has("lat") ){ wrapper.lat = obj.getDouble("lat"); }
			if( obj.has("lon") ){ wrapper.lon = obj.getDouble("lon"); }
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
		System.out.println(prefix+"lat : " + lat);
		System.out.println(prefix+"lon : " + lon);
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
			obj.put("requestObjectName", AppPhoto.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
