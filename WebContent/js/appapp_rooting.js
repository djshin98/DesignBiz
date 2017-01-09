//앱 루팅 탐지 정보 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestAppInitialize 앱 루팅 탐지 정보 조회
*******************************************************************************************************************************************************************************/
var RequestAppInitialize = function(){
	this.prop = {
		requestObjectName : 'AppRequestAppInitialize',
		requestObject :{ 
			requestKey : '',			//요청 키
			devicePlatform : '',	//안드로이드는 android , 아이폰은 ios 
			deviceKey : '',			//각 디바이스 키 정보
			os : '',					//operating system 명
			osversion : '',			//디바이스 의 OS 버젼 정보
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestAppInitialize 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.devicePlatform='';
		this.prop.requestObject.deviceKey='';
		this.prop.requestObject.os='';
		this.prop.requestObject.osversion='';
		this.prop.requestObject.language='';

    };
    //RequestAppInitialize 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestAppInitialize request Message를 서버에 요청 하고, ResponseAppInitialize Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.targets.length ; i++ ){
							avv= receivedData.targets[i];				//
							avv.target;				//루팅 감지 PATH , FILE 명
							avv.minVersion;			//적용 가능한 최소 버젼
							avv.maxVersion;			//적용 가능한 최대 버젼
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
		    		}else{ //RequestAppInitialize 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestAppInitialize 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
