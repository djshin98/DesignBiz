package com.hd.hse.json;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.itf.framework.util.AES256Cipher;

import com.itf.framework.servlet.Widget;
import com.hd.hse.json.handler.MobileMenu;
import com.hd.hse.json.handler.AppRooting;
import com.hd.hse.json.handler.AppRootingDetection;
import com.hd.hse.json.handler.Login;
import com.hd.hse.json.handler.EmployeeManage;
import com.hd.hse.json.handler.ConstructMachine;
import com.hd.hse.json.handler.LawFile;
import com.hd.hse.json.handler.PTW;
import com.hd.hse.json.handler.SafetyCheck;
import com.hd.hse.json.handler.NCR;
import com.hd.hse.json.handler.Training;
import com.hd.hse.json.handler.VersionCheck;
;

public class JSONGateway {
	private HashMap<String, Integer> jsonMapper = new HashMap<String, Integer>();
	private ArrayList<JSONAgent> jsonAgents = new ArrayList<JSONAgent>();

	public void appendAgent(JSONAgent agent) {
		jsonAgents.add(agent);
	}

	public void init() {
		jsonMapper.put(AppRequestAllowedMenu.NAME, AppRequestAllowedMenu.ID );
		jsonMapper.put(AppResponseAllowedMenu.NAME, AppResponseAllowedMenu.ID );
		jsonMapper.put(AppRequestAppInitialize.NAME, AppRequestAppInitialize.ID );
		jsonMapper.put(AppRootingCheckTarget.NAME, AppRootingCheckTarget.ID );
		jsonMapper.put(AppResponseAppInitialize.NAME, AppResponseAppInitialize.ID );
		jsonMapper.put(AppRequestAppRootingDetectReport.NAME, AppRequestAppRootingDetectReport.ID );
		jsonMapper.put(AppResponseAppRootingDetectReport.NAME, AppResponseAppRootingDetectReport.ID );
		jsonMapper.put(AppRequestLogin.NAME, AppRequestLogin.ID );
		jsonMapper.put(AppRequestLoginDevice.NAME, AppRequestLoginDevice.ID );
		jsonMapper.put(AppRequestLoginOption.NAME, AppRequestLoginOption.ID );
		jsonMapper.put(AppResponseLogin.NAME, AppResponseLogin.ID );
		jsonMapper.put(AppRequestPhotoUpload.NAME, AppRequestPhotoUpload.ID );
		jsonMapper.put(AppResponsePhotoUpload.NAME, AppResponsePhotoUpload.ID );
		jsonMapper.put(AppRequestPhotoArrayUpload.NAME, AppRequestPhotoArrayUpload.ID );
		jsonMapper.put(AppRequestEmployeeManageList.NAME, AppRequestEmployeeManageList.ID );
		jsonMapper.put(AppSupplierAttendance.NAME, AppSupplierAttendance.ID );
		jsonMapper.put(AppResponseEmployeeManageList.NAME, AppResponseEmployeeManageList.ID );
		jsonMapper.put(AppRequestEmployeeManageDetail.NAME, AppRequestEmployeeManageDetail.ID );
		jsonMapper.put(AppLaborAttendance.NAME, AppLaborAttendance.ID );
		jsonMapper.put(AppResponseEmployeeManageDetail.NAME, AppResponseEmployeeManageDetail.ID );
		jsonMapper.put(AppRequestConstructMachineList.NAME, AppRequestConstructMachineList.ID );
		jsonMapper.put(AppConstructMachineInfo.NAME, AppConstructMachineInfo.ID );
		jsonMapper.put(AppResponseConstructMachineList.NAME, AppResponseConstructMachineList.ID );
		jsonMapper.put(AppRequestConstructMachineDetail.NAME, AppRequestConstructMachineDetail.ID );
		jsonMapper.put(AppConstructMachineDetailInfo.NAME, AppConstructMachineDetailInfo.ID );
		jsonMapper.put(AppResponseConstructMachineDetail.NAME, AppResponseConstructMachineDetail.ID );
		jsonMapper.put(AppRequestLawFileList.NAME, AppRequestLawFileList.ID );
		jsonMapper.put(AppLawFile.NAME, AppLawFile.ID );
		jsonMapper.put(AppResponseLawFileList.NAME, AppResponseLawFileList.ID );
		jsonMapper.put(AppRequestMSPSearch.NAME, AppRequestMSPSearch.ID );
		jsonMapper.put(AppRiskReport.NAME, AppRiskReport.ID );
		jsonMapper.put(AppRiskFactor.NAME, AppRiskFactor.ID );
		jsonMapper.put(AppResponseMSPSearch.NAME, AppResponseMSPSearch.ID );
		jsonMapper.put(AppRequestSupconSearch.NAME, AppRequestSupconSearch.ID );
		jsonMapper.put(AppSupplier.NAME, AppSupplier.ID );
		jsonMapper.put(AppResponseSupconSearch.NAME, AppResponseSupconSearch.ID );
		jsonMapper.put(AppSCItem.NAME, AppSCItem.ID );
		jsonMapper.put(AppRequestSCGongjongList.NAME, AppRequestSCGongjongList.ID );
		jsonMapper.put(AppResponseSCGongjongList.NAME, AppResponseSCGongjongList.ID );
		jsonMapper.put(AppRequestSCWorkList.NAME, AppRequestSCWorkList.ID );
		jsonMapper.put(AppResponseSCWorkList.NAME, AppResponseSCWorkList.ID );
		jsonMapper.put(AppRequestSCCheckList.NAME, AppRequestSCCheckList.ID );
		jsonMapper.put(AppWorkSafetyCheck.NAME, AppWorkSafetyCheck.ID );
		jsonMapper.put(AppResponseSCCheckList.NAME, AppResponseSCCheckList.ID );
		jsonMapper.put(AppRequestSCCheckListRegister.NAME, AppRequestSCCheckListRegister.ID );
		jsonMapper.put(AppResponseSCCheckListRegister.NAME, AppResponseSCCheckListRegister.ID );
		jsonMapper.put(AppRequestSCCheckListUpdate.NAME, AppRequestSCCheckListUpdate.ID );
		jsonMapper.put(AppResponseSCCheckListUpdate.NAME, AppResponseSCCheckListUpdate.ID );
		jsonMapper.put(AppRequestSCCheckWriteList.NAME, AppRequestSCCheckWriteList.ID );
		jsonMapper.put(AppResponseSCCheckWriteList.NAME, AppResponseSCCheckWriteList.ID );
		jsonMapper.put(AppRequestSCCheckListDelete.NAME, AppRequestSCCheckListDelete.ID );
		jsonMapper.put(AppResponseSCCheckListDelete.NAME, AppResponseSCCheckListDelete.ID );
		jsonMapper.put(AppPhoto.NAME, AppPhoto.ID );
		jsonMapper.put(AppVoice.NAME, AppVoice.ID );
		jsonMapper.put(AppNCRDetail.NAME, AppNCRDetail.ID );
		jsonMapper.put(AppNCRSimple.NAME, AppNCRSimple.ID );
		jsonMapper.put(AppDepartment.NAME, AppDepartment.ID );
		jsonMapper.put(AppRequestSCRList.NAME, AppRequestSCRList.ID );
		jsonMapper.put(AppResponseSCRList.NAME, AppResponseSCRList.ID );
		jsonMapper.put(AppRequestSCRReceiveDeptList.NAME, AppRequestSCRReceiveDeptList.ID );
		jsonMapper.put(AppResponseSCRReceiveDeptList.NAME, AppResponseSCRReceiveDeptList.ID );
		jsonMapper.put(AppRequestSCRIssueDeptList.NAME, AppRequestSCRIssueDeptList.ID );
		jsonMapper.put(AppResponseSCRIssueDeptList.NAME, AppResponseSCRIssueDeptList.ID );
		jsonMapper.put(AppRequestSCREmployeeList.NAME, AppRequestSCREmployeeList.ID );
		jsonMapper.put(AppOrganItem.NAME, AppOrganItem.ID );
		jsonMapper.put(AppResponseSCREmployeeList.NAME, AppResponseSCREmployeeList.ID );
		jsonMapper.put(AppRequestSCRView.NAME, AppRequestSCRView.ID );
		jsonMapper.put(AppResponseSCRView.NAME, AppResponseSCRView.ID );
		jsonMapper.put(AppRequestSCRRegister.NAME, AppRequestSCRRegister.ID );
		jsonMapper.put(AppResponseSCRRegister.NAME, AppResponseSCRRegister.ID );
		jsonMapper.put(AppRequestSCREdit.NAME, AppRequestSCREdit.ID );
		jsonMapper.put(AppResponseSCREdit.NAME, AppResponseSCREdit.ID );
		jsonMapper.put(AppRequestSCRSendSMS.NAME, AppRequestSCRSendSMS.ID );
		jsonMapper.put(AppResponseSCRSendSMS.NAME, AppResponseSCRSendSMS.ID );
		jsonMapper.put(AppRequestSCRDelete.NAME, AppRequestSCRDelete.ID );
		jsonMapper.put(AppResponseSCRDelete.NAME, AppResponseSCRDelete.ID );
		jsonMapper.put(AppRequestSCRRegisterImage.NAME, AppRequestSCRRegisterImage.ID );
		jsonMapper.put(AppResponseSCRRegisterImage.NAME, AppResponseSCRRegisterImage.ID );
		jsonMapper.put(AppRequestSCRRegisterVoice.NAME, AppRequestSCRRegisterVoice.ID );
		jsonMapper.put(AppResponseSCRRegisterVoice.NAME, AppResponseSCRRegisterVoice.ID );
		jsonMapper.put(AppRequestSCRRegisterJochi.NAME, AppRequestSCRRegisterJochi.ID );
		jsonMapper.put(AppResponseSCRRegisterJochi.NAME, AppResponseSCRRegisterJochi.ID );
		jsonMapper.put(AppRequestSCRRegisterImageJochi.NAME, AppRequestSCRRegisterImageJochi.ID );
		jsonMapper.put(AppResponseSCRRegisterImageJochi.NAME, AppResponseSCRRegisterImageJochi.ID );
		jsonMapper.put(AppNCRResult.NAME, AppNCRResult.ID );
		jsonMapper.put(AppRequestSCRViewJochi.NAME, AppRequestSCRViewJochi.ID );
		jsonMapper.put(AppResponseSCRViewJochi.NAME, AppResponseSCRViewJochi.ID );
		jsonMapper.put(AppRequestSCRDeleteJochi.NAME, AppRequestSCRDeleteJochi.ID );
		jsonMapper.put(AppResponseSCRDeleteJochi.NAME, AppResponseSCRDeleteJochi.ID );
		jsonMapper.put(AppRequestSCRDeleteJochiContents.NAME, AppRequestSCRDeleteJochiContents.ID );
		jsonMapper.put(AppResponseSCRDeleteJochiContents.NAME, AppResponseSCRDeleteJochiContents.ID );
		jsonMapper.put(AppEducation.NAME, AppEducation.ID );
		jsonMapper.put(AppRequestTD_Insert.NAME, AppRequestTD_Insert.ID );
		jsonMapper.put(AppResponseTD_Insert.NAME, AppResponseTD_Insert.ID );
		jsonMapper.put(AppRequestTD_Update.NAME, AppRequestTD_Update.ID );
		jsonMapper.put(AppResponseTD_Update.NAME, AppResponseTD_Update.ID );
		jsonMapper.put(AppRequestTD_Delete.NAME, AppRequestTD_Delete.ID );
		jsonMapper.put(AppResponseTD_Delete.NAME, AppResponseTD_Delete.ID );
		jsonMapper.put(AppRequestTD_ListSearch.NAME, AppRequestTD_ListSearch.ID );
		jsonMapper.put(AppResponseTD_ListSearch.NAME, AppResponseTD_ListSearch.ID );
		jsonMapper.put(AppRequestTD_DetailSearch.NAME, AppRequestTD_DetailSearch.ID );
		jsonMapper.put(AppResponseTD_DetailSearch.NAME, AppResponseTD_DetailSearch.ID );
		jsonMapper.put(AppRequestTD_SignfileUpload.NAME, AppRequestTD_SignfileUpload.ID );
		jsonMapper.put(AppResponseTD_SignfileUpload.NAME, AppResponseTD_SignfileUpload.ID );
		jsonMapper.put(AppRequestVersionCheck.NAME, AppRequestVersionCheck.ID );
		jsonMapper.put(AppResponseVersionCheck.NAME, AppResponseVersionCheck.ID );

	}

	public String proc(Widget widget, String decodeData, HttpServletRequest request, HttpServletResponse response) {
		
		//String decodeData = decode( jsonEncodeData );
		
		if( decodeData == null ){
			request.setAttribute("error", "data is null");
			return null;
		}
		JSONObject jsonObject = null;
		String messageName;
		try {
			jsonObject = new JSONObject(decodeData);
			messageName = jsonObject.getString("requestObjectName");
		} catch (JSONException e) {
			request.setAttribute("error", e.getMessage());
			return null;
		}

		Integer messageId = jsonMapper.get(messageName);
		if( messageId == null ){
			for( JSONAgent agent : jsonAgents ){
				if( agent.hasMessage( messageName ) ){
					return agent.proc( jsonObject );
				}
			}
		}else{
			JSONObject messageBody;
			try {
				messageBody = jsonObject.getJSONObject("requestObject");
			} catch (JSONException e) {
				request.setAttribute("error", e.getMessage());
				return null;
			}
			switch (messageId) {
				case AppRequestAllowedMenu.ID: {//메뉴 권한 조회
					AppRequestAllowedMenu req = AppRequestAllowedMenu.decoding(messageBody);
					AppResponseAllowedMenu res = new AppResponseAllowedMenu();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					MobileMenu.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestAppInitialize.ID: {//앱 루팅 탐지 정보 조회
					AppRequestAppInitialize req = AppRequestAppInitialize.decoding(messageBody);
					AppResponseAppInitialize res = new AppResponseAppInitialize();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					AppRooting.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestAppRootingDetectReport.ID: {//앱 루팅 탐지
					AppRequestAppRootingDetectReport req = AppRequestAppRootingDetectReport.decoding(messageBody);
					AppResponseAppRootingDetectReport res = new AppResponseAppRootingDetectReport();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					AppRootingDetection.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestLogin.ID: {//로그인
					AppRequestLogin req = AppRequestLogin.decoding(messageBody);
					AppResponseLogin res = new AppResponseLogin();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					Login.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestLoginDevice.ID: {//기기 인증
					AppRequestLoginDevice req = AppRequestLoginDevice.decoding(messageBody);
					AppResponseLogin res = new AppResponseLogin();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					Login.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestLoginOption.ID: {//부가인증
					AppRequestLoginOption req = AppRequestLoginOption.decoding(messageBody);
					AppResponseLogin res = new AppResponseLogin();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					Login.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestEmployeeManageList.ID: {//현장 출역현황 조회
					AppRequestEmployeeManageList req = AppRequestEmployeeManageList.decoding(messageBody);
					AppResponseEmployeeManageList res = new AppResponseEmployeeManageList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					EmployeeManage.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestEmployeeManageDetail.ID: {//협력업체 출역현황 상세데이터 조회
					AppRequestEmployeeManageDetail req = AppRequestEmployeeManageDetail.decoding(messageBody);
					AppResponseEmployeeManageDetail res = new AppResponseEmployeeManageDetail();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					EmployeeManage.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestConstructMachineList.ID: {//건설장비투입현황 리스트 조회
					AppRequestConstructMachineList req = AppRequestConstructMachineList.decoding(messageBody);
					AppResponseConstructMachineList res = new AppResponseConstructMachineList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					ConstructMachine.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestConstructMachineDetail.ID: {//건설장비투입현황 상세데이터 조회
					AppRequestConstructMachineDetail req = AppRequestConstructMachineDetail.decoding(messageBody);
					AppResponseConstructMachineDetail res = new AppResponseConstructMachineDetail();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					ConstructMachine.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestLawFileList.ID: {//법률 파일 관리
					AppRequestLawFileList req = AppRequestLawFileList.decoding(messageBody);
					AppResponseLawFileList res = new AppResponseLawFileList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					LawFile.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestMSPSearch.ID: {//명일안전작업계획서 조회
					AppRequestMSPSearch req = AppRequestMSPSearch.decoding(messageBody);
					AppResponseMSPSearch res = new AppResponseMSPSearch();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					PTW.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSupconSearch.ID: {//업체 조회
					AppRequestSupconSearch req = AppRequestSupconSearch.decoding(messageBody);
					AppResponseSupconSearch res = new AppResponseSupconSearch();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					PTW.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCGongjongList.ID: {//안전점검체크리스트 작업공종조회
					AppRequestSCGongjongList req = AppRequestSCGongjongList.decoding(messageBody);
					AppResponseSCGongjongList res = new AppResponseSCGongjongList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					SafetyCheck.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCWorkList.ID: {//안전점검체크리스트 작업활동조회
					AppRequestSCWorkList req = AppRequestSCWorkList.decoding(messageBody);
					AppResponseSCWorkList res = new AppResponseSCWorkList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					SafetyCheck.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCCheckList.ID: {//안전점검체크리스트 항목조회
					AppRequestSCCheckList req = AppRequestSCCheckList.decoding(messageBody);
					AppResponseSCCheckList res = new AppResponseSCCheckList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					SafetyCheck.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCCheckListRegister.ID: {//안전점검체크리스트 데이터 저장
					AppRequestSCCheckListRegister req = AppRequestSCCheckListRegister.decoding(messageBody);
					AppResponseSCCheckListRegister res = new AppResponseSCCheckListRegister();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					SafetyCheck.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCCheckListUpdate.ID: {//안전점검체크리스트 데이터 수정
					AppRequestSCCheckListUpdate req = AppRequestSCCheckListUpdate.decoding(messageBody);
					AppResponseSCCheckListUpdate res = new AppResponseSCCheckListUpdate();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					SafetyCheck.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCCheckWriteList.ID: {//안전점검체크리스트 작성리스트 조회
					AppRequestSCCheckWriteList req = AppRequestSCCheckWriteList.decoding(messageBody);
					AppResponseSCCheckWriteList res = new AppResponseSCCheckWriteList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					SafetyCheck.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCCheckListDelete.ID: {//안전점검체크리스트 작성리스트 삭제
					AppRequestSCCheckListDelete req = AppRequestSCCheckListDelete.decoding(messageBody);
					AppResponseSCCheckListDelete res = new AppResponseSCCheckListDelete();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					SafetyCheck.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRList.ID: {//부적합 보고서 리스트 조회 후 결과리턴
					AppRequestSCRList req = AppRequestSCRList.decoding(messageBody);
					AppResponseSCRList res = new AppResponseSCRList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRReceiveDeptList.ID: {//부적합보고서 수신부서 
					AppRequestSCRReceiveDeptList req = AppRequestSCRReceiveDeptList.decoding(messageBody);
					AppResponseSCRReceiveDeptList res = new AppResponseSCRReceiveDeptList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRIssueDeptList.ID: {//부적합보고서 발행부서 
					AppRequestSCRIssueDeptList req = AppRequestSCRIssueDeptList.decoding(messageBody);
					AppResponseSCRIssueDeptList res = new AppResponseSCRIssueDeptList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCREmployeeList.ID: {//직원 조직도 조회
					AppRequestSCREmployeeList req = AppRequestSCREmployeeList.decoding(messageBody);
					AppResponseSCREmployeeList res = new AppResponseSCREmployeeList();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRView.ID: {//상세데이터 조회
					AppRequestSCRView req = AppRequestSCRView.decoding(messageBody);
					AppResponseSCRView res = new AppResponseSCRView();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRRegister.ID: {//부적합 보고서 리스트 저장 후 결과리턴
					AppRequestSCRRegister req = AppRequestSCRRegister.decoding(messageBody);
					AppResponseSCRRegister res = new AppResponseSCRRegister();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCREdit.ID: {//부적합 보고서 리스트 업데이트 후 결과리턴
					AppRequestSCREdit req = AppRequestSCREdit.decoding(messageBody);
					AppResponseSCREdit res = new AppResponseSCREdit();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRSendSMS.ID: {//부적합보고서 문자전송
					AppRequestSCRSendSMS req = AppRequestSCRSendSMS.decoding(messageBody);
					AppResponseSCRSendSMS res = new AppResponseSCRSendSMS();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRDelete.ID: {//부적합보고서 삭제
					AppRequestSCRDelete req = AppRequestSCRDelete.decoding(messageBody);
					AppResponseSCRDelete res = new AppResponseSCRDelete();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRRegisterImage.ID: {//부적합 보고서 이미지 저장 후 결과리턴
					AppRequestSCRRegisterImage req = AppRequestSCRRegisterImage.decoding(messageBody);
					AppResponseSCRRegisterImage res = new AppResponseSCRRegisterImage();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRRegisterVoice.ID: {//부적합 보고서 음성 저장 후 결과리턴
					AppRequestSCRRegisterVoice req = AppRequestSCRRegisterVoice.decoding(messageBody);
					AppResponseSCRRegisterVoice res = new AppResponseSCRRegisterVoice();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRRegisterJochi.ID: {//부적합 보고서 조치결과 저장
					AppRequestSCRRegisterJochi req = AppRequestSCRRegisterJochi.decoding(messageBody);
					AppResponseSCRRegisterJochi res = new AppResponseSCRRegisterJochi();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRRegisterImageJochi.ID: {//부적합 보고서 조치 후 이미지 저장 후 결과리턴
					AppRequestSCRRegisterImageJochi req = AppRequestSCRRegisterImageJochi.decoding(messageBody);
					AppResponseSCRRegisterImageJochi res = new AppResponseSCRRegisterImageJochi();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRViewJochi.ID: {//부적합 보고서 조치결과 상세데이터 조회
					AppRequestSCRViewJochi req = AppRequestSCRViewJochi.decoding(messageBody);
					AppResponseSCRViewJochi res = new AppResponseSCRViewJochi();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRDeleteJochi.ID: {//부적합보고서 조치결과 데이터,이미지 삭제
					AppRequestSCRDeleteJochi req = AppRequestSCRDeleteJochi.decoding(messageBody);
					AppResponseSCRDeleteJochi res = new AppResponseSCRDeleteJochi();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestSCRDeleteJochiContents.ID: {//부적합보고서 조치결과 데이터 삭제
					AppRequestSCRDeleteJochiContents req = AppRequestSCRDeleteJochiContents.decoding(messageBody);
					AppResponseSCRDeleteJochiContents res = new AppResponseSCRDeleteJochiContents();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					NCR.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestTD_Insert.ID: {//교육훈련일지 저장 후 결과리턴
					AppRequestTD_Insert req = AppRequestTD_Insert.decoding(messageBody);
					AppResponseTD_Insert res = new AppResponseTD_Insert();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					Training.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestTD_Update.ID: {//교육훈련일지 수정
					AppRequestTD_Update req = AppRequestTD_Update.decoding(messageBody);
					AppResponseTD_Update res = new AppResponseTD_Update();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					Training.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestTD_Delete.ID: {//교육훈련일지 삭제
					AppRequestTD_Delete req = AppRequestTD_Delete.decoding(messageBody);
					AppResponseTD_Delete res = new AppResponseTD_Delete();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					Training.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestTD_ListSearch.ID: {//교육훈련일지 리스트 조회
					AppRequestTD_ListSearch req = AppRequestTD_ListSearch.decoding(messageBody);
					AppResponseTD_ListSearch res = new AppResponseTD_ListSearch();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					Training.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestTD_DetailSearch.ID: {//교육훈련일지 상세 조회
					AppRequestTD_DetailSearch req = AppRequestTD_DetailSearch.decoding(messageBody);
					AppResponseTD_DetailSearch res = new AppResponseTD_DetailSearch();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					Training.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestTD_SignfileUpload.ID: {//교육훈련 서명파일_업로드
					AppRequestTD_SignfileUpload req = AppRequestTD_SignfileUpload.decoding(messageBody);
					AppResponseTD_SignfileUpload res = new AppResponseTD_SignfileUpload();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					Training.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}
				case AppRequestVersionCheck.ID: {//버젼 체크
					AppRequestVersionCheck req = AppRequestVersionCheck.decoding(messageBody);
					AppResponseVersionCheck res = new AppResponseVersionCheck();
					req.setHttpRequest(request);
					res.setHttpResponse(response);
					VersionCheck.getInstance().handle( widget, req , res );
					return encode( res.encoding() );
				}

			}
		}
		request.setAttribute("error", "Message does not implements");
		return null;
	}

	public String encode( JSONObject obj ) {
		return obj.toString();
	}
	/*
	public String decode(String jsonEncodeData) {
		AES256Cipher a256 = AES256Cipher.getInstance();
		String decodeData = null;
		try {
			decodeData = a256.AES_Decode(jsonEncodeData);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			return null;
		} catch (BadPaddingException e) {
			e.printStackTrace();
			return null;
		}
		return decodeData;
	}
	
	public String encode( JSONObject obj ) {
		String jsonEncodeData = obj.toString();
		AES256Cipher a256 = AES256Cipher.getInstance();
		String encodeData = null;
		try {
			encodeData = a256.AES_Encode(jsonEncodeData);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			return null;
		} catch (BadPaddingException e) {
			e.printStackTrace();
			return null;
		}
		return encodeData;
	}*/
}
