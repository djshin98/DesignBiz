package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppResponseEmployeeManageDetail extends JSONWrapper{
	public static final int ID = 20;
	public static final String NAME = "AppResponseEmployeeManageDetail";
	public String		requestKey;	//요청 키
	public String		result;	//요청 처리 결과값
	public String		resultMessage;	//처리 오류 상세 메시지
	public Timestamp		workdate;	//시간 정보
	public ArrayList<AppLaborAttendance>		fulltimeWorkers;	//
	public ArrayList<AppLaborAttendance>		shorttermWorkers;	//
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppResponseEmployeeManageDetail d ){
		this.requestKey = d.requestKey;
		this.result = d.result;
		this.resultMessage = d.resultMessage;
		this.workdate = d.workdate;
		this.fulltimeWorkers = d.fulltimeWorkers;
		this.shorttermWorkers = d.shorttermWorkers;
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
			obj.put("fulltimeWorkers", new JSONArray() );
			if( fulltimeWorkers != null ){
				JSONArray array = obj.getJSONArray("fulltimeWorkers");
				for(int i = 0 ; i < fulltimeWorkers.size() ; i++ ){
					array.put( ((AppLaborAttendance)(fulltimeWorkers.get(i))).encoding() );
				}
			}
			obj.put("shorttermWorkers", new JSONArray() );
			if( shorttermWorkers != null ){
				JSONArray array = obj.getJSONArray("shorttermWorkers");
				for(int i = 0 ; i < shorttermWorkers.size() ; i++ ){
					array.put( ((AppLaborAttendance)(shorttermWorkers.get(i))).encoding() );
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
	public static AppResponseEmployeeManageDetail decoding(JSONObject obj) {
		AppResponseEmployeeManageDetail wrapper = new AppResponseEmployeeManageDetail();
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
			if( obj.has("fulltimeWorkers") ){
				wrapper.fulltimeWorkers = new ArrayList<AppLaborAttendance>();
				JSONArray array = obj.getJSONArray( "fulltimeWorkers" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.fulltimeWorkers.add( AppLaborAttendance.decoding( array.getJSONObject(i)));
				}
			} 
			if( obj.has("shorttermWorkers") ){
				wrapper.shorttermWorkers = new ArrayList<AppLaborAttendance>();
				JSONArray array = obj.getJSONArray( "shorttermWorkers" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.shorttermWorkers.add( AppLaborAttendance.decoding( array.getJSONObject(i)));
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
		System.out.println(prefix+"fulltimeWorkers : ");
		for(int i = 0 ; i < fulltimeWorkers.size() ; i++ ){
			((AppLaborAttendance)fulltimeWorkers.get(i)).print("	"+prefix);
		}
		System.out.println(prefix+"shorttermWorkers : ");
		for(int i = 0 ; i < shorttermWorkers.size() ; i++ ){
			((AppLaborAttendance)shorttermWorkers.get(i)).print("	"+prefix);
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
			obj.put("requestObjectName", AppResponseEmployeeManageDetail.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
