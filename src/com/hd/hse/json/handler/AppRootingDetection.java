package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestAppRootingDetectReport;
import com.hd.hse.json.AppResponseAppRootingDetectReport;


public class AppRootingDetection implements com.hd.hse.json.intf.IAppRootingDetection{
	private static AppRootingDetection singletonAppRootingDetection;
	public static AppRootingDetection getInstance(){
		if( singletonAppRootingDetection == null ){
			singletonAppRootingDetection = new AppRootingDetection();
		}
		return singletonAppRootingDetection;
	}
	
	//앱 루팅 탐지
	public void handle(Widget widget, AppRequestAppRootingDetectReport req, AppResponseAppRootingDetectReport res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
