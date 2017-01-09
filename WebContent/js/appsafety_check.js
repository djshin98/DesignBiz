//안전점검체크리스트 작업공종조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCGongjongList 안전점검체크리스트 작업공종조회
*******************************************************************************************************************************************************************************/
var RequestSCGongjongList = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCGongjongList',
		requestObject :{ 
			requestKey : '',			//요청 키
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCGongjongList 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.language='';

    };
    //RequestSCGongjongList 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCGongjongList request Message를 서버에 요청 하고, ResponseSCGongjongList Message가 recevedData로 리턴받는다.
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
						receivedData.checkDate;			//요청일시
						for( i = 0 ; i < receivedData.workSCList.length ; i++ ){
							avv= receivedData.workSCList[i];			//공종 목록
							avv.workCode;			//공종코드
							avv.workType;			//공종명
							avv.workName;			//작업명
							avv.check;				//체크여부
							avv.uptdt;				//최근수정날짜
							avv.insid;				//작성자사번
							avv.writer;				//작성자
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
		    		}else{ //RequestSCGongjongList 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCGongjongList 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//안전점검체크리스트 작업활동조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCWorkList 안전점검체크리스트 작업활동조회
*******************************************************************************************************************************************************************************/
var RequestSCWorkList = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCWorkList',
		requestObject :{ 
			requestKey : '',			//요청 키
			xparentid : '',			//부모코드 1
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCWorkList 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.xparentid='';
		this.prop.requestObject.language='';

    };
    //RequestSCWorkList 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCWorkList request Message를 서버에 요청 하고, ResponseSCWorkList Message가 recevedData로 리턴받는다.
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
						receivedData.checkDate;			//요청일시
						for( i = 0 ; i < receivedData.workSCList.length ; i++ ){
							avv= receivedData.workSCList[i];			//작업활동 목록
							avv.workCode;			//공종코드
							avv.workType;			//공종명
							avv.workName;			//작업명
							avv.check;				//체크여부
							avv.uptdt;				//최근수정날짜
							avv.insid;				//작성자사번
							avv.writer;				//작성자
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
		    		}else{ //RequestSCWorkList 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCWorkList 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//안전점검체크리스트 항목조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCCheckList 안전점검체크리스트 항목조회
*******************************************************************************************************************************************************************************/
var RequestSCCheckList = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCCheckList',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			date : '',					//작업일시
			xparentid : '',			//부모코드 2
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCCheckList 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.date='';
		this.prop.requestObject.xparentid='';
		this.prop.requestObject.language='';

    };
    //RequestSCCheckList 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCCheckList request Message를 서버에 요청 하고, ResponseSCCheckList Message가 recevedData로 리턴받는다.
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
						receivedData.checkDate;			//요청일시
						for( i = 0 ; i < receivedData.workSCList.length ; i++ ){
							avv= receivedData.workSCList[i];			//작업 체크 목록
							avv.workCode;			//공종코드
							avv.workType;			//공종명
							avv.workName;			//작업명
							avv.check;				//체크여부
							avv.uptdt;				//최근수정날짜
							avv.insid;				//작성자사번
							avv.writer;				//작성자
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
		    		}else{ //RequestSCCheckList 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCCheckList 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//안전점검체크리스트 데이터 저장
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCCheckListRegister 안전점검체크리스트 데이터 저장
*******************************************************************************************************************************************************************************/
var RequestSCCheckListRegister = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCCheckListRegister',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			date : '',					//작업일시
			work : '',					//작업
			checklist : [],			//체크리스트
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCCheckListRegister 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.date='';
		this.prop.requestObject.work='';
		for( i = 0 ; i < this.checklist.length ; i++ ){
			this_avv= this.checklist[i];
			this_avv.checkitem='';
			this_avv.gubun='';
			this_avv.language='';
		}
		this.prop.requestObject.language='';

    };
    //RequestSCCheckListRegister 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCCheckListRegister request Message를 서버에 요청 하고, ResponseSCCheckListRegister Message가 recevedData로 리턴받는다.
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
						receivedData.checkDate;			//요청일시
						receivedData.sitecode;			//현장 코드값
						receivedData.date;					//작업일시
						receivedData.workTypeCode;		//공종코드
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
		    		}else{ //RequestSCCheckListRegister 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCCheckListRegister 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//안전점검체크리스트 데이터 수정
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCCheckListUpdate 안전점검체크리스트 데이터 수정
*******************************************************************************************************************************************************************************/
var RequestSCCheckListUpdate = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCCheckListUpdate',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			date : '',					//작업일시
			work : '',					//작업
			checklist : [],			//체크리스트
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCCheckListUpdate 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.date='';
		this.prop.requestObject.work='';
		for( i = 0 ; i < this.checklist.length ; i++ ){
			this_avv= this.checklist[i];
			this_avv.checkitem='';
			this_avv.gubun='';
			this_avv.language='';
		}
		this.prop.requestObject.language='';

    };
    //RequestSCCheckListUpdate 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCCheckListUpdate request Message를 서버에 요청 하고, ResponseSCCheckListUpdate Message가 recevedData로 리턴받는다.
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
						receivedData.checkDate;			//요청일시
						receivedData.sitecode;			//현장 코드값
						receivedData.date;					//작업일시
						receivedData.workTypeCode;		//공종코드
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
		    		}else{ //RequestSCCheckListUpdate 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCCheckListUpdate 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//안전점검체크리스트 작성리스트 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCCheckWriteList 안전점검체크리스트 작성리스트 조회
*******************************************************************************************************************************************************************************/
var RequestSCCheckWriteList = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCCheckWriteList',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			date : '',					//작업일시
			work : '',					//작업
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCCheckWriteList 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.date='';
		this.prop.requestObject.work='';
		this.prop.requestObject.language='';

    };
    //RequestSCCheckWriteList 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCCheckWriteList request Message를 서버에 요청 하고, ResponseSCCheckWriteList Message가 recevedData로 리턴받는다.
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
						receivedData.checkDate;			//요청일시
						for( i = 0 ; i < receivedData.workSCList.length ; i++ ){
							avv= receivedData.workSCList[i];			//협력업체 목록
							avv.workCode;			//공종코드
							avv.workType;			//공종명
							avv.workName;			//작업명
							avv.check;				//체크여부
							avv.uptdt;				//최근수정날짜
							avv.insid;				//작성자사번
							avv.writer;				//작성자
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
		    		}else{ //RequestSCCheckWriteList 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCCheckWriteList 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//안전점검체크리스트 작성리스트 삭제
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCCheckListDelete 안전점검체크리스트 작성리스트 삭제
*******************************************************************************************************************************************************************************/
var RequestSCCheckListDelete = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCCheckListDelete',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			date : '',					//작업일시
			work : '',					//작업
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCCheckListDelete 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.date='';
		this.prop.requestObject.work='';
		this.prop.requestObject.language='';

    };
    //RequestSCCheckListDelete 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCCheckListDelete request Message를 서버에 요청 하고, ResponseSCCheckListDelete Message가 recevedData로 리턴받는다.
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
						receivedData.sitecode;			//현장 코드값
						receivedData.userid;				//사용자 아이디
						receivedData.date;					//작업일시
						receivedData.work;					//작업
						receivedData.checkDate;			//요청일시
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
		    		}else{ //RequestSCCheckListDelete 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCCheckListDelete 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
