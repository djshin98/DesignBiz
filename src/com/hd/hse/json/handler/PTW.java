package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestMSPSearch;
import com.hd.hse.json.AppResponseMSPSearch;
import com.hd.hse.json.AppRequestSupconSearch;
import com.hd.hse.json.AppResponseSupconSearch;


public class PTW implements com.hd.hse.json.intf.IPTW{
	private static PTW singletonPTW;
	public static PTW getInstance(){
		if( singletonPTW == null ){
			singletonPTW = new PTW();
		}
		return singletonPTW;
	}
	
	//명일안전작업계획서 조회
	public void handle(Widget widget, AppRequestMSPSearch req, AppResponseMSPSearch res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//업체 조회
	public void handle(Widget widget, AppRequestSupconSearch req, AppResponseSupconSearch res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
