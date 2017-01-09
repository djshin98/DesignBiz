package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestVersionCheck;
import com.hd.hse.json.AppResponseVersionCheck;


public class VersionCheck implements com.hd.hse.json.intf.IVersionCheck{
	private static VersionCheck singletonVersionCheck;
	public static VersionCheck getInstance(){
		if( singletonVersionCheck == null ){
			singletonVersionCheck = new VersionCheck();
		}
		return singletonVersionCheck;
	}
	
	//버젼 체크
	public void handle(Widget widget, AppRequestVersionCheck req, AppResponseVersionCheck res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
