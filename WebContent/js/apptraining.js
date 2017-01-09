//교육훈련일지 저장 후 결과리턴
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestTD_Insert 교육훈련일지 저장 후 결과리턴
*******************************************************************************************************************************************************************************/
var RequestTD_Insert = function(){
	this.prop = {
		requestObjectName : 'AppRequestTD_Insert',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			ser : 0,					//
			date : '',					//
			doc : {					//문서
				ser : 0,					//NO
				name : '',					//교육명
				date : '',					//교육일자
				gubun : '',				//교육구분
				start : '',				//교육시작시간
				end : '',					//교육종료시간
				place : '',				//현장 교육장소
				speaker : '',				//강사
				method : '',				//교육방법
				content : '',				//교육내용
				sign : '',					//서명
				userid : '',				//작성자사번
				language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
			},
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestTD_Insert 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.date='';
				this.prop.requestObject.doc.ser=0;
			this.prop.requestObject.doc.name='';
			this.prop.requestObject.doc.date='';
			this.prop.requestObject.doc.gubun='';
			this.prop.requestObject.doc.start='';
			this.prop.requestObject.doc.end='';
			this.prop.requestObject.doc.place='';
			this.prop.requestObject.doc.speaker='';
			this.prop.requestObject.doc.method='';
			this.prop.requestObject.doc.content='';
			this.prop.requestObject.doc.sign='';
			this.prop.requestObject.doc.userid='';
			this.prop.requestObject.doc.language='';
		this.prop.requestObject.language='';

    };
    //RequestTD_Insert 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestTD_Insert request Message를 서버에 요청 하고, ResponseTD_Insert Message가 recevedData로 리턴받는다.
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
						receivedData.date;					//
						receivedData.userid;				//사용자 아이디
						receivedData.ser;					//
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
		    		}else{ //RequestTD_Insert 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestTD_Insert 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//교육훈련일지 수정
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestTD_Update 교육훈련일지 수정
*******************************************************************************************************************************************************************************/
var RequestTD_Update = function(){
	this.prop = {
		requestObjectName : 'AppRequestTD_Update',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			ser : 0,					//
			date : '',					//
			doc : {					//문서
				ser : 0,					//NO
				name : '',					//교육명
				date : '',					//교육일자
				gubun : '',				//교육구분
				start : '',				//교육시작시간
				end : '',					//교육종료시간
				place : '',				//현장 교육장소
				speaker : '',				//강사
				method : '',				//교육방법
				content : '',				//교육내용
				sign : '',					//서명
				userid : '',				//작성자사번
				language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
			},
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestTD_Update 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.date='';
				this.prop.requestObject.doc.ser=0;
			this.prop.requestObject.doc.name='';
			this.prop.requestObject.doc.date='';
			this.prop.requestObject.doc.gubun='';
			this.prop.requestObject.doc.start='';
			this.prop.requestObject.doc.end='';
			this.prop.requestObject.doc.place='';
			this.prop.requestObject.doc.speaker='';
			this.prop.requestObject.doc.method='';
			this.prop.requestObject.doc.content='';
			this.prop.requestObject.doc.sign='';
			this.prop.requestObject.doc.userid='';
			this.prop.requestObject.doc.language='';
		this.prop.requestObject.language='';

    };
    //RequestTD_Update 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestTD_Update request Message를 서버에 요청 하고, ResponseTD_Update Message가 recevedData로 리턴받는다.
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
						receivedData.date;					//
						receivedData.userid;				//사용자 아이디
						receivedData.ser;					//
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
		    		}else{ //RequestTD_Update 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestTD_Update 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//교육훈련일지 삭제
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestTD_Delete 교육훈련일지 삭제
*******************************************************************************************************************************************************************************/
var RequestTD_Delete = function(){
	this.prop = {
		requestObjectName : 'AppRequestTD_Delete',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			ser : 0,					//
			date : '',					//
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestTD_Delete 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.date='';
		this.prop.requestObject.language='';

    };
    //RequestTD_Delete 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestTD_Delete request Message를 서버에 요청 하고, ResponseTD_Delete Message가 recevedData로 리턴받는다.
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
						receivedData.date;					//
						receivedData.userid;				//사용자 아이디
						receivedData.ser;					//
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
		    		}else{ //RequestTD_Delete 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestTD_Delete 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//교육훈련일지 리스트 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestTD_ListSearch 교육훈련일지 리스트 조회
*******************************************************************************************************************************************************************************/
var RequestTD_ListSearch = function(){
	this.prop = {
		requestObjectName : 'AppRequestTD_ListSearch',
		requestObject :{ 
			requestKey : '',			//요청 키
			userid : '',				//사용자 아이디
			sitecode : '',			//현장 코드값
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestTD_ListSearch 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.userid='';
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.language='';

    };
    //RequestTD_ListSearch 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestTD_ListSearch request Message를 서버에 요청 하고, ResponseTD_ListSearch Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.docs.length ; i++ ){
							avv= receivedData.docs[i];					//문서
							avv.ser;					//NO
							avv.name;					//교육명
							avv.date;					//교육일자
							avv.gubun;				//교육구분
							avv.start;				//교육시작시간
							avv.end;					//교육종료시간
							avv.place;				//현장 교육장소
							avv.speaker;				//강사
							avv.method;				//교육방법
							avv.content;				//교육내용
							avv.sign;					//서명
							avv.userid;				//작성자사번
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
		    		}else{ //RequestTD_ListSearch 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestTD_ListSearch 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//교육훈련일지 상세 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestTD_DetailSearch 교육훈련일지 상세 조회
*******************************************************************************************************************************************************************************/
var RequestTD_DetailSearch = function(){
	this.prop = {
		requestObjectName : 'AppRequestTD_DetailSearch',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			ser : 0,					//
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestTD_DetailSearch 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.language='';

    };
    //RequestTD_DetailSearch 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestTD_DetailSearch request Message를 서버에 요청 하고, ResponseTD_DetailSearch Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.docs.length ; i++ ){
							avv= receivedData.docs[i];					//문서
							avv.ser;					//NO
							avv.name;					//교육명
							avv.date;					//교육일자
							avv.gubun;				//교육구분
							avv.start;				//교육시작시간
							avv.end;					//교육종료시간
							avv.place;				//현장 교육장소
							avv.speaker;				//강사
							avv.method;				//교육방법
							avv.content;				//교육내용
							avv.sign;					//서명
							avv.userid;				//작성자사번
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
		    		}else{ //RequestTD_DetailSearch 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestTD_DetailSearch 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//교육훈련 서명파일_업로드
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestTD_SignfileUpload 교육훈련 서명파일_업로드
*******************************************************************************************************************************************************************************/
var RequestTD_SignfileUpload = function(){
	this.prop = {
		requestObjectName : 'AppRequestTD_SignfileUpload',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			ser : 0,					//
			sign : '',					//서명
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestTD_SignfileUpload 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.sign='';
		this.prop.requestObject.language='';

    };
    //RequestTD_SignfileUpload 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestTD_SignfileUpload request Message를 서버에 요청 하고, ResponseTD_SignfileUpload Message가 recevedData로 리턴받는다.
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
						receivedData.ser;					//
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
		    		}else{ //RequestTD_SignfileUpload 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestTD_SignfileUpload 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
