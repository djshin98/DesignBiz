package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppSupplier extends JSONWrapper{
	public static final int ID = 35;
	public static final String NAME = "AppSupplier";
	public String		supcode;	//협력업체 코드
	public String		supname;	//협력업체 명
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppSupplier d ){
		this.supcode = d.supcode;
		this.supname = d.supname;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( supcode != null ){ obj.put("supcode",supcode); }
			else{ obj.put("supcode",""); }
			if( supname != null ){ obj.put("supname",supname); }
			else{ obj.put("supname",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppSupplier decoding(JSONObject obj) {
		AppSupplier wrapper = new AppSupplier();
		try {
			if( obj.has("supcode") ){ wrapper.supcode = obj.getString("supcode"); }
			if( obj.has("supname") ){ wrapper.supname = obj.getString("supname"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( supcode != null ){
			System.out.println(prefix+"supcode : " + supcode);
		}else{
			System.out.println(prefix+"supcode : null" );
		}
		if( supname != null ){
			System.out.println(prefix+"supname : " + supname);
		}else{
			System.out.println(prefix+"supname : null" );
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
			obj.put("requestObjectName", AppSupplier.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
