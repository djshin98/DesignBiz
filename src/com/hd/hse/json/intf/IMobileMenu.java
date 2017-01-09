package com.hd.hse.json.intf;

import java.util.ArrayList;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestAllowedMenu;
import com.hd.hse.json.AppResponseAllowedMenu;


public interface IMobileMenu{

	//메뉴 권한 조회
	public void handle( Widget widget, AppRequestAllowedMenu req, AppResponseAllowedMenu res);

	
}
