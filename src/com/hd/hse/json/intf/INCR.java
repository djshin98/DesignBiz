package com.hd.hse.json.intf;

import java.util.ArrayList;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestSCRList;
import com.hd.hse.json.AppResponseSCRList;
import com.hd.hse.json.AppRequestSCRReceiveDeptList;
import com.hd.hse.json.AppResponseSCRReceiveDeptList;
import com.hd.hse.json.AppRequestSCRIssueDeptList;
import com.hd.hse.json.AppResponseSCRIssueDeptList;
import com.hd.hse.json.AppRequestSCREmployeeList;
import com.hd.hse.json.AppResponseSCREmployeeList;
import com.hd.hse.json.AppRequestSCRView;
import com.hd.hse.json.AppResponseSCRView;
import com.hd.hse.json.AppRequestSCRRegister;
import com.hd.hse.json.AppResponseSCRRegister;
import com.hd.hse.json.AppRequestSCREdit;
import com.hd.hse.json.AppResponseSCREdit;
import com.hd.hse.json.AppRequestSCRSendSMS;
import com.hd.hse.json.AppResponseSCRSendSMS;
import com.hd.hse.json.AppRequestSCRDelete;
import com.hd.hse.json.AppResponseSCRDelete;
import com.hd.hse.json.AppRequestSCRRegisterImage;
import com.hd.hse.json.AppResponseSCRRegisterImage;
import com.hd.hse.json.AppRequestSCRRegisterVoice;
import com.hd.hse.json.AppResponseSCRRegisterVoice;
import com.hd.hse.json.AppRequestSCRRegisterJochi;
import com.hd.hse.json.AppResponseSCRRegisterJochi;
import com.hd.hse.json.AppRequestSCRRegisterImageJochi;
import com.hd.hse.json.AppResponseSCRRegisterImageJochi;
import com.hd.hse.json.AppRequestSCRViewJochi;
import com.hd.hse.json.AppResponseSCRViewJochi;
import com.hd.hse.json.AppRequestSCRDeleteJochi;
import com.hd.hse.json.AppResponseSCRDeleteJochi;
import com.hd.hse.json.AppRequestSCRDeleteJochiContents;
import com.hd.hse.json.AppResponseSCRDeleteJochiContents;


public interface INCR{

	//부적합 보고서 리스트 조회 후 결과리턴
	public void handle( Widget widget, AppRequestSCRList req, AppResponseSCRList res);
	//부적합보고서 수신부서 
	public void handle( Widget widget, AppRequestSCRReceiveDeptList req, AppResponseSCRReceiveDeptList res);
	//부적합보고서 발행부서 
	public void handle( Widget widget, AppRequestSCRIssueDeptList req, AppResponseSCRIssueDeptList res);
	//직원 조직도 조회
	public void handle( Widget widget, AppRequestSCREmployeeList req, AppResponseSCREmployeeList res);
	//상세데이터 조회
	public void handle( Widget widget, AppRequestSCRView req, AppResponseSCRView res);
	//부적합 보고서 리스트 저장 후 결과리턴
	public void handle( Widget widget, AppRequestSCRRegister req, AppResponseSCRRegister res);
	//부적합 보고서 리스트 업데이트 후 결과리턴
	public void handle( Widget widget, AppRequestSCREdit req, AppResponseSCREdit res);
	//부적합보고서 문자전송
	public void handle( Widget widget, AppRequestSCRSendSMS req, AppResponseSCRSendSMS res);
	//부적합보고서 삭제
	public void handle( Widget widget, AppRequestSCRDelete req, AppResponseSCRDelete res);
	//부적합 보고서 이미지 저장 후 결과리턴
	public void handle( Widget widget, AppRequestSCRRegisterImage req, AppResponseSCRRegisterImage res);
	//부적합 보고서 음성 저장 후 결과리턴
	public void handle( Widget widget, AppRequestSCRRegisterVoice req, AppResponseSCRRegisterVoice res);
	//부적합 보고서 조치결과 저장
	public void handle( Widget widget, AppRequestSCRRegisterJochi req, AppResponseSCRRegisterJochi res);
	//부적합 보고서 조치 후 이미지 저장 후 결과리턴
	public void handle( Widget widget, AppRequestSCRRegisterImageJochi req, AppResponseSCRRegisterImageJochi res);
	//부적합 보고서 조치결과 상세데이터 조회
	public void handle( Widget widget, AppRequestSCRViewJochi req, AppResponseSCRViewJochi res);
	//부적합보고서 조치결과 데이터,이미지 삭제
	public void handle( Widget widget, AppRequestSCRDeleteJochi req, AppResponseSCRDeleteJochi res);
	//부적합보고서 조치결과 데이터 삭제
	public void handle( Widget widget, AppRequestSCRDeleteJochiContents req, AppResponseSCRDeleteJochiContents res);

	
}
