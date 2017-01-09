package com.hd.hse.json.intf;

import java.util.ArrayList;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestLawFileList;
import com.hd.hse.json.AppResponseLawFileList;


public interface ILawFile{

	//법률 파일 관리
	public void handle( Widget widget, AppRequestLawFileList req, AppResponseLawFileList res);

	
}
