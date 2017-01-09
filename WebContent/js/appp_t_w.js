//명일안전작업계획서 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestMSPSearch 명일안전작업계획서 조회
*******************************************************************************************************************************************************************************/
var RequestMSPSearch = function(){
	this.prop = {
		requestObjectName : 'AppRequestMSPSearch',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			work_date : '',			//작업일시
			sub_code : '',			//서브 코드
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestMSPSearch 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.work_date='';
		this.prop.requestObject.sub_code='';
		this.prop.requestObject.language='';

    };
    //RequestMSPSearch 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestMSPSearch request Message를 서버에 요청 하고, ResponseMSPSearch Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.riskReports.length ; i++ ){
							avv= receivedData.riskReports[i];			//위험 보고 목록
							avv.workCode;			//작업코드
							avv.riskFactor;			//위험요인
							for( i = 0 ; i < avv.riskFactors.length ; i++ ){
								bvv= avv.riskFactors[i];			//위험 요인 목록
								bvv.writer;				//작성자
								bvv.comment;				//코멘트
								bvv.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
							}
							avv.riskReductionMeasure;	//위험저감대책
							for( i = 0 ; i < avv.riskReductionMeasures.length ; i++ ){
								bvv= avv.riskReductionMeasures[i];	//위험 저감대책 목록
								bvv.writer;				//작성자
								bvv.comment;				//코멘트
								bvv.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
							}
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
		    		}else{ //RequestMSPSearch 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestMSPSearch 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//업체 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSupconSearch 업체 조회
*******************************************************************************************************************************************************************************/
var RequestSupconSearch = function(){
	this.prop = {
		requestObjectName : 'AppRequestSupconSearch',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			work_date : '',			//작업일시
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSupconSearch 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.work_date='';
		this.prop.requestObject.language='';

    };
    //RequestSupconSearch 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSupconSearch request Message를 서버에 요청 하고, ResponseSupconSearch Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.suppliers.length ; i++ ){
							avv= receivedData.suppliers[i];			//협력업체 목록
							avv.supcode;				//협력업체 코드
							avv.supname;				//협력업체 명
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
		    		}else{ //RequestSupconSearch 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSupconSearch 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
