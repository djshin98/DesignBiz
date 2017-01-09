package com.hd.hse.json.intf;

import java.util.ArrayList;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestAppInitialize;
import com.hd.hse.json.AppResponseAppInitialize;


public interface IAppRooting{

	//앱 루팅 탐지 정보 조회
	public void handle( Widget widget, AppRequestAppInitialize req, AppResponseAppInitialize res);

	
}
