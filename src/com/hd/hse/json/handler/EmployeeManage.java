package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestEmployeeManageList;
import com.hd.hse.json.AppResponseEmployeeManageList;
import com.hd.hse.json.AppRequestEmployeeManageDetail;
import com.hd.hse.json.AppResponseEmployeeManageDetail;


public class EmployeeManage implements com.hd.hse.json.intf.IEmployeeManage{
	private static EmployeeManage singletonEmployeeManage;
	public static EmployeeManage getInstance(){
		if( singletonEmployeeManage == null ){
			singletonEmployeeManage = new EmployeeManage();
		}
		return singletonEmployeeManage;
	}
	
	//현장 출역현황 조회
	public void handle(Widget widget, AppRequestEmployeeManageList req, AppResponseEmployeeManageList res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//협력업체 출역현황 상세데이터 조회
	public void handle(Widget widget, AppRequestEmployeeManageDetail req, AppResponseEmployeeManageDetail res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
