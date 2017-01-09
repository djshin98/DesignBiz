package com.hd.hse.json.intf;

import java.util.ArrayList;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestLogin;
import com.hd.hse.json.AppResponseLogin;
import com.hd.hse.json.AppRequestLoginDevice;
import com.hd.hse.json.AppRequestLoginOption;


public interface ILogin{

	//로그인
	public void handle( Widget widget, AppRequestLogin req, AppResponseLogin res);
	//기기 인증
	public void handle( Widget widget, AppRequestLoginDevice req, AppResponseLogin res);
	//부가인증
	public void handle( Widget widget, AppRequestLoginOption req, AppResponseLogin res);

	
}
