package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestLawFileList;
import com.hd.hse.json.AppResponseLawFileList;


public class LawFile implements com.hd.hse.json.intf.ILawFile{
	private static LawFile singletonLawFile;
	public static LawFile getInstance(){
		if( singletonLawFile == null ){
			singletonLawFile = new LawFile();
		}
		return singletonLawFile;
	}
	
	//법률 파일 관리
	public void handle(Widget widget, AppRequestLawFileList req, AppResponseLawFileList res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
