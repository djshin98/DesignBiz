//건설장비투입현황 리스트 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestConstructMachineList 건설장비투입현황 리스트 조회
*******************************************************************************************************************************************************************************/
var RequestConstructMachineList = function(){
	this.prop = {
		requestObjectName : 'AppRequestConstructMachineList',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			manageno : '',			//관리번호
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestConstructMachineList 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.manageno='';
		this.prop.requestObject.language='';

    };
    //RequestConstructMachineList 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestConstructMachineList request Message를 서버에 요청 하고, ResponseConstructMachineList Message가 recevedData로 리턴받는다.
    	M.net.http.send({
			server:	'mhse',
			path:	'/api/msp/mhse/message',
		    method:	'POST',
		    indicator: {
		    	show: true
		    },
		    data:	this.prop ,
		    onSuccess:	function(receivedData, setting) {
		    	//M.tool.log( "onSuccess", recevedData );
		    	//alert( "onSuccess, " + JSON.stringify(recevedData) );
		    	if( receivedData.result == 'OK' ){
		    		if( onSuccessResponse == undefined || onSuccessResponse == null ){
						receivedData.requestKey;			//요청 키
						receivedData.result;				//요청 처리 결과값
						receivedData.resultMessage;	//처리 오류 상세 메시지
						receivedData.checkDate;			//시간 정보
						for( i = 0 ; i < receivedData.constructMachineInfos.length ; i++ ){
							avv= receivedData.constructMachineInfos[i];	//
							avv.cod_nam;				//장비명
							avv.size;					//규격
							avv.supname;				//업체명
							avv.carno;				//차량번호
							avv.manageno;			//관리번호
							avv.insurend;			//보험종료일자
							avv.licenseend;			//면허종료일자
							avv.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
						}
						receivedData.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

					}else{
		    			onSuccessResponse(receivedData, setting);
		    		}
		    	}else if( receivedData.result == "NOAUTH" ){
		    		window.location.href = "login";
		    		return;
		    	}else{
		    		if( onFailResponse == undefined || onFailResponse == null ){
		    			alert( "Fail : " + receivedData.resultMessage );
		    		}else{ //RequestConstructMachineList 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestConstructMachineList 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//건설장비투입현황 상세데이터 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestConstructMachineDetail 건설장비투입현황 상세데이터 조회
*******************************************************************************************************************************************************************************/
var RequestConstructMachineDetail = function(){
	this.prop = {
		requestObjectName : 'AppRequestConstructMachineDetail',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			manageno : '',			//관리 번호
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestConstructMachineDetail 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.manageno='';
		this.prop.requestObject.language='';

    };
    //RequestConstructMachineDetail 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestConstructMachineDetail request Message를 서버에 요청 하고, ResponseConstructMachineDetail Message가 recevedData로 리턴받는다.
    	M.net.http.send({
			server:	'mhse',
			path:	'/api/msp/mhse/message',
		    method:	'POST',
		    indicator: {
		    	show: true
		    },
		    data:	this.prop ,
		    onSuccess:	function(receivedData, setting) {
		    	//M.tool.log( "onSuccess", recevedData );
		    	//alert( "onSuccess, " + JSON.stringify(recevedData) );
		    	if( receivedData.result == 'OK' ){
		    		if( onSuccessResponse == undefined || onSuccessResponse == null ){
						receivedData.requestKey;			//요청 키
						receivedData.result;				//요청 처리 결과값
						receivedData.resultMessage;	//처리 오류 상세 메시지
						receivedData.checkDate;			//요청 확인일
						for( i = 0 ; i < receivedData.constructMachineInfos.length ; i++ ){
							avv= receivedData.constructMachineInfos[i];	//건설장비 상세 정보값 리스트
							avv.lotnam;				//LOT명
							avv.machinename;			//장비명
							avv.size;					//규격
							avv.carno;				//차량번호
							avv.supname;				//업체명
							avv.insurdi;				//대인
							avv.insurdm;				//대물
							avv.insurjs;				//자손
							avv.insurjj;				//차차
							avv.insurstart;			//보험시작기간
							avv.insurend;			//보험종료기간
							avv.indate;				//반입일
							avv.outdate;				//반출예정일
							avv.outdate2;			//반출일
							avv.drivername;			//운전자
							avv.licensegubun;		//면허구분
							avv.licenseno;			//면허번호
							avv.licensestart;		//면허시작일
							avv.licenseend;			//면허종료일
							avv.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
						}
						receivedData.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

					}else{
		    			onSuccessResponse(receivedData, setting);
		    		}
		    	}else if( receivedData.result == "NOAUTH" ){
		    		window.location.href = "login";
		    		return;
		    	}else{
		    		if( onFailResponse == undefined || onFailResponse == null ){
		    			alert( "Fail : " + receivedData.resultMessage );
		    		}else{ //RequestConstructMachineDetail 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestConstructMachineDetail 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
