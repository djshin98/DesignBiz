package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestAllowedMenu;
import com.hd.hse.json.AppResponseAllowedMenu;


public class MobileMenu implements com.hd.hse.json.intf.IMobileMenu{
	private static MobileMenu singletonMobileMenu;
	public static MobileMenu getInstance(){
		if( singletonMobileMenu == null ){
			singletonMobileMenu = new MobileMenu();
		}
		return singletonMobileMenu;
	}
	
	//메뉴 권한 조회
	public void handle(Widget widget, AppRequestAllowedMenu req, AppResponseAllowedMenu res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
