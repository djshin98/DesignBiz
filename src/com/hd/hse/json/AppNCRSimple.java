package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppNCRSimple extends JSONWrapper{
	public static final int ID = 56;
	public static final String NAME = "AppNCRSimple";
	public String		sitecode;	//현장코드
	public String		userid;	//작성자
	public String		sitename;	//현장명
	public String		yymm;	//작성일자
	public int		ser;	//작성NO
	public Timestamp		issueDate;	//부적합보고서 발행일
	public String		title;	//문서제목
	public String		supplierName;	//협력업체명
	public String		insid;	//작성자사번
	public String		writer;	//작성자
	public boolean		SMS;	//SMS발송여부(True/False) True인 경우는 수정 불가, False인 경우 수정 가능
	public int		STATUS;	//수신상태(0:문자미발송작성중, 1: 발송완료, 2: 수신문서)
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppNCRSimple d ){
		this.sitecode = d.sitecode;
		this.userid = d.userid;
		this.sitename = d.sitename;
		this.yymm = d.yymm;
		this.ser = d.ser;
		this.issueDate = d.issueDate;
		this.title = d.title;
		this.supplierName = d.supplierName;
		this.insid = d.insid;
		this.writer = d.writer;
		this.SMS = d.SMS;
		this.STATUS = d.STATUS;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( sitecode != null ){ obj.put("sitecode",sitecode); }
			else{ obj.put("sitecode",""); }
			if( userid != null ){ obj.put("userid",userid); }
			else{ obj.put("userid",""); }
			if( sitename != null ){ obj.put("sitename",sitename); }
			else{ obj.put("sitename",""); }
			if( yymm != null ){ obj.put("yymm",yymm); }
			else{ obj.put("yymm",""); }
			obj.put("ser",ser);
			if( issueDate != null ){ obj.put("issueDate",DATE.toJSON(issueDate) ); }
			else{ obj.put("issueDate",""); }
			if( title != null ){ obj.put("title",title); }
			else{ obj.put("title",""); }
			if( supplierName != null ){ obj.put("supplierName",supplierName); }
			else{ obj.put("supplierName",""); }
			if( insid != null ){ obj.put("insid",insid); }
			else{ obj.put("insid",""); }
			if( writer != null ){ obj.put("writer",writer); }
			else{ obj.put("writer",""); }
			obj.put("SMS",SMS);
			obj.put("STATUS",STATUS);
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppNCRSimple decoding(JSONObject obj) {
		AppNCRSimple wrapper = new AppNCRSimple();
		try {
			if( obj.has("sitecode") ){ wrapper.sitecode = obj.getString("sitecode"); }
			if( obj.has("userid") ){ wrapper.userid = obj.getString("userid"); }
			if( obj.has("sitename") ){ wrapper.sitename = obj.getString("sitename"); }
			if( obj.has("yymm") ){ wrapper.yymm = obj.getString("yymm"); }
			if( obj.has("ser") ){ wrapper.ser = obj.getInt("ser"); }
			if( obj.has("issueDate") ){
				String str = obj.getString("issueDate");
				if( str != null && !str.isEmpty() ){
					wrapper.issueDate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("title") ){ wrapper.title = obj.getString("title"); }
			if( obj.has("supplierName") ){ wrapper.supplierName = obj.getString("supplierName"); }
			if( obj.has("insid") ){ wrapper.insid = obj.getString("insid"); }
			if( obj.has("writer") ){ wrapper.writer = obj.getString("writer"); }
			if( obj.has("SMS") ){ wrapper.SMS = obj.getBoolean("SMS"); }
			if( obj.has("STATUS") ){ wrapper.STATUS = obj.getInt("STATUS"); }
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
		if( userid != null ){
			System.out.println(prefix+"userid : " + userid);
		}else{
			System.out.println(prefix+"userid : null" );
		}
		if( sitename != null ){
			System.out.println(prefix+"sitename : " + sitename);
		}else{
			System.out.println(prefix+"sitename : null" );
		}
		if( yymm != null ){
			System.out.println(prefix+"yymm : " + yymm);
		}else{
			System.out.println(prefix+"yymm : null" );
		}
		System.out.println(prefix+"ser : " + ser);
		System.out.println(prefix+"issueDate : " + issueDate);
		if( title != null ){
			System.out.println(prefix+"title : " + title);
		}else{
			System.out.println(prefix+"title : null" );
		}
		if( supplierName != null ){
			System.out.println(prefix+"supplierName : " + supplierName);
		}else{
			System.out.println(prefix+"supplierName : null" );
		}
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
		System.out.println(prefix+"SMS : " + SMS);
		System.out.println(prefix+"STATUS : " + STATUS);
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
			obj.put("requestObjectName", AppNCRSimple.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
