package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestTD_Insert;
import com.hd.hse.json.AppResponseTD_Insert;
import com.hd.hse.json.AppRequestTD_Update;
import com.hd.hse.json.AppResponseTD_Update;
import com.hd.hse.json.AppRequestTD_Delete;
import com.hd.hse.json.AppResponseTD_Delete;
import com.hd.hse.json.AppRequestTD_ListSearch;
import com.hd.hse.json.AppResponseTD_ListSearch;
import com.hd.hse.json.AppRequestTD_DetailSearch;
import com.hd.hse.json.AppResponseTD_DetailSearch;
import com.hd.hse.json.AppRequestTD_SignfileUpload;
import com.hd.hse.json.AppResponseTD_SignfileUpload;


public class Training implements com.hd.hse.json.intf.ITraining{
	private static Training singletonTraining;
	public static Training getInstance(){
		if( singletonTraining == null ){
			singletonTraining = new Training();
		}
		return singletonTraining;
	}
	
	//교육훈련일지 저장 후 결과리턴
	public void handle(Widget widget, AppRequestTD_Insert req, AppResponseTD_Insert res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//교육훈련일지 수정
	public void handle(Widget widget, AppRequestTD_Update req, AppResponseTD_Update res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//교육훈련일지 삭제
	public void handle(Widget widget, AppRequestTD_Delete req, AppResponseTD_Delete res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//교육훈련일지 리스트 조회
	public void handle(Widget widget, AppRequestTD_ListSearch req, AppResponseTD_ListSearch res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//교육훈련일지 상세 조회
	public void handle(Widget widget, AppRequestTD_DetailSearch req, AppResponseTD_DetailSearch res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//교육훈련 서명파일_업로드
	public void handle(Widget widget, AppRequestTD_SignfileUpload req, AppResponseTD_SignfileUpload res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
