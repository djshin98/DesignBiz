package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRootingCheckTarget extends JSONWrapper{
	public static final int ID = 4;
	public static final String NAME = "AppRootingCheckTarget";
	public String		target;	//루팅 감지 PATH , FILE 명
	public String		minVersion;	//적용 가능한 최소 버젼
	public String		maxVersion;	//적용 가능한 최대 버젼
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRootingCheckTarget d ){
		this.target = d.target;
		this.minVersion = d.minVersion;
		this.maxVersion = d.maxVersion;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( target != null ){ obj.put("target",target); }
			else{ obj.put("target",""); }
			if( minVersion != null ){ obj.put("minVersion",minVersion); }
			else{ obj.put("minVersion",""); }
			if( maxVersion != null ){ obj.put("maxVersion",maxVersion); }
			else{ obj.put("maxVersion",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppRootingCheckTarget decoding(JSONObject obj) {
		AppRootingCheckTarget wrapper = new AppRootingCheckTarget();
		try {
			if( obj.has("target") ){ wrapper.target = obj.getString("target"); }
			if( obj.has("minVersion") ){ wrapper.minVersion = obj.getString("minVersion"); }
			if( obj.has("maxVersion") ){ wrapper.maxVersion = obj.getString("maxVersion"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( target != null ){
			System.out.println(prefix+"target : " + target);
		}else{
			System.out.println(prefix+"target : null" );
		}
		if( minVersion != null ){
			System.out.println(prefix+"minVersion : " + minVersion);
		}else{
			System.out.println(prefix+"minVersion : null" );
		}
		if( maxVersion != null ){
			System.out.println(prefix+"maxVersion : " + maxVersion);
		}else{
			System.out.println(prefix+"maxVersion : null" );
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
			obj.put("requestObjectName", AppRootingCheckTarget.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
