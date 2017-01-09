package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppNCRDetail extends JSONWrapper{
	public static final int ID = 55;
	public static final String NAME = "AppNCRDetail";
	public String		sitecode;	//현장코드
	public String		userid;	//작성자
	public String		sitename;	//현장명
	public String		yymm;	//작성일자
	public int		ser;	//작성NO
	public Timestamp		issueDate;	//작성일자
	public String		title;	//문서제목
	public String		recvDept;	//수신부서
	public String		publishDept;	//발행부서
	public String		contents;	//문서내용
	public String		rules;	//관련규정 - 추가
	public ArrayList<AppPhoto>		photos;	//첨부파일 목록
	public AppVoice		voice;	//음성 녹음
	public String		posx;	//위치경도
	public String		posy;	//위치위도
	public String		subcon;	//협력업체결재자
	public String		subconnm;	//협력업체결재자
	public String		subconpho;	//협력업체연락처
	public Timestamp		subcondate;	//협력업체확인시간 -추가
	public String		gonggujang;	//공구장결재자
	public String		gonggujangnm;	//공구장결재자
	public String		gonggujangpho;	//공구장연락처
	public Timestamp		gonggujangdate;	//공구장확인시간 -추가
	public String		sojang;	//소장결재자
	public String		sojangnm;	//소장결재자
	public String		sojangpho;	//소장연락처
	public Timestamp		sojangdate;	//소장확인시간 -추가
	public boolean		sms;	//SMS전송여부
	public Timestamp		ins_dt;	//작성시간 -추가
	public String		writer;	//작성자
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppNCRDetail d ){
		this.sitecode = d.sitecode;
		this.userid = d.userid;
		this.sitename = d.sitename;
		this.yymm = d.yymm;
		this.ser = d.ser;
		this.issueDate = d.issueDate;
		this.title = d.title;
		this.recvDept = d.recvDept;
		this.publishDept = d.publishDept;
		this.contents = d.contents;
		this.rules = d.rules;
		this.photos = d.photos;
		this.voice = d.voice;
		this.posx = d.posx;
		this.posy = d.posy;
		this.subcon = d.subcon;
		this.subconnm = d.subconnm;
		this.subconpho = d.subconpho;
		this.subcondate = d.subcondate;
		this.gonggujang = d.gonggujang;
		this.gonggujangnm = d.gonggujangnm;
		this.gonggujangpho = d.gonggujangpho;
		this.gonggujangdate = d.gonggujangdate;
		this.sojang = d.sojang;
		this.sojangnm = d.sojangnm;
		this.sojangpho = d.sojangpho;
		this.sojangdate = d.sojangdate;
		this.sms = d.sms;
		this.ins_dt = d.ins_dt;
		this.writer = d.writer;
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
			if( recvDept != null ){ obj.put("recvDept",recvDept); }
			else{ obj.put("recvDept",""); }
			if( publishDept != null ){ obj.put("publishDept",publishDept); }
			else{ obj.put("publishDept",""); }
			if( contents != null ){ obj.put("contents",contents); }
			else{ obj.put("contents",""); }
			if( rules != null ){ obj.put("rules",rules); }
			else{ obj.put("rules",""); }
			obj.put("photos", new JSONArray() );
			if( photos != null ){
				JSONArray array = obj.getJSONArray("photos");
				for(int i = 0 ; i < photos.size() ; i++ ){
					array.put( ((AppPhoto)(photos.get(i))).encoding() );
				}
			}
			if( voice != null ){ obj.put("voice",voice.encoding() ); }
			if( posx != null ){ obj.put("posx",posx); }
			else{ obj.put("posx",""); }
			if( posy != null ){ obj.put("posy",posy); }
			else{ obj.put("posy",""); }
			if( subcon != null ){ obj.put("subcon",subcon); }
			else{ obj.put("subcon",""); }
			if( subconnm != null ){ obj.put("subconnm",subconnm); }
			else{ obj.put("subconnm",""); }
			if( subconpho != null ){ obj.put("subconpho",subconpho); }
			else{ obj.put("subconpho",""); }
			if( subcondate != null ){ obj.put("subcondate",DATE.toJSON(subcondate) ); }
			else{ obj.put("subcondate",""); }
			if( gonggujang != null ){ obj.put("gonggujang",gonggujang); }
			else{ obj.put("gonggujang",""); }
			if( gonggujangnm != null ){ obj.put("gonggujangnm",gonggujangnm); }
			else{ obj.put("gonggujangnm",""); }
			if( gonggujangpho != null ){ obj.put("gonggujangpho",gonggujangpho); }
			else{ obj.put("gonggujangpho",""); }
			if( gonggujangdate != null ){ obj.put("gonggujangdate",DATE.toJSON(gonggujangdate) ); }
			else{ obj.put("gonggujangdate",""); }
			if( sojang != null ){ obj.put("sojang",sojang); }
			else{ obj.put("sojang",""); }
			if( sojangnm != null ){ obj.put("sojangnm",sojangnm); }
			else{ obj.put("sojangnm",""); }
			if( sojangpho != null ){ obj.put("sojangpho",sojangpho); }
			else{ obj.put("sojangpho",""); }
			if( sojangdate != null ){ obj.put("sojangdate",DATE.toJSON(sojangdate) ); }
			else{ obj.put("sojangdate",""); }
			obj.put("sms",sms);
			if( ins_dt != null ){ obj.put("ins_dt",DATE.toJSON(ins_dt) ); }
			else{ obj.put("ins_dt",""); }
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
	public static AppNCRDetail decoding(JSONObject obj) {
		AppNCRDetail wrapper = new AppNCRDetail();
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
			if( obj.has("recvDept") ){ wrapper.recvDept = obj.getString("recvDept"); }
			if( obj.has("publishDept") ){ wrapper.publishDept = obj.getString("publishDept"); }
			if( obj.has("contents") ){ wrapper.contents = obj.getString("contents"); }
			if( obj.has("rules") ){ wrapper.rules = obj.getString("rules"); }
			if( obj.has("photos") ){
				wrapper.photos = new ArrayList<AppPhoto>();
				JSONArray array = obj.getJSONArray( "photos" );
				for( int i = 0 ; i < array.length() ; i++ ){
					wrapper.photos.add( AppPhoto.decoding( array.getJSONObject(i)));
				}
			} 
			if( obj.has("voice") ){ wrapper.voice = (AppVoice) AppVoice.decoding( obj.getJSONObject("voice") ); }
			if( obj.has("posx") ){ wrapper.posx = obj.getString("posx"); }
			if( obj.has("posy") ){ wrapper.posy = obj.getString("posy"); }
			if( obj.has("subcon") ){ wrapper.subcon = obj.getString("subcon"); }
			if( obj.has("subconnm") ){ wrapper.subconnm = obj.getString("subconnm"); }
			if( obj.has("subconpho") ){ wrapper.subconpho = obj.getString("subconpho"); }
			if( obj.has("subcondate") ){
				String str = obj.getString("subcondate");
				if( str != null && !str.isEmpty() ){
					wrapper.subcondate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("gonggujang") ){ wrapper.gonggujang = obj.getString("gonggujang"); }
			if( obj.has("gonggujangnm") ){ wrapper.gonggujangnm = obj.getString("gonggujangnm"); }
			if( obj.has("gonggujangpho") ){ wrapper.gonggujangpho = obj.getString("gonggujangpho"); }
			if( obj.has("gonggujangdate") ){
				String str = obj.getString("gonggujangdate");
				if( str != null && !str.isEmpty() ){
					wrapper.gonggujangdate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("sojang") ){ wrapper.sojang = obj.getString("sojang"); }
			if( obj.has("sojangnm") ){ wrapper.sojangnm = obj.getString("sojangnm"); }
			if( obj.has("sojangpho") ){ wrapper.sojangpho = obj.getString("sojangpho"); }
			if( obj.has("sojangdate") ){
				String str = obj.getString("sojangdate");
				if( str != null && !str.isEmpty() ){
					wrapper.sojangdate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("sms") ){ wrapper.sms = obj.getBoolean("sms"); }
			if( obj.has("ins_dt") ){
				String str = obj.getString("ins_dt");
				if( str != null && !str.isEmpty() ){
					wrapper.ins_dt = Timestamp.valueOf( str );
				}
			}
			if( obj.has("writer") ){ wrapper.writer = obj.getString("writer"); }
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
		System.out.println(prefix+"photos : ");
		for(int i = 0 ; i < photos.size() ; i++ ){
			((AppPhoto)photos.get(i)).print("	"+prefix);
		}
		if( voice != null ){
			System.out.println(prefix+"voice : ");
			voice.print("	"+prefix);
		}else{
			System.out.println(prefix+"voice : null" );
		}
		if( posx != null ){
			System.out.println(prefix+"posx : " + posx);
		}else{
			System.out.println(prefix+"posx : null" );
		}
		if( posy != null ){
			System.out.println(prefix+"posy : " + posy);
		}else{
			System.out.println(prefix+"posy : null" );
		}
		if( subcon != null ){
			System.out.println(prefix+"subcon : " + subcon);
		}else{
			System.out.println(prefix+"subcon : null" );
		}
		if( subconnm != null ){
			System.out.println(prefix+"subconnm : " + subconnm);
		}else{
			System.out.println(prefix+"subconnm : null" );
		}
		if( subconpho != null ){
			System.out.println(prefix+"subconpho : " + subconpho);
		}else{
			System.out.println(prefix+"subconpho : null" );
		}
		System.out.println(prefix+"subcondate : " + subcondate);
		if( gonggujang != null ){
			System.out.println(prefix+"gonggujang : " + gonggujang);
		}else{
			System.out.println(prefix+"gonggujang : null" );
		}
		if( gonggujangnm != null ){
			System.out.println(prefix+"gonggujangnm : " + gonggujangnm);
		}else{
			System.out.println(prefix+"gonggujangnm : null" );
		}
		if( gonggujangpho != null ){
			System.out.println(prefix+"gonggujangpho : " + gonggujangpho);
		}else{
			System.out.println(prefix+"gonggujangpho : null" );
		}
		System.out.println(prefix+"gonggujangdate : " + gonggujangdate);
		if( sojang != null ){
			System.out.println(prefix+"sojang : " + sojang);
		}else{
			System.out.println(prefix+"sojang : null" );
		}
		if( sojangnm != null ){
			System.out.println(prefix+"sojangnm : " + sojangnm);
		}else{
			System.out.println(prefix+"sojangnm : null" );
		}
		if( sojangpho != null ){
			System.out.println(prefix+"sojangpho : " + sojangpho);
		}else{
			System.out.println(prefix+"sojangpho : null" );
		}
		System.out.println(prefix+"sojangdate : " + sojangdate);
		System.out.println(prefix+"sms : " + sms);
		System.out.println(prefix+"ins_dt : " + ins_dt);
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
			obj.put("requestObjectName", AppNCRDetail.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
