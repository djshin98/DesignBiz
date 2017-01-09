package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppRequestSCCheckListRegister extends JSONWrapper{
	public static final int ID = 45;
	public static final String NAME = "AppRequestSCCheckListRegister";
	public String		requestKey;	//요청 키
	public String		sitecode;	//현장 코드값
	public String		userid;	//사용자 아이디
	public Timestamp		date;	//작업일시
	public String		work;	//작업
	public ArrayList<AppSCItem>		checklist;	//체크리스트
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppRequestSCCheckListRegister d ){
		this.requestKey = d.requestKey;
		this.sitecode = d.sitecode;
		this.userid = d.userid;
		this.date = d.date;
		this.work = d.work;
		this.checklist = d.checklist;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( requestKey != null ){ obj.put("requestKey",requestKey); }
			else{ obj.put("requestKey",""); }
			if( sitecode != null ){ obj.put("sitecode",sitecode); }
			else{ obj.put("sitecode",""); }
			if( userid != null ){ obj.put("userid",userid); }
			else{ obj.put("userid",""); }
			if( date != null ){ obj.put("date",DATE.toJSON(date) ); }
			else{ obj.put("date",""); }
			if( work != null ){ obj.put("work",work); }
			else{ obj.put("work",""); }
			obj.put("checklist", new JSONArray() );
			if( checklist != null ){
				JSONArray array = obj.getJSONArray("checklist");
				for(int i = 0 ; i < checklist.size() ; i++ ){
					array.put( ((AppSCItem)(checklist.get(i))).encoding() );
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
	public static AppRequestSCCheckListRegister decoding(JSONObject obj) {
		AppRequestSCCheckListRegister wrapper = new AppRequestSCCheckListRegister();
		try {
			if( obj.has("requestKey") ){ wrapper.requestKey = obj.getString("requestKey"); }
			if( obj.has("sitecode") ){ wrapper.sitecode = obj.getString("sitecode"); }
			if( obj.has("userid") ){ wrapper.userid = obj.getString("userid"); }
			if( obj.has("date") ){
				String str = obj.getString("date");
				if( str != null && !str.isEmpty() ){
					wrapper.date = Timestamp.valueOf( str );
				}
			}
			if( obj.has("work") ){ wrapper.work = obj.getString("work"); }
			if( obj.has("checklist") ){
				wrapper.checklist = new ArrayList<AppSCItem>();
				JSONArray array = obj.getJSONArray( "checklist" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.checklist.add( AppSCItem.decoding( array.getJSONObject(i)));
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
		if( sitecode != null ){
			System.out.println(prefix+"sitecode : " + sitecode);
		}else{
			System.out.println(prefix+"sitecode : null" );
		}
		if( userid != null ){
			System.out.println(prefix+"userid : " + userid);
		}else{
			System.out.println(prefix+"userid : null" );
		}
		System.out.println(prefix+"date : " + date);
		if( work != null ){
			System.out.println(prefix+"work : " + work);
		}else{
			System.out.println(prefix+"work : null" );
		}
		System.out.println(prefix+"checklist : ");
		for(int i = 0 ; i < checklist.size() ; i++ ){
			((AppSCItem)checklist.get(i)).print("	"+prefix);
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
			obj.put("requestObjectName", AppRequestSCCheckListRegister.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
