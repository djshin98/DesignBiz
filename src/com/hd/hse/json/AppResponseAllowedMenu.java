package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppResponseAllowedMenu extends JSONWrapper{
	public static final int ID = 2;
	public static final String NAME = "AppResponseAllowedMenu";
	public String		requestKey;	//요청 키
	public String		result;	//요청 처리 결과값
	public String		resultMessage;	//처리 오류 상세 메시지
	public ArrayList<String>		allowedMenus;	//접근 메뉴 코드 목록 정보
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppResponseAllowedMenu d ){
		this.requestKey = d.requestKey;
		this.result = d.result;
		this.resultMessage = d.resultMessage;
		this.allowedMenus = d.allowedMenus;
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
			obj.put("allowedMenus", new JSONArray() );
			if( allowedMenus != null ){
				JSONArray array = obj.getJSONArray("allowedMenus");
				for(int i = 0 ; i < allowedMenus.size() ; i++ ){
					array.put( ((String)(allowedMenus.get(i))) );
				}
			}
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppResponseAllowedMenu decoding(JSONObject obj) {
		AppResponseAllowedMenu wrapper = new AppResponseAllowedMenu();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("result") ){ wrapper.result = obj.getString("result"); }
			if( obj.has("resultMessage") ){ wrapper.resultMessage = obj.getString("resultMessage"); }
			if( obj.has("allowedMenus") ){
				wrapper.allowedMenus = new ArrayList<String>();
				JSONArray array = obj.getJSONArray( "allowedMenus" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.allowedMenus.add( (String)array.getString(i) );
				}
			} 
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
		System.out.println(prefix+"allowedMenus : ");
		for(int i = 0 ; i < allowedMenus.size() ; i++ ){
			System.out.println("	"+prefix+allowedMenus.get(i));
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
			obj.put("requestObjectName", AppResponseAllowedMenu.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
