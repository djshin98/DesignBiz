package com.hd.hse.json.intf;

import java.util.ArrayList;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestEmployeeManageList;
import com.hd.hse.json.AppResponseEmployeeManageList;
import com.hd.hse.json.AppRequestEmployeeManageDetail;
import com.hd.hse.json.AppResponseEmployeeManageDetail;


public interface IEmployeeManage{

	//현장 출역현황 조회
	public void handle( Widget widget, AppRequestEmployeeManageList req, AppResponseEmployeeManageList res);
	//협력업체 출역현황 상세데이터 조회
	public void handle( Widget widget, AppRequestEmployeeManageDetail req, AppResponseEmployeeManageDetail res);

	
}
