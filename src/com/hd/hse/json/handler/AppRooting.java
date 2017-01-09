package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestAppInitialize;
import com.hd.hse.json.AppResponseAppInitialize;


public class AppRooting implements com.hd.hse.json.intf.IAppRooting{
	private static AppRooting singletonAppRooting;
	public static AppRooting getInstance(){
		if( singletonAppRooting == null ){
			singletonAppRooting = new AppRooting();
		}
		return singletonAppRooting;
	}
	
	//앱 루팅 탐지 정보 조회
	public void handle(Widget widget, AppRequestAppInitialize req, AppResponseAppInitialize res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
