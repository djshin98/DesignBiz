package com.hd.hse.json.handler;

import java.util.ArrayList;

import com.itf.framework.util.DATE;
import com.itf.framework.db.record.DataTable;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestConstructMachineList;
import com.hd.hse.json.AppResponseConstructMachineList;
import com.hd.hse.json.AppRequestConstructMachineDetail;
import com.hd.hse.json.AppResponseConstructMachineDetail;


public class ConstructMachine implements com.hd.hse.json.intf.IConstructMachine{
	private static ConstructMachine singletonConstructMachine;
	public static ConstructMachine getInstance(){
		if( singletonConstructMachine == null ){
			singletonConstructMachine = new ConstructMachine();
		}
		return singletonConstructMachine;
	}
	
	//건설장비투입현황 리스트 조회
	public void handle(Widget widget, AppRequestConstructMachineList req, AppResponseConstructMachineList res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}
	//건설장비투입현황 상세데이터 조회
	public void handle(Widget widget, AppRequestConstructMachineDetail req, AppResponseConstructMachineDetail res) {
		res.requestKey = req.requestKey;
		res.language = req.language;
		res.result = "OK";
	}

	
}
