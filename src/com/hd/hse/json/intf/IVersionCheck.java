package com.hd.hse.json.intf;

import java.util.ArrayList;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestVersionCheck;
import com.hd.hse.json.AppResponseVersionCheck;


public interface IVersionCheck{

	//버젼 체크
	public void handle( Widget widget, AppRequestVersionCheck req, AppResponseVersionCheck res);

	
}
