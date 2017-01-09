package com.hd.hse.json.intf;

import java.util.ArrayList;
import com.itf.framework.servlet.Widget;

import com.hd.hse.json.AppRequestConstructMachineList;
import com.hd.hse.json.AppResponseConstructMachineList;
import com.hd.hse.json.AppRequestConstructMachineDetail;
import com.hd.hse.json.AppResponseConstructMachineDetail;


public interface IConstructMachine{

	//건설장비투입현황 리스트 조회
	public void handle( Widget widget, AppRequestConstructMachineList req, AppResponseConstructMachineList res);
	//건설장비투입현황 상세데이터 조회
	public void handle( Widget widget, AppRequestConstructMachineDetail req, AppResponseConstructMachineDetail res);

	
}
