package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppConstructMachineInfo extends JSONWrapper{
	public static final int ID = 22;
	public static final String NAME = "AppConstructMachineInfo";
	public String		cod_nam;	//장비명
	public String		size;	//규격
	public String		supname;	//업체명
	public String		carno;	//차량번호
	public String		manageno;	//관리번호
	public Timestamp		insurend;	//보험종료일자
	public Timestamp		licenseend;	//면허종료일자
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppConstructMachineInfo d ){
		this.cod_nam = d.cod_nam;
		this.size = d.size;
		this.supname = d.supname;
		this.carno = d.carno;
		this.manageno = d.manageno;
		this.insurend = d.insurend;
		this.licenseend = d.licenseend;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( cod_nam != null ){ obj.put("cod_nam",cod_nam); }
			else{ obj.put("cod_nam",""); }
			if( size != null ){ obj.put("size",size); }
			else{ obj.put("size",""); }
			if( supname != null ){ obj.put("supname",supname); }
			else{ obj.put("supname",""); }
			if( carno != null ){ obj.put("carno",carno); }
			else{ obj.put("carno",""); }
			if( manageno != null ){ obj.put("manageno",manageno); }
			else{ obj.put("manageno",""); }
			if( insurend != null ){ obj.put("insurend",DATE.toJSON(insurend) ); }
			else{ obj.put("insurend",""); }
			if( licenseend != null ){ obj.put("licenseend",DATE.toJSON(licenseend) ); }
			else{ obj.put("licenseend",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppConstructMachineInfo decoding(JSONObject obj) {
		AppConstructMachineInfo wrapper = new AppConstructMachineInfo();
		try {
			if( obj.has("cod_nam") ){ wrapper.cod_nam = obj.getString("cod_nam"); }
			if( obj.has("size") ){ wrapper.size = obj.getString("size"); }
			if( obj.has("supname") ){ wrapper.supname = obj.getString("supname"); }
			if( obj.has("carno") ){ wrapper.carno = obj.getString("carno"); }
			if( obj.has("manageno") ){ wrapper.manageno = obj.getString("manageno"); }
			if( obj.has("insurend") ){
				String str = obj.getString("insurend");
				if( str != null && !str.isEmpty() ){
					wrapper.insurend = Timestamp.valueOf( str );
				}
			}
			if( obj.has("licenseend") ){
				String str = obj.getString("licenseend");
				if( str != null && !str.isEmpty() ){
					wrapper.licenseend = Timestamp.valueOf( str );
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
		if( cod_nam != null ){
			System.out.println(prefix+"cod_nam : " + cod_nam);
		}else{
			System.out.println(prefix+"cod_nam : null" );
		}
		if( size != null ){
			System.out.println(prefix+"size : " + size);
		}else{
			System.out.println(prefix+"size : null" );
		}
		if( supname != null ){
			System.out.println(prefix+"supname : " + supname);
		}else{
			System.out.println(prefix+"supname : null" );
		}
		if( carno != null ){
			System.out.println(prefix+"carno : " + carno);
		}else{
			System.out.println(prefix+"carno : null" );
		}
		if( manageno != null ){
			System.out.println(prefix+"manageno : " + manageno);
		}else{
			System.out.println(prefix+"manageno : null" );
		}
		System.out.println(prefix+"insurend : " + insurend);
		System.out.println(prefix+"licenseend : " + licenseend);
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
			obj.put("requestObjectName", AppConstructMachineInfo.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
