package com.hd.hse.json.intf;

import java.util.ArrayList;
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


public interface ITraining{

	//교육훈련일지 저장 후 결과리턴
	public void handle( Widget widget, AppRequestTD_Insert req, AppResponseTD_Insert res);
	//교육훈련일지 수정
	public void handle( Widget widget, AppRequestTD_Update req, AppResponseTD_Update res);
	//교육훈련일지 삭제
	public void handle( Widget widget, AppRequestTD_Delete req, AppResponseTD_Delete res);
	//교육훈련일지 리스트 조회
	public void handle( Widget widget, AppRequestTD_ListSearch req, AppResponseTD_ListSearch res);
	//교육훈련일지 상세 조회
	public void handle( Widget widget, AppRequestTD_DetailSearch req, AppResponseTD_DetailSearch res);
	//교육훈련 서명파일_업로드
	public void handle( Widget widget, AppRequestTD_SignfileUpload req, AppResponseTD_SignfileUpload res);

	
}
