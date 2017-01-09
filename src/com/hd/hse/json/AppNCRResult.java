package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppNCRResult extends JSONWrapper{
	public static final int ID = 85;
	public static final String NAME = "AppNCRResult";
	public String		sitecode;	//현장코드
	public String		sitename;	//현장명
	public String		writer;	//작성자
	public String		writernm;	//작성자
	public Timestamp		issuedate;	//작성일자
	public String		title;	//문서제목
	public String		recvDept;	//수신부서
	public String		publishDept;	//발행부서
	public String		contents;	//문서내용
	public String		rules;	//관련규정 - 추가
	public Timestamp		writedate;	//작성일자
	public ArrayList<AppPhoto>		photos;	//사진
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppNCRResult d ){
		this.sitecode = d.sitecode;
		this.sitename = d.sitename;
		this.writer = d.writer;
		this.writernm = d.writernm;
		this.issuedate = d.issuedate;
		this.title = d.title;
		this.recvDept = d.recvDept;
		this.publishDept = d.publishDept;
		this.contents = d.contents;
		this.rules = d.rules;
		this.writedate = d.writedate;
		this.photos = d.photos;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( sitecode != null ){ obj.put("sitecode",sitecode); }
			else{ obj.put("sitecode",""); }
			if( sitename != null ){ obj.put("sitename",sitename); }
			else{ obj.put("sitename",""); }
			if( writer != null ){ obj.put("writer",writer); }
			else{ obj.put("writer",""); }
			if( writernm != null ){ obj.put("writernm",writernm); }
			else{ obj.put("writernm",""); }
			if( issuedate != null ){ obj.put("issuedate",DATE.toJSON(issuedate) ); }
			else{ obj.put("issuedate",""); }
			if( title != null ){ obj.put("title",title); }
			else{ obj.put("title",""); }
			if( recvDept != null ){ obj.put("recvDept",recvDept); }
			else{ obj.put("recvDept",""); }
			if( publishDept != null ){ obj.put("publishDept",publishDept); }
			else{ obj.put("publishDept",""); }
			if( contents != null ){ obj.put("contents",contents); }
			else{ obj.put("contents",""); }
			if( rules != null ){ obj.put("rules",rules); }
			else{ obj.put("rules",""); }
			if( writedate != null ){ obj.put("writedate",DATE.toJSON(writedate) ); }
			else{ obj.put("writedate",""); }
			obj.put("photos", new JSONArray() );
			if( photos != null ){
				JSONArray array = obj.getJSONArray("photos");
				for(int i = 0 ; i < photos.size() ; i++ ){
					array.put( ((AppPhoto)(photos.get(i))).encoding() );
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
	public static AppNCRResult decoding(JSONObject obj) {
		AppNCRResult wrapper = new AppNCRResult();
		try {
			if( obj.has("sitecode") ){ wrapper.sitecode = obj.getString("sitecode"); }
			if( obj.has("sitename") ){ wrapper.sitename = obj.getString("sitename"); }
			if( obj.has("writer") ){ wrapper.writer = obj.getString("writer"); }
			if( obj.has("writernm") ){ wrapper.writernm = obj.getString("writernm"); }
			if( obj.has("issuedate") ){
				String str = obj.getString("issuedate");
				if( str != null && !str.isEmpty() ){
					wrapper.issuedate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("title") ){ wrapper.title = obj.getString("title"); }
			if( obj.has("recvDept") ){ wrapper.recvDept = obj.getString("recvDept"); }
			if( obj.has("publishDept") ){ wrapper.publishDept = obj.getString("publishDept"); }
			if( obj.has("contents") ){ wrapper.contents = obj.getString("contents"); }
			if( obj.has("rules") ){ wrapper.rules = obj.getString("rules"); }
			if( obj.has("writedate") ){
				String str = obj.getString("writedate");
				if( str != null && !str.isEmpty() ){
					wrapper.writedate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("photos") ){
				wrapper.photos = new ArrayList<AppPhoto>();
				JSONArray array = obj.getJSONArray( "photos" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.photos.add( AppPhoto.decoding( array.getJSONObject(i)));
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
		if( sitecode != null ){
			System.out.println(prefix+"sitecode : " + sitecode);
		}else{
			System.out.println(prefix+"sitecode : null" );
		}
		if( sitename != null ){
			System.out.println(prefix+"sitename : " + sitename);
		}else{
			System.out.println(prefix+"sitename : null" );
		}
		if( writer != null ){
			System.out.println(prefix+"writer : " + writer);
		}else{
			System.out.println(prefix+"writer : null" );
		}
		if( writernm != null ){
			System.out.println(prefix+"writernm : " + writernm);
		}else{
			System.out.println(prefix+"writernm : null" );
		}
		System.out.println(prefix+"issuedate : " + issuedate);
		if( title != null ){
			System.out.println(prefix+"title : " + title);
		}else{
			System.out.println(prefix+"title : null" );
		}
		if( recvDept != null ){
			System.out.println(prefix+"recvDept : " + recvDept);
		}else{
			System.out.println(prefix+"recvDept : null" );
		}
		if( publishDept != null ){
			System.out.println(prefix+"publishDept : " + publishDept);
		}else{
			System.out.println(prefix+"publishDept : null" );
		}
		if( contents != null ){
			System.out.println(prefix+"contents : " + contents);
		}else{
			System.out.println(prefix+"contents : null" );
		}
		if( rules != null ){
			System.out.println(prefix+"rules : " + rules);
		}else{
			System.out.println(prefix+"rules : null" );
		}
		System.out.println(prefix+"writedate : " + writedate);
		System.out.println(prefix+"photos : ");
		for(int i = 0 ; i < photos.size() ; i++ ){
			((AppPhoto)photos.get(i)).print("	"+prefix);
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
			obj.put("requestObjectName", AppNCRResult.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
