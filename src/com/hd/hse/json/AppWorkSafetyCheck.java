package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppWorkSafetyCheck extends JSONWrapper{
	public static final int ID = 43;
	public static final String NAME = "AppWorkSafetyCheck";
	public String		workCode;	//공종코드
	public String		workType;	//공종명
	public String		workName;	//작업명
	public boolean		check;	//체크여부
	public Timestamp		uptdt;	//최근수정날짜
	public String		insid;	//작성자사번
	public String		writer;	//작성자
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppWorkSafetyCheck d ){
		this.workCode = d.workCode;
		this.workType = d.workType;
		this.workName = d.workName;
		this.check = d.check;
		this.uptdt = d.uptdt;
		this.insid = d.insid;
		this.writer = d.writer;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( workCode != null ){ obj.put("workCode",workCode); }
			else{ obj.put("workCode",""); }
			if( workType != null ){ obj.put("workType",workType); }
			else{ obj.put("workType",""); }
			if( workName != null ){ obj.put("workName",workName); }
			else{ obj.put("workName",""); }
			obj.put("check",check);
			if( uptdt != null ){ obj.put("uptdt",DATE.toJSON(uptdt) ); }
			else{ obj.put("uptdt",""); }
			if( insid != null ){ obj.put("insid",insid); }
			else{ obj.put("insid",""); }
			if( writer != null ){ obj.put("writer",writer); }
			else{ obj.put("writer",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppWorkSafetyCheck decoding(JSONObject obj) {
		AppWorkSafetyCheck wrapper = new AppWorkSafetyCheck();
		try {
			if( obj.has("workCode") ){ wrapper.workCode = obj.getString("workCode"); }
			if( obj.has("workType") ){ wrapper.workType = obj.getString("workType"); }
			if( obj.has("workName") ){ wrapper.workName = obj.getString("workName"); }
			if( obj.has("check") ){ wrapper.check = obj.getBoolean("check"); }
			if( obj.has("uptdt") ){
				String str = obj.getString("uptdt");
				if( str != null && !str.isEmpty() ){
					wrapper.uptdt = Timestamp.valueOf( str );
				}
			}
			if( obj.has("insid") ){ wrapper.insid = obj.getString("insid"); }
			if( obj.has("writer") ){ wrapper.writer = obj.getString("writer"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( workCode != null ){
			System.out.println(prefix+"workCode : " + workCode);
		}else{
			System.out.println(prefix+"workCode : null" );
		}
		if( workType != null ){
			System.out.println(prefix+"workType : " + workType);
		}else{
			System.out.println(prefix+"workType : null" );
		}
		if( workName != null ){
			System.out.println(prefix+"workName : " + workName);
		}else{
			System.out.println(prefix+"workName : null" );
		}
		System.out.println(prefix+"check : " + check);
		System.out.println(prefix+"uptdt : " + uptdt);
		if( insid != null ){
			System.out.println(prefix+"insid : " + insid);
		}else{
			System.out.println(prefix+"insid : null" );
		}
		if( writer != null ){
			System.out.println(prefix+"writer : " + writer);
		}else{
			System.out.println(prefix+"writer : null" );
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
			obj.put("requestObjectName", AppWorkSafetyCheck.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
