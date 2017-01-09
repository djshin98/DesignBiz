package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRiskReport extends JSONWrapper{
	public static final int ID = 31;
	public static final String NAME = "AppRiskReport";
	public String		workCode;	//작업코드
	public String		riskFactor;	//위험요인
	public ArrayList<AppRiskFactor>		riskFactors;	//위험 요인 목록
	public String		riskReductionMeasure;	//위험저감대책
	public ArrayList<AppRiskFactor>		riskReductionMeasures;	//위험 저감대책 목록
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRiskReport d ){
		this.workCode = d.workCode;
		this.riskFactor = d.riskFactor;
		this.riskFactors = d.riskFactors;
		this.riskReductionMeasure = d.riskReductionMeasure;
		this.riskReductionMeasures = d.riskReductionMeasures;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( workCode != null ){ obj.put("workCode",workCode); }
			else{ obj.put("workCode",""); }
			if( riskFactor != null ){ obj.put("riskFactor",riskFactor); }
			else{ obj.put("riskFactor",""); }
			obj.put("riskFactors", new JSONArray() );
			if( riskFactors != null ){
				JSONArray array = obj.getJSONArray("riskFactors");
				for(int i = 0 ; i < riskFactors.size() ; i++ ){
					array.put( ((AppRiskFactor)(riskFactors.get(i))).encoding() );
				}
			}
			if( riskReductionMeasure != null ){ obj.put("riskReductionMeasure",riskReductionMeasure); }
			else{ obj.put("riskReductionMeasure",""); }
			obj.put("riskReductionMeasures", new JSONArray() );
			if( riskReductionMeasures != null ){
				JSONArray array = obj.getJSONArray("riskReductionMeasures");
				for(int i = 0 ; i < riskReductionMeasures.size() ; i++ ){
					array.put( ((AppRiskFactor)(riskReductionMeasures.get(i))).encoding() );
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
	public static AppRiskReport decoding(JSONObject obj) {
		AppRiskReport wrapper = new AppRiskReport();
		try {
			if( obj.has("workCode") ){ wrapper.workCode = obj.getString("workCode"); }
			if( obj.has("riskFactor") ){ wrapper.riskFactor = obj.getString("riskFactor"); }
			if( obj.has("riskFactors") ){
				wrapper.riskFactors = new ArrayList<AppRiskFactor>();
				JSONArray array = obj.getJSONArray( "riskFactors" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.riskFactors.add( AppRiskFactor.decoding( array.getJSONObject(i)));
				}
			} 
			if( obj.has("riskReductionMeasure") ){ wrapper.riskReductionMeasure = obj.getString("riskReductionMeasure"); }
			if( obj.has("riskReductionMeasures") ){
				wrapper.riskReductionMeasures = new ArrayList<AppRiskFactor>();
				JSONArray array = obj.getJSONArray( "riskReductionMeasures" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.riskReductionMeasures.add( AppRiskFactor.decoding( array.getJSONObject(i)));
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
		if( workCode != null ){
			System.out.println(prefix+"workCode : " + workCode);
		}else{
			System.out.println(prefix+"workCode : null" );
		}
		if( riskFactor != null ){
			System.out.println(prefix+"riskFactor : " + riskFactor);
		}else{
			System.out.println(prefix+"riskFactor : null" );
		}
		System.out.println(prefix+"riskFactors : ");
		for(int i = 0 ; i < riskFactors.size() ; i++ ){
			((AppRiskFactor)riskFactors.get(i)).print("	"+prefix);
		}
		if( riskReductionMeasure != null ){
			System.out.println(prefix+"riskReductionMeasure : " + riskReductionMeasure);
		}else{
			System.out.println(prefix+"riskReductionMeasure : null" );
		}
		System.out.println(prefix+"riskReductionMeasures : ");
		for(int i = 0 ; i < riskReductionMeasures.size() ; i++ ){
			((AppRiskFactor)riskReductionMeasures.get(i)).print("	"+prefix);
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
			obj.put("requestObjectName", AppRiskReport.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
