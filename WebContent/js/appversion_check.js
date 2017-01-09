//버젼 체크
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestVersionCheck 버젼 체크
*******************************************************************************************************************************************************************************/
var RequestVersionCheck = function(){
	this.prop = {
		requestObjectName : 'AppRequestVersionCheck',
		requestObject :{ 
			requestKey : '',			//요청 키
			gubun : '',				//구분
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestVersionCheck 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.gubun='';
		this.prop.requestObject.language='';

    };
    //RequestVersionCheck 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestVersionCheck request Message를 서버에 요청 하고, ResponseVersionCheck Message가 recevedData로 리턴받는다.
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
						receivedData.gubun;				//현장 코드값
						receivedData.version;				//버젼
						receivedData.gps;					//GPS
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
		    		}else{ //RequestVersionCheck 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestVersionCheck 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
