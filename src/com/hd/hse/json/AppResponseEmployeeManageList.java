package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppResponseEmployeeManageList extends JSONWrapper{
	public static final int ID = 17;
	public static final String NAME = "AppResponseEmployeeManageList";
	public String		requestKey;	//요청 키
	public String		result;	//요청 처리 결과값
	public String		resultMessage;	//처리 오류 상세 메시지
	public Timestamp		workdate;	//시간 정보
	public ArrayList<AppSupplierAttendance>		records;	//협력사 출근 상황 목록
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppResponseEmployeeManageList d ){
		this.requestKey = d.requestKey;
		this.result = d.result;
		this.resultMessage = d.resultMessage;
		this.workdate = d.workdate;
		this.records = d.records;
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
			if( workdate != null ){ obj.put("workdate",DATE.toJSON(workdate) ); }
			else{ obj.put("workdate",""); }
			obj.put("records", new JSONArray() );
			if( records != null ){
				JSONArray array = obj.getJSONArray("records");
				for(int i = 0 ; i < records.size() ; i++ ){
					array.put( ((AppSupplierAttendance)(records.get(i))).encoding() );
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
	public static AppResponseEmployeeManageList decoding(JSONObject obj) {
		AppResponseEmployeeManageList wrapper = new AppResponseEmployeeManageList();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("result") ){ wrapper.result = obj.getString("result"); }
			if( obj.has("resultMessage") ){ wrapper.resultMessage = obj.getString("resultMessage"); }
			if( obj.has("workdate") ){
				String str = obj.getString("workdate");
				if( str != null && !str.isEmpty() ){
					wrapper.workdate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("records") ){
				wrapper.records = new ArrayList<AppSupplierAttendance>();
				JSONArray array = obj.getJSONArray( "records" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.records.add( AppSupplierAttendance.decoding( array.getJSONObject(i)));
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
		System.out.println(prefix+"workdate : " + workdate);
		System.out.println(prefix+"records : ");
		for(int i = 0 ; i < records.size() ; i++ ){
			((AppSupplierAttendance)records.get(i)).print("	"+prefix);
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
			obj.put("requestObjectName", AppResponseEmployeeManageList.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
