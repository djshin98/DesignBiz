package com.hd.hse.json.intf;

import java.util.ArrayList;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestAppRootingDetectReport;
import com.hd.hse.json.AppResponseAppRootingDetectReport;


public interface IAppRootingDetection{

	//앱 루팅 탐지
	public void handle( Widget widget, AppRequestAppRootingDetectReport req, AppResponseAppRootingDetectReport res);

	
}
