//로그인
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestLogin 로그인
*******************************************************************************************************************************************************************************/
var RequestLogin = function(){
	this.prop = {
		requestObjectName : 'AppRequestLogin',
		requestObject :{ 
			requestKey : '',			//요청 키
			userid : '',				//사용자 아이디
			password : '',			//사용자 암호 *******
			deviceKey : '',			//디바이스 키
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestLogin 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.userid='';
		this.prop.requestObject.password='';
		this.prop.requestObject.deviceKey='';
		this.prop.requestObject.language='';

    };
    //RequestLogin 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestLogin request Message를 서버에 요청 하고, ResponseLogin Message가 recevedData로 리턴받는다.
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
						receivedData.userid;				//사용자 아이디
						receivedData.password;			//사용자 암호 *******
						receivedData.comment;				//로그인 비고
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
		    		}else{ //RequestLogin 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestLogin 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//기기 인증
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestLoginDevice 기기 인증
*******************************************************************************************************************************************************************************/
var RequestLoginDevice = function(){
	this.prop = {
		requestObjectName : 'AppRequestLoginDevice',
		requestObject :{ 
			requestKey : '',			//요청 키
			userid : '',				//사용자 아이디
			password : '',			//사용자 암호 *******
			deviceKey : '',			//디바이스 키
			authKey : '',				//인증 키
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestLoginDevice 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.userid='';
		this.prop.requestObject.password='';
		this.prop.requestObject.deviceKey='';
		this.prop.requestObject.authKey='';
		this.prop.requestObject.language='';

    };
    //RequestLoginDevice 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestLoginDevice request Message를 서버에 요청 하고, ResponseLogin Message가 recevedData로 리턴받는다.
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
						receivedData.userid;				//사용자 아이디
						receivedData.password;			//사용자 암호 *******
						receivedData.comment;				//로그인 비고
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
		    		}else{ //RequestLoginDevice 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestLoginDevice 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부가인증
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestLoginOption 부가인증
*******************************************************************************************************************************************************************************/
var RequestLoginOption = function(){
	this.prop = {
		requestObjectName : 'AppRequestLoginOption',
		requestObject :{ 
			requestKey : '',			//요청 키
			userid : '',				//사용자 아이디
			password : '',			//사용자 암호 *******
			deviceKey : '',			//디바이스 키
			authKey : '',				//인증 키
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestLoginOption 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.userid='';
		this.prop.requestObject.password='';
		this.prop.requestObject.deviceKey='';
		this.prop.requestObject.authKey='';
		this.prop.requestObject.language='';

    };
    //RequestLoginOption 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestLoginOption request Message를 서버에 요청 하고, ResponseLogin Message가 recevedData로 리턴받는다.
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
						receivedData.userid;				//사용자 아이디
						receivedData.password;			//사용자 암호 *******
						receivedData.comment;				//로그인 비고
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
		    		}else{ //RequestLoginOption 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestLoginOption 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
