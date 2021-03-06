package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppResponseConstructMachineDetail extends JSONWrapper{
	public static final int ID = 26;
	public static final String NAME = "AppResponseConstructMachineDetail";
	public String		requestKey;	//요청 키
	public String		result;	//요청 처리 결과값
	public String		resultMessage;	//처리 오류 상세 메시지
	public Timestamp		checkDate;	//요청 확인일
	public ArrayList<AppConstructMachineDetailInfo>		constructMachineInfos;	//건설장비 상세 정보값 리스트
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppResponseConstructMachineDetail d ){
		this.requestKey = d.requestKey;
		this.result = d.result;
		this.resultMessage = d.resultMessage;
		this.checkDate = d.checkDate;
		this.constructMachineInfos = d.constructMachineInfos;
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
			if( checkDate != null ){ obj.put("checkDate",DATE.toJSON(checkDate) ); }
			else{ obj.put("checkDate",""); }
			obj.put("constructMachineInfos", new JSONArray() );
			if( constructMachineInfos != null ){
				JSONArray array = obj.getJSONArray("constructMachineInfos");
				for(int i = 0 ; i < constructMachineInfos.size() ; i++ ){
					array.put( ((AppConstructMachineDetailInfo)(constructMachineInfos.get(i))).encoding() );
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
	public static AppResponseConstructMachineDetail decoding(JSONObject obj) {
		AppResponseConstructMachineDetail wrapper = new AppResponseConstructMachineDetail();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("result") ){ wrapper.result = obj.getString("result"); }
			if( obj.has("resultMessage") ){ wrapper.resultMessage = obj.getString("resultMessage"); }
			if( obj.has("checkDate") ){
				String str = obj.getString("checkDate");
				if( str != null && !str.isEmpty() ){
					wrapper.checkDate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("constructMachineInfos") ){
				wrapper.constructMachineInfos = new ArrayList<AppConstructMachineDetailInfo>();
				JSONArray array = obj.getJSONArray( "constructMachineInfos" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.constructMachineInfos.add( AppConstructMachineDetailInfo.decoding( array.getJSONObject(i)));
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
		System.out.println(prefix+"checkDate : " + checkDate);
		System.out.println(prefix+"constructMachineInfos : ");
		for(int i = 0 ; i < constructMachineInfos.size() ; i++ ){
			((AppConstructMachineDetailInfo)constructMachineInfos.get(i)).print("	"+prefix);
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
			obj.put("requestObjectName", AppResponseConstructMachineDetail.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
