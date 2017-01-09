package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestLogin;
import com.hd.hse.json.AppResponseLogin;
import com.hd.hse.json.AppRequestLoginDevice;
import com.hd.hse.json.AppRequestLoginOption;


public class Login implements com.hd.hse.json.intf.ILogin{
	private static Login singletonLogin;
	public static Login getInstance(){
		if( singletonLogin == null ){
			singletonLogin = new Login();
		}
		return singletonLogin;
	}
	
	//로그인
	public void handle(Widget widget, AppRequestLogin req, AppResponseLogin res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//기기 인증
	public void handle(Widget widget, AppRequestLoginDevice req, AppResponseLogin res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//부가인증
	public void handle(Widget widget, AppRequestLoginOption req, AppResponseLogin res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
