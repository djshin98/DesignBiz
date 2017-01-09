package com.hd.hse.json;

import java.util.ArrayList;

import java.sql.Timestamp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.itf.framework.util.DATE;
import com.itf.framework.db.JSONWrapper;

public class AppConstructMachineDetailInfo extends JSONWrapper{
	public static final int ID = 25;
	public static final String NAME = "AppConstructMachineDetailInfo";
	public String		lotnam;	//LOT명
	public String		machinename;	//장비명
	public String		size;	//규격
	public String		carno;	//차량번호
	public String		supname;	//업체명
	public String		insurdi;	//대인
	public String		insurdm;	//대물
	public String		insurjs;	//자손
	public String		insurjj;	//차차
	public Timestamp		insurstart;	//보험시작기간
	public Timestamp		insurend;	//보험종료기간
	public Timestamp		indate;	//반입일
	public Timestamp		outdate;	//반출예정일
	public Timestamp		outdate2;	//반출일
	public String		drivername;	//운전자
	public String		licensegubun;	//면허구분
	public String		licenseno;	//면허번호
	public Timestamp		licensestart;	//면허시작일
	public Timestamp		licenseend;	//면허종료일
	public String		language;	//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

	public void copy( AppConstructMachineDetailInfo d ){
		this.lotnam = d.lotnam;
		this.machinename = d.machinename;
		this.size = d.size;
		this.carno = d.carno;
		this.supname = d.supname;
		this.insurdi = d.insurdi;
		this.insurdm = d.insurdm;
		this.insurjs = d.insurjs;
		this.insurjj = d.insurjj;
		this.insurstart = d.insurstart;
		this.insurend = d.insurend;
		this.indate = d.indate;
		this.outdate = d.outdate;
		this.outdate2 = d.outdate2;
		this.drivername = d.drivername;
		this.licensegubun = d.licensegubun;
		this.licenseno = d.licenseno;
		this.licensestart = d.licensestart;
		this.licenseend = d.licenseend;
		this.language = d.language;

	}
	public JSONObject encoding(){
		
		JSONObject obj = new JSONObject();
		try {
			if( lotnam != null ){ obj.put("lotnam",lotnam); }
			else{ obj.put("lotnam",""); }
			if( machinename != null ){ obj.put("machinename",machinename); }
			else{ obj.put("machinename",""); }
			if( size != null ){ obj.put("size",size); }
			else{ obj.put("size",""); }
			if( carno != null ){ obj.put("carno",carno); }
			else{ obj.put("carno",""); }
			if( supname != null ){ obj.put("supname",supname); }
			else{ obj.put("supname",""); }
			if( insurdi != null ){ obj.put("insurdi",insurdi); }
			else{ obj.put("insurdi",""); }
			if( insurdm != null ){ obj.put("insurdm",insurdm); }
			else{ obj.put("insurdm",""); }
			if( insurjs != null ){ obj.put("insurjs",insurjs); }
			else{ obj.put("insurjs",""); }
			if( insurjj != null ){ obj.put("insurjj",insurjj); }
			else{ obj.put("insurjj",""); }
			if( insurstart != null ){ obj.put("insurstart",DATE.toJSON(insurstart) ); }
			else{ obj.put("insurstart",""); }
			if( insurend != null ){ obj.put("insurend",DATE.toJSON(insurend) ); }
			else{ obj.put("insurend",""); }
			if( indate != null ){ obj.put("indate",DATE.toJSON(indate) ); }
			else{ obj.put("indate",""); }
			if( outdate != null ){ obj.put("outdate",DATE.toJSON(outdate) ); }
			else{ obj.put("outdate",""); }
			if( outdate2 != null ){ obj.put("outdate2",DATE.toJSON(outdate2) ); }
			else{ obj.put("outdate2",""); }
			if( drivername != null ){ obj.put("drivername",drivername); }
			else{ obj.put("drivername",""); }
			if( licensegubun != null ){ obj.put("licensegubun",licensegubun); }
			else{ obj.put("licensegubun",""); }
			if( licenseno != null ){ obj.put("licenseno",licenseno); }
			else{ obj.put("licenseno",""); }
			if( licensestart != null ){ obj.put("licensestart",DATE.toJSON(licensestart) ); }
			else{ obj.put("licensestart",""); }
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
	public static AppConstructMachineDetailInfo decoding(JSONObject obj) {
		AppConstructMachineDetailInfo wrapper = new AppConstructMachineDetailInfo();
		try {
			if( obj.has("lotnam") ){ wrapper.lotnam = obj.getString("lotnam"); }
			if( obj.has("machinename") ){ wrapper.machinename = obj.getString("machinename"); }
			if( obj.has("size") ){ wrapper.size = obj.getString("size"); }
			if( obj.has("carno") ){ wrapper.carno = obj.getString("carno"); }
			if( obj.has("supname") ){ wrapper.supname = obj.getString("supname"); }
			if( obj.has("insurdi") ){ wrapper.insurdi = obj.getString("insurdi"); }
			if( obj.has("insurdm") ){ wrapper.insurdm = obj.getString("insurdm"); }
			if( obj.has("insurjs") ){ wrapper.insurjs = obj.getString("insurjs"); }
			if( obj.has("insurjj") ){ wrapper.insurjj = obj.getString("insurjj"); }
			if( obj.has("insurstart") ){
				String str = obj.getString("insurstart");
				if( str != null && !str.isEmpty() ){
					wrapper.insurstart = Timestamp.valueOf( str );
				}
			}
			if( obj.has("insurend") ){
				String str = obj.getString("insurend");
				if( str != null && !str.isEmpty() ){
					wrapper.insurend = Timestamp.valueOf( str );
				}
			}
			if( obj.has("indate") ){
				String str = obj.getString("indate");
				if( str != null && !str.isEmpty() ){
					wrapper.indate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("outdate") ){
				String str = obj.getString("outdate");
				if( str != null && !str.isEmpty() ){
					wrapper.outdate = Timestamp.valueOf( str );
				}
			}
			if( obj.has("outdate2") ){
				String str = obj.getString("outdate2");
				if( str != null && !str.isEmpty() ){
					wrapper.outdate2 = Timestamp.valueOf( str );
				}
			}
			if( obj.has("drivername") ){ wrapper.drivername = obj.getString("drivername"); }
			if( obj.has("licensegubun") ){ wrapper.licensegubun = obj.getString("licensegubun"); }
			if( obj.has("licenseno") ){ wrapper.licenseno = obj.getString("licenseno"); }
			if( obj.has("licensestart") ){
				String str = obj.getString("licensestart");
				if( str != null && !str.isEmpty() ){
					wrapper.licensestart = Timestamp.valueOf( str );
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
		if( lotnam != null ){
			System.out.println(prefix+"lotnam : " + lotnam);
		}else{
			System.out.println(prefix+"lotnam : null" );
		}
		if( machinename != null ){
			System.out.println(prefix+"machinename : " + machinename);
		}else{
			System.out.println(prefix+"machinename : null" );
		}
		if( size != null ){
			System.out.println(prefix+"size : " + size);
		}else{
			System.out.println(prefix+"size : null" );
		}
		if( carno != null ){
			System.out.println(prefix+"carno : " + carno);
		}else{
			System.out.println(prefix+"carno : null" );
		}
		if( supname != null ){
			System.out.println(prefix+"supname : " + supname);
		}else{
			System.out.println(prefix+"supname : null" );
		}
		if( insurdi != null ){
			System.out.println(prefix+"insurdi : " + insurdi);
		}else{
			System.out.println(prefix+"insurdi : null" );
		}
		if( insurdm != null ){
			System.out.println(prefix+"insurdm : " + insurdm);
		}else{
			System.out.println(prefix+"insurdm : null" );
		}
		if( insurjs != null ){
			System.out.println(prefix+"insurjs : " + insurjs);
		}else{
			System.out.println(prefix+"insurjs : null" );
		}
		if( insurjj != null ){
			System.out.println(prefix+"insurjj : " + insurjj);
		}else{
			System.out.println(prefix+"insurjj : null" );
		}
		System.out.println(prefix+"insurstart : " + insurstart);
		System.out.println(prefix+"insurend : " + insurend);
		System.out.println(prefix+"indate : " + indate);
		System.out.println(prefix+"outdate : " + outdate);
		System.out.println(prefix+"outdate2 : " + outdate2);
		if( drivername != null ){
			System.out.println(prefix+"drivername : " + drivername);
		}else{
			System.out.println(prefix+"drivername : null" );
		}
		if( licensegubun != null ){
			System.out.println(prefix+"licensegubun : " + licensegubun);
		}else{
			System.out.println(prefix+"licensegubun : null" );
		}
		if( licenseno != null ){
			System.out.println(prefix+"licenseno : " + licenseno);
		}else{
			System.out.println(prefix+"licenseno : null" );
		}
		System.out.println(prefix+"licensestart : " + licensestart);
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
			obj.put("requestObjectName", AppConstructMachineDetailInfo.NAME);
			obj.put("requestObject", encoding() );
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
