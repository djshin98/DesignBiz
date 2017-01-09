//현장 출역현황 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestEmployeeManageList 현장 출역현황 조회
*******************************************************************************************************************************************************************************/
var RequestEmployeeManageList = function(){
	this.prop = {
		requestObjectName : 'AppRequestEmployeeManageList',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			supcode : '',				//
			date : '',					//시간 정보
			workdate : '',			//시간 정보
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestEmployeeManageList 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.supcode='';
		this.prop.requestObject.date='';
		this.prop.requestObject.workdate='';
		this.prop.requestObject.language='';

    };
    //RequestEmployeeManageList 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestEmployeeManageList request Message를 서버에 요청 하고, ResponseEmployeeManageList Message가 recevedData로 리턴받는다.
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
						receivedData.workdate;			//시간 정보
						for( i = 0 ; i < receivedData.records.length ; i++ ){
							avv= receivedData.records[i];				//협력사 출근 상황 목록
							avv.workdate;			//요청 일(시간) 정보
							avv.supcode;				//협력사 코드
							avv.company;				//협력사 명
							avv.todayCount;			//입출입 카운트
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
		    		}else{ //RequestEmployeeManageList 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestEmployeeManageList 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//협력업체 출역현황 상세데이터 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestEmployeeManageDetail 협력업체 출역현황 상세데이터 조회
*******************************************************************************************************************************************************************************/
var RequestEmployeeManageDetail = function(){
	this.prop = {
		requestObjectName : 'AppRequestEmployeeManageDetail',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			supcode : '',				//협력사 코드
			date : '',					//메시지 발송 시간 정보
			workdate : '',			//출역 요청일(시간) 정보
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestEmployeeManageDetail 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.supcode='';
		this.prop.requestObject.date='';
		this.prop.requestObject.workdate='';
		this.prop.requestObject.language='';

    };
    //RequestEmployeeManageDetail 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestEmployeeManageDetail request Message를 서버에 요청 하고, ResponseEmployeeManageDetail Message가 recevedData로 리턴받는다.
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
						receivedData.workdate;			//시간 정보
						for( i = 0 ; i < receivedData.fulltimeWorkers.length ; i++ ){
							avv= receivedData.fulltimeWorkers[i];	//
							avv.group;				//구분
							avv.jickjong;			//직종
							avv.name;					//이름
							avv.attendTime;			//출근 시간 정보
							avv.closingTime;			//퇴근 시간 정보
							avv.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
						}
						for( i = 0 ; i < receivedData.shorttermWorkers.length ; i++ ){
							avv= receivedData.shorttermWorkers[i];	//
							avv.group;				//구분
							avv.jickjong;			//직종
							avv.name;					//이름
							avv.attendTime;			//출근 시간 정보
							avv.closingTime;			//퇴근 시간 정보
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
		    		}else{ //RequestEmployeeManageDetail 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestEmployeeManageDetail 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
