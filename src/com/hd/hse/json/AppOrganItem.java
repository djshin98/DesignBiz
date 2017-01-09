package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppOrganItem extends JSONWrapper{
	public static final int ID = 65;
	public static final String NAME = "AppOrganItem";
	public String		gubun;	//소속부서1
	public String		buso;	//소속부서2
	public String		lotnam;	//사용자
	public String		usridn;	//사번
	public String		usrnam;	//이름
	public String		usrlem;	//직위
	public String		usrpho;	//휴대전화번호
	public String		supcde;	//사업자등록번호
	public String		upmcde;	//직책코드
	public String		upmnam;	//직책명
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppOrganItem d ){
		this.gubun = d.gubun;
		this.buso = d.buso;
		this.lotnam = d.lotnam;
		this.usridn = d.usridn;
		this.usrnam = d.usrnam;
		this.usrlem = d.usrlem;
		this.usrpho = d.usrpho;
		this.supcde = d.supcde;
		this.upmcde = d.upmcde;
		this.upmnam = d.upmnam;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( gubun != null ){ obj.put("gubun",gubun); }
			else{ obj.put("gubun",""); }
			if( buso != null ){ obj.put("buso",buso); }
			else{ obj.put("buso",""); }
			if( lotnam != null ){ obj.put("lotnam",lotnam); }
			else{ obj.put("lotnam",""); }
			if( usridn != null ){ obj.put("usridn",usridn); }
			else{ obj.put("usridn",""); }
			if( usrnam != null ){ obj.put("usrnam",usrnam); }
			else{ obj.put("usrnam",""); }
			if( usrlem != null ){ obj.put("usrlem",usrlem); }
			else{ obj.put("usrlem",""); }
			if( usrpho != null ){ obj.put("usrpho",usrpho); }
			else{ obj.put("usrpho",""); }
			if( supcde != null ){ obj.put("supcde",supcde); }
			else{ obj.put("supcde",""); }
			if( upmcde != null ){ obj.put("upmcde",upmcde); }
			else{ obj.put("upmcde",""); }
			if( upmnam != null ){ obj.put("upmnam",upmnam); }
			else{ obj.put("upmnam",""); }
			if( language != null ){ obj.put("language",language); }
			else{ obj.put("language",""); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public static AppOrganItem decoding(JSONObject obj) {
		AppOrganItem wrapper = new AppOrganItem();
		try {
			if( obj.has("gubun") ){ wrapper.gubun = obj.getString("gubun"); }
			if( obj.has("buso") ){ wrapper.buso = obj.getString("buso"); }
			if( obj.has("lotnam") ){ wrapper.lotnam = obj.getString("lotnam"); }
			if( obj.has("usridn") ){ wrapper.usridn = obj.getString("usridn"); }
			if( obj.has("usrnam") ){ wrapper.usrnam = obj.getString("usrnam"); }
			if( obj.has("usrlem") ){ wrapper.usrlem = obj.getString("usrlem"); }
			if( obj.has("usrpho") ){ wrapper.usrpho = obj.getString("usrpho"); }
			if( obj.has("supcde") ){ wrapper.supcde = obj.getString("supcde"); }
			if( obj.has("upmcde") ){ wrapper.upmcde = obj.getString("upmcde"); }
			if( obj.has("upmnam") ){ wrapper.upmnam = obj.getString("upmnam"); }
			if( obj.has("language") ){ wrapper.language = obj.getString("language"); }

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper;
	}
	public void print(String prefix){
		System.out.println(prefix+NAME+"{");
		if( gubun != null ){
			System.out.println(prefix+"gubun : " + gubun);
		}else{
			System.out.println(prefix+"gubun : null" );
		}
		if( buso != null ){
			System.out.println(prefix+"buso : " + buso);
		}else{
			System.out.println(prefix+"buso : null" );
		}
		if( lotnam != null ){
			System.out.println(prefix+"lotnam : " + lotnam);
		}else{
			System.out.println(prefix+"lotnam : null" );
		}
		if( usridn != null ){
			System.out.println(prefix+"usridn : " + usridn);
		}else{
			System.out.println(prefix+"usridn : null" );
		}
		if( usrnam != null ){
			System.out.println(prefix+"usrnam : " + usrnam);
		}else{
			System.out.println(prefix+"usrnam : null" );
		}
		if( usrlem != null ){
			System.out.println(prefix+"usrlem : " + usrlem);
		}else{
			System.out.println(prefix+"usrlem : null" );
		}
		if( usrpho != null ){
			System.out.println(prefix+"usrpho : " + usrpho);
		}else{
			System.out.println(prefix+"usrpho : null" );
		}
		if( supcde != null ){
			System.out.println(prefix+"supcde : " + supcde);
		}else{
			System.out.println(prefix+"supcde : null" );
		}
		if( upmcde != null ){
			System.out.println(prefix+"upmcde : " + upmcde);
		}else{
			System.out.println(prefix+"upmcde : null" );
		}
		if( upmnam != null ){
			System.out.println(prefix+"upmnam : " + upmnam);
		}else{
			System.out.println(prefix+"upmnam : null" );
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
			obj.put("requestObjectName", AppOrganItem.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
