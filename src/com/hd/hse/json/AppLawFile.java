package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppLawFile extends JSONWrapper{
	public static final int ID = 28;
	public static final String NAME = "AppLawFile";
	public String		mencde;	//파일메뉴코드
	public String		mennam;	//파일명
	public String		menfile;	//파일url
	public String		filePath;	//파일url
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppLawFile d ){
		this.mencde = d.mencde;
		this.mennam = d.mennam;
		this.menfile = d.menfile;
		this.filePath = d.filePath;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( mencde != null ){ obj.put("mencde",mencde); }
			else{ obj.put("mencde",""); }
			if( mennam != null ){ obj.put("mennam",mennam); }
			else{ obj.put("mennam",""); }
			if( menfile != null ){ obj.put("menfile",menfile); }
			else{ obj.put("menfile",""); }
			if( filePath != null ){ obj.put("filePath",filePath); }
			else{ obj.put("filePath",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppLawFile decoding(JSONObject obj) {
		AppLawFile wrapper = new AppLawFile();
		try {
			if( obj.has("mencde") ){ wrapper.mencde = obj.getString("mencde"); }
			if( obj.has("mennam") ){ wrapper.mennam = obj.getString("mennam"); }
			if( obj.has("menfile") ){ wrapper.menfile = obj.getString("menfile"); }
			if( obj.has("filePath") ){ wrapper.filePath = obj.getString("filePath"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( mencde != null ){
			System.out.println(prefix+"mencde : " + mencde);
		}else{
			System.out.println(prefix+"mencde : null" );
		}
		if( mennam != null ){
			System.out.println(prefix+"mennam : " + mennam);
		}else{
			System.out.println(prefix+"mennam : null" );
		}
		if( menfile != null ){
			System.out.println(prefix+"menfile : " + menfile);
		}else{
			System.out.println(prefix+"menfile : null" );
		}
		if( filePath != null ){
			System.out.println(prefix+"filePath : " + filePath);
		}else{
			System.out.println(prefix+"filePath : null" );
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
			obj.put("requestObjectName", AppLawFile.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
