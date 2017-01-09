package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppSCItem extends JSONWrapper{
	public static final int ID = 37;
	public static final String NAME = "AppSCItem";
	public String		checkitem;	//체크 항목
	public String		gubun;	//구분
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppSCItem d ){
		this.checkitem = d.checkitem;
		this.gubun = d.gubun;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( checkitem != null ){ obj.put("checkitem",checkitem); }
			else{ obj.put("checkitem",""); }
			if( gubun != null ){ obj.put("gubun",gubun); }
			else{ obj.put("gubun",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppSCItem decoding(JSONObject obj) {
		AppSCItem wrapper = new AppSCItem();
		try {
			if( obj.has("checkitem") ){ wrapper.checkitem = obj.getString("checkitem"); }
			if( obj.has("gubun") ){ wrapper.gubun = obj.getString("gubun"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( checkitem != null ){
			System.out.println(prefix+"checkitem : " + checkitem);
		}else{
			System.out.println(prefix+"checkitem : null" );
		}
		if( gubun != null ){
			System.out.println(prefix+"gubun : " + gubun);
		}else{
			System.out.println(prefix+"gubun : null" );
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
			obj.put("requestObjectName", AppSCItem.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
