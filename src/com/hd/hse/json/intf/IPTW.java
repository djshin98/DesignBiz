package com.hd.hse.json.intf;

import java.util.ArrayList;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestMSPSearch;
import com.hd.hse.json.AppResponseMSPSearch;
import com.hd.hse.json.AppRequestSupconSearch;
import com.hd.hse.json.AppResponseSupconSearch;


public interface IPTW{

	//명일안전작업계획서 조회
	public void handle( Widget widget, AppRequestMSPSearch req, AppResponseMSPSearch res);
	//업체 조회
	public void handle( Widget widget, AppRequestSupconSearch req, AppResponseSupconSearch res);

	
}
