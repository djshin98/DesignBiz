package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestSCGongjongList;
import com.hd.hse.json.AppResponseSCGongjongList;
import com.hd.hse.json.AppRequestSCWorkList;
import com.hd.hse.json.AppResponseSCWorkList;
import com.hd.hse.json.AppRequestSCCheckList;
import com.hd.hse.json.AppResponseSCCheckList;
import com.hd.hse.json.AppRequestSCCheckListRegister;
import com.hd.hse.json.AppResponseSCCheckListRegister;
import com.hd.hse.json.AppRequestSCCheckListUpdate;
import com.hd.hse.json.AppResponseSCCheckListUpdate;
import com.hd.hse.json.AppRequestSCCheckWriteList;
import com.hd.hse.json.AppResponseSCCheckWriteList;
import com.hd.hse.json.AppRequestSCCheckListDelete;
import com.hd.hse.json.AppResponseSCCheckListDelete;


public class SafetyCheck implements com.hd.hse.json.intf.ISafetyCheck{
	private static SafetyCheck singletonSafetyCheck;
	public static SafetyCheck getInstance(){
		if( singletonSafetyCheck == null ){
			singletonSafetyCheck = new SafetyCheck();
		}
		return singletonSafetyCheck;
	}
	
	//안전점검체크리스트 작업공종조회
	public void handle(Widget widget, AppRequestSCGongjongList req, AppResponseSCGongjongList res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//안전점검체크리스트 작업활동조회
	public void handle(Widget widget, AppRequestSCWorkList req, AppResponseSCWorkList res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//안전점검체크리스트 항목조회
	public void handle(Widget widget, AppRequestSCCheckList req, AppResponseSCCheckList res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//안전점검체크리스트 데이터 저장
	public void handle(Widget widget, AppRequestSCCheckListRegister req, AppResponseSCCheckListRegister res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//안전점검체크리스트 데이터 수정
	public void handle(Widget widget, AppRequestSCCheckListUpdate req, AppResponseSCCheckListUpdate res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//안전점검체크리스트 작성리스트 조회
	public void handle(Widget widget, AppRequestSCCheckWriteList req, AppResponseSCCheckWriteList res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//안전점검체크리스트 작성리스트 삭제
	public void handle(Widget widget, AppRequestSCCheckListDelete req, AppResponseSCCheckListDelete res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
