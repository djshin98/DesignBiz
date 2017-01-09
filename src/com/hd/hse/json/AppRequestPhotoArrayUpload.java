package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRequestPhotoArrayUpload extends JSONWrapper{
	public static final int ID = 14;
	public static final String NAME = "AppRequestPhotoArrayUpload";
	public String		requestKey;	//요청 키
	public ArrayList<byte[]>		photos;	//
	public ArrayList<String>		names;	//
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRequestPhotoArrayUpload d ){
		this.requestKey = d.requestKey;
		this.photos = d.photos;
		this.names = d.names;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( requestKey != null ){ obj.put("requestKey",requestKey); }
			else{ obj.put("requestKey",""); }
			obj.put("photos", new JSONArray() );
			if( photos != null ){
				JSONArray array = obj.getJSONArray("photos");
				for(int i = 0 ; i < photos.size() ; i++ ){
					array.put( new String( Base64.encodeBase64(photos.get(i)) ) );
				}
			}
			obj.put("names", new JSONArray() );
			if( names != null ){
				JSONArray array = obj.getJSONArray("names");
				for(int i = 0 ; i < names.size() ; i++ ){
					array.put( ((String)(names.get(i))) );
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
	public static AppRequestPhotoArrayUpload decoding(JSONObject obj) {
		AppRequestPhotoArrayUpload wrapper = new AppRequestPhotoArrayUpload();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("photos") ){
				wrapper.photos = new ArrayList<byte[]>();
				JSONArray array = obj.getJSONArray( "photos" );
				for( int i = 0 ; i < array.length() ; i++ ){
					byte[] temp = Base64.decodeBase64(array.getString(i).getBytes());
					wrapper.photos.add( temp );
				}
			} 
			if( obj.has("names") ){
				wrapper.names = new ArrayList<String>();
				JSONArray array = obj.getJSONArray( "names" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.names.add( (String)array.getString(i) );
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
		System.out.println(prefix+"photos : ");
		for(int i = 0 ; i < photos.size() ; i++ ){
			System.out.println("	"+prefix+photos.get(i));
		}
		System.out.println(prefix+"names : ");
		for(int i = 0 ; i < names.size() ; i++ ){
			System.out.println("	"+prefix+names.get(i));
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
			obj.put("requestObjectName", AppRequestPhotoArrayUpload.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
