//부적합 보고서 리스트 조회 후 결과리턴
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRList 부적합 보고서 리스트 조회 후 결과리턴
*******************************************************************************************************************************************************************************/
var RequestSCRList = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRList',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			date : '',					//작업일시
			work : '',					//작업
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRList 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.date='';
		this.prop.requestObject.work='';
		this.prop.requestObject.language='';

    };
    //RequestSCRList 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRList request Message를 서버에 요청 하고, ResponseSCRList Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.ncrList.length ; i++ ){
							avv= receivedData.ncrList[i];				//NCR 목록
							avv.sitecode;			//현장코드
							avv.userid;				//작성자
							avv.sitename;			//현장명
							avv.yymm;					//작성일자
							avv.ser;					//작성NO
							avv.issueDate;			//부적합보고서 발행일
							avv.title;				//문서제목
							avv.supplierName;		//협력업체명
							avv.insid;				//작성자사번
							avv.writer;				//작성자
							avv.SMS;					//SMS발송여부(True/False) True인 경우는 수정 불가, False인 경우 수정 가능
							avv.STATUS;				//수신상태(0:문자미발송작성중, 1: 발송완료, 2: 수신문서)
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
		    		}else{ //RequestSCRList 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRList 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합보고서 수신부서 
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRReceiveDeptList 부적합보고서 수신부서 
*******************************************************************************************************************************************************************************/
var RequestSCRReceiveDeptList = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRReceiveDeptList',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			date : '',					//작업일시
			work : '',					//작업
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRReceiveDeptList 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.date='';
		this.prop.requestObject.work='';
		this.prop.requestObject.language='';

    };
    //RequestSCRReceiveDeptList 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRReceiveDeptList request Message를 서버에 요청 하고, ResponseSCRReceiveDeptList Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.supplier.length ; i++ ){
							avv= receivedData.supplier[i];			//협력업체 목록
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
		    		}else{ //RequestSCRReceiveDeptList 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRReceiveDeptList 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합보고서 발행부서 
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRIssueDeptList 부적합보고서 발행부서 
*******************************************************************************************************************************************************************************/
var RequestSCRIssueDeptList = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRIssueDeptList',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			date : '',					//작업일시
			work : '',					//작업
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRIssueDeptList 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.date='';
		this.prop.requestObject.work='';
		this.prop.requestObject.language='';

    };
    //RequestSCRIssueDeptList 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRIssueDeptList request Message를 서버에 요청 하고, ResponseSCRIssueDeptList Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.departments.length ; i++ ){
							avv= receivedData.departments[i];			//협력업체 목록
							avv.code;					//부서 코드
							avv.name;					//부서 명
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
		    		}else{ //RequestSCRIssueDeptList 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRIssueDeptList 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//직원 조직도 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCREmployeeList 직원 조직도 조회
*******************************************************************************************************************************************************************************/
var RequestSCREmployeeList = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCREmployeeList',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			date : '',					//작업일시
			work : '',					//작업
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCREmployeeList 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.date='';
		this.prop.requestObject.work='';
		this.prop.requestObject.language='';

    };
    //RequestSCREmployeeList 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCREmployeeList request Message를 서버에 요청 하고, ResponseSCREmployeeList Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.organs.length ; i++ ){
							avv= receivedData.organs[i];				//조직 목록
							avv.gubun;				//소속부서1
							avv.buso;					//소속부서2
							avv.lotnam;				//사용자
							avv.usridn;				//사번
							avv.usrnam;				//이름
							avv.usrlem;				//직위
							avv.usrpho;				//휴대전화번호
							avv.supcde;				//사업자등록번호
							avv.upmcde;				//직책코드
							avv.upmnam;				//직책명
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
		    		}else{ //RequestSCREmployeeList 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCREmployeeList 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//상세데이터 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRView 상세데이터 조회
*******************************************************************************************************************************************************************************/
var RequestSCRView = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRView',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			yymm : '',					//
			ser : 0,					//문서 NO
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRView 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.yymm='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.language='';

    };
    //RequestSCRView 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRView request Message를 서버에 요청 하고, ResponseSCRView Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.ncrList.length ; i++ ){
							avv= receivedData.ncrList[i];				//부적합보고서 목록
							avv.sitecode;			//현장코드
							avv.userid;				//작성자
							avv.sitename;			//현장명
							avv.yymm;					//작성일자
							avv.ser;					//작성NO
							avv.issueDate;			//작성일자
							avv.title;				//문서제목
							avv.recvDept;			//수신부서
							avv.publishDept;			//발행부서
							avv.contents;			//문서내용
							avv.rules;				//관련규정 - 추가
							for( i = 0 ; i < avv.photos.length ; i++ ){
								bvv= avv.photos[i];				//첨부파일 목록
								bvv.data;					//사진
								bvv.dataType;			//사진파일타입
								bvv.fileName;			//사진파일명
								bvv.lat;					//위치경도
								bvv.lon;					//위치위도
								bvv.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
							}
								avv.voice.data;					//음성
								avv.voice.dataType;			//음성파일타입
								avv.voice.fileName;			//음성파일명
								avv.voice.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
							avv.posx;					//위치경도
							avv.posy;					//위치위도
							avv.subcon;				//협력업체결재자
							avv.subconnm;			//협력업체결재자
							avv.subconpho;			//협력업체연락처
							avv.subcondate;			//협력업체확인시간 -추가
							avv.gonggujang;			//공구장결재자
							avv.gonggujangnm;		//공구장결재자
							avv.gonggujangpho;	//공구장연락처
							avv.gonggujangdate;	//공구장확인시간 -추가
							avv.sojang;				//소장결재자
							avv.sojangnm;			//소장결재자
							avv.sojangpho;			//소장연락처
							avv.sojangdate;			//소장확인시간 -추가
							avv.sms;					//SMS전송여부
							avv.ins_dt;				//작성시간 -추가
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
		    		}else{ //RequestSCRView 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRView 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합 보고서 리스트 저장 후 결과리턴
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRRegister 부적합 보고서 리스트 저장 후 결과리턴
*******************************************************************************************************************************************************************************/
var RequestSCRRegister = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRRegister',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			date : '',					//작업일시
			userid : '',				//사용자 아이디
			doc : {					//부적합보고서
				sitecode : '',			//현장코드
				userid : '',				//작성자
				sitename : '',			//현장명
				yymm : '',					//작성일자
				ser : 0,					//작성NO
				issueDate : '',			//작성일자
				title : '',				//문서제목
				recvDept : '',			//수신부서
				publishDept : '',			//발행부서
				contents : '',			//문서내용
				rules : '',				//관련규정 - 추가
				photos : [],				//첨부파일 목록
				voice : {				//음성 녹음
					data : '',					//음성
					dataType : '',			//음성파일타입
					fileName : '',			//음성파일명
					language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
				},
				posx : '',					//위치경도
				posy : '',					//위치위도
				subcon : '',				//협력업체결재자
				subconnm : '',			//협력업체결재자
				subconpho : '',			//협력업체연락처
				subcondate : '',			//협력업체확인시간 -추가
				gonggujang : '',			//공구장결재자
				gonggujangnm : '',		//공구장결재자
				gonggujangpho : '',	//공구장연락처
				gonggujangdate : '',	//공구장확인시간 -추가
				sojang : '',				//소장결재자
				sojangnm : '',			//소장결재자
				sojangpho : '',			//소장연락처
				sojangdate : '',			//소장확인시간 -추가
				sms : false,					//SMS전송여부
				ins_dt : '',				//작성시간 -추가
				writer : '',				//작성자
				language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
			},
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRRegister 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.date='';
		this.prop.requestObject.userid='';
			this.prop.requestObject.doc.sitecode='';
			this.prop.requestObject.doc.userid='';
			this.prop.requestObject.doc.sitename='';
			this.prop.requestObject.doc.yymm='';
				this.prop.requestObject.doc.ser=0;
			this.prop.requestObject.doc.issueDate='';
			this.prop.requestObject.doc.title='';
			this.prop.requestObject.doc.recvDept='';
			this.prop.requestObject.doc.publishDept='';
			this.prop.requestObject.doc.contents='';
			this.prop.requestObject.doc.rules='';
			for( i = 0 ; i < this.photos.length ; i++ ){
				this_avv= this.photos[i];
				this_avv.data='';
				this_avv.dataType='';
				this_avv.fileName='';
					this_avv.lat=0;
					this_avv.lon=0;
				this_avv.language='';
			}
				this.prop.requestObject.doc.voice.data='';
				this.prop.requestObject.doc.voice.dataType='';
				this.prop.requestObject.doc.voice.fileName='';
				this.prop.requestObject.doc.voice.language='';
			this.prop.requestObject.doc.posx='';
			this.prop.requestObject.doc.posy='';
			this.prop.requestObject.doc.subcon='';
			this.prop.requestObject.doc.subconnm='';
			this.prop.requestObject.doc.subconpho='';
			this.prop.requestObject.doc.subcondate='';
			this.prop.requestObject.doc.gonggujang='';
			this.prop.requestObject.doc.gonggujangnm='';
			this.prop.requestObject.doc.gonggujangpho='';
			this.prop.requestObject.doc.gonggujangdate='';
			this.prop.requestObject.doc.sojang='';
			this.prop.requestObject.doc.sojangnm='';
			this.prop.requestObject.doc.sojangpho='';
			this.prop.requestObject.doc.sojangdate='';
				this.prop.requestObject.doc.sms=false;
			this.prop.requestObject.doc.ins_dt='';
			this.prop.requestObject.doc.writer='';
			this.prop.requestObject.doc.language='';
		this.prop.requestObject.language='';

    };
    //RequestSCRRegister 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRRegister request Message를 서버에 요청 하고, ResponseSCRRegister Message가 recevedData로 리턴받는다.
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
						receivedData.yymm;					//
						receivedData.ser;					//문서 NO
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
		    		}else{ //RequestSCRRegister 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRRegister 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합 보고서 리스트 업데이트 후 결과리턴
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCREdit 부적합 보고서 리스트 업데이트 후 결과리턴
*******************************************************************************************************************************************************************************/
var RequestSCREdit = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCREdit',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			date : '',					//작업일시
			doc : {					//부적합보고서
				sitecode : '',			//현장코드
				userid : '',				//작성자
				sitename : '',			//현장명
				yymm : '',					//작성일자
				ser : 0,					//작성NO
				issueDate : '',			//작성일자
				title : '',				//문서제목
				recvDept : '',			//수신부서
				publishDept : '',			//발행부서
				contents : '',			//문서내용
				rules : '',				//관련규정 - 추가
				photos : [],				//첨부파일 목록
				voice : {				//음성 녹음
					data : '',					//음성
					dataType : '',			//음성파일타입
					fileName : '',			//음성파일명
					language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
				},
				posx : '',					//위치경도
				posy : '',					//위치위도
				subcon : '',				//협력업체결재자
				subconnm : '',			//협력업체결재자
				subconpho : '',			//협력업체연락처
				subcondate : '',			//협력업체확인시간 -추가
				gonggujang : '',			//공구장결재자
				gonggujangnm : '',		//공구장결재자
				gonggujangpho : '',	//공구장연락처
				gonggujangdate : '',	//공구장확인시간 -추가
				sojang : '',				//소장결재자
				sojangnm : '',			//소장결재자
				sojangpho : '',			//소장연락처
				sojangdate : '',			//소장확인시간 -추가
				sms : false,					//SMS전송여부
				ins_dt : '',				//작성시간 -추가
				writer : '',				//작성자
				language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
			},
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCREdit 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.date='';
			this.prop.requestObject.doc.sitecode='';
			this.prop.requestObject.doc.userid='';
			this.prop.requestObject.doc.sitename='';
			this.prop.requestObject.doc.yymm='';
				this.prop.requestObject.doc.ser=0;
			this.prop.requestObject.doc.issueDate='';
			this.prop.requestObject.doc.title='';
			this.prop.requestObject.doc.recvDept='';
			this.prop.requestObject.doc.publishDept='';
			this.prop.requestObject.doc.contents='';
			this.prop.requestObject.doc.rules='';
			for( i = 0 ; i < this.photos.length ; i++ ){
				this_avv= this.photos[i];
				this_avv.data='';
				this_avv.dataType='';
				this_avv.fileName='';
					this_avv.lat=0;
					this_avv.lon=0;
				this_avv.language='';
			}
				this.prop.requestObject.doc.voice.data='';
				this.prop.requestObject.doc.voice.dataType='';
				this.prop.requestObject.doc.voice.fileName='';
				this.prop.requestObject.doc.voice.language='';
			this.prop.requestObject.doc.posx='';
			this.prop.requestObject.doc.posy='';
			this.prop.requestObject.doc.subcon='';
			this.prop.requestObject.doc.subconnm='';
			this.prop.requestObject.doc.subconpho='';
			this.prop.requestObject.doc.subcondate='';
			this.prop.requestObject.doc.gonggujang='';
			this.prop.requestObject.doc.gonggujangnm='';
			this.prop.requestObject.doc.gonggujangpho='';
			this.prop.requestObject.doc.gonggujangdate='';
			this.prop.requestObject.doc.sojang='';
			this.prop.requestObject.doc.sojangnm='';
			this.prop.requestObject.doc.sojangpho='';
			this.prop.requestObject.doc.sojangdate='';
				this.prop.requestObject.doc.sms=false;
			this.prop.requestObject.doc.ins_dt='';
			this.prop.requestObject.doc.writer='';
			this.prop.requestObject.doc.language='';
		this.prop.requestObject.language='';

    };
    //RequestSCREdit 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCREdit request Message를 서버에 요청 하고, ResponseSCREdit Message가 recevedData로 리턴받는다.
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
						receivedData.yymm;					//
						receivedData.ser;					//문서 NO
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
		    		}else{ //RequestSCREdit 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCREdit 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합보고서 문자전송
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRSendSMS 부적합보고서 문자전송
*******************************************************************************************************************************************************************************/
var RequestSCRSendSMS = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRSendSMS',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			yymm : '',					//
			ser : 0,					//문서 NO
			subconpho : '',			//협력업체 폰
			gonggujangpho : '',	//공구장 폰
			sojangpho : '',			//소장 폰
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRSendSMS 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.yymm='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.subconpho='';
		this.prop.requestObject.gonggujangpho='';
		this.prop.requestObject.sojangpho='';
		this.prop.requestObject.language='';

    };
    //RequestSCRSendSMS 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRSendSMS request Message를 서버에 요청 하고, ResponseSCRSendSMS Message가 recevedData로 리턴받는다.
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
		    		}else{ //RequestSCRSendSMS 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRSendSMS 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합보고서 삭제
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRDelete 부적합보고서 삭제
*******************************************************************************************************************************************************************************/
var RequestSCRDelete = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRDelete',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			yymm : '',					//
			ser : 0,					//문서 NO
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRDelete 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.yymm='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.language='';

    };
    //RequestSCRDelete 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRDelete request Message를 서버에 요청 하고, ResponseSCRDelete Message가 recevedData로 리턴받는다.
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
						receivedData.userid;				//사용자 아이디
						receivedData.yymm;					//
						receivedData.ser;					//문서 NO
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
		    		}else{ //RequestSCRDelete 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRDelete 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합 보고서 이미지 저장 후 결과리턴
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRRegisterImage 부적합 보고서 이미지 저장 후 결과리턴
*******************************************************************************************************************************************************************************/
var RequestSCRRegisterImage = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRRegisterImage',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			yymm : '',					//
			ser : 0,					//문서 NO
			photos : [],				//사진
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRRegisterImage 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.yymm='';
			this.prop.requestObject.ser=0;
		for( i = 0 ; i < this.photos.length ; i++ ){
			this_avv= this.photos[i];
			this_avv.data='';
			this_avv.dataType='';
			this_avv.fileName='';
				this_avv.lat=0;
				this_avv.lon=0;
			this_avv.language='';
		}
		this.prop.requestObject.language='';

    };
    //RequestSCRRegisterImage 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRRegisterImage request Message를 서버에 요청 하고, ResponseSCRRegisterImage Message가 recevedData로 리턴받는다.
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
						receivedData.userid;				//사용자 아이디
						receivedData.yymm;					//
						receivedData.ser;					//문서 NO
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
		    		}else{ //RequestSCRRegisterImage 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRRegisterImage 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합 보고서 음성 저장 후 결과리턴
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRRegisterVoice 부적합 보고서 음성 저장 후 결과리턴
*******************************************************************************************************************************************************************************/
var RequestSCRRegisterVoice = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRRegisterVoice',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			yymm : '',					//
			ser : 0,					//문서 NO
			voice : {				//음성 녹음
				data : '',					//음성
				dataType : '',			//음성파일타입
				fileName : '',			//음성파일명
				language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
			},
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRRegisterVoice 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.yymm='';
			this.prop.requestObject.ser=0;
			this.prop.requestObject.voice.data='';
			this.prop.requestObject.voice.dataType='';
			this.prop.requestObject.voice.fileName='';
			this.prop.requestObject.voice.language='';
		this.prop.requestObject.language='';

    };
    //RequestSCRRegisterVoice 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRRegisterVoice request Message를 서버에 요청 하고, ResponseSCRRegisterVoice Message가 recevedData로 리턴받는다.
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
						receivedData.userid;				//사용자 아이디
						receivedData.yymm;					//
						receivedData.ser;					//문서 NO
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
		    		}else{ //RequestSCRRegisterVoice 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRRegisterVoice 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합 보고서 조치결과 저장
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRRegisterJochi 부적합 보고서 조치결과 저장
*******************************************************************************************************************************************************************************/
var RequestSCRRegisterJochi = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRRegisterJochi',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			yymm : '',					//
			ser : 0,					//문서 NO
			contents : '',			//조치 내용
			photos : [],				//사진
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRRegisterJochi 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.yymm='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.contents='';
		for( i = 0 ; i < this.photos.length ; i++ ){
			this_avv= this.photos[i];
			this_avv.data='';
			this_avv.dataType='';
			this_avv.fileName='';
				this_avv.lat=0;
				this_avv.lon=0;
			this_avv.language='';
		}
		this.prop.requestObject.language='';

    };
    //RequestSCRRegisterJochi 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRRegisterJochi request Message를 서버에 요청 하고, ResponseSCRRegisterJochi Message가 recevedData로 리턴받는다.
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
						receivedData.userid;				//사용자 아이디
						receivedData.yymm;					//
						receivedData.ser;					//문서 NO
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
		    		}else{ //RequestSCRRegisterJochi 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRRegisterJochi 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합 보고서 조치 후 이미지 저장 후 결과리턴
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRRegisterImageJochi 부적합 보고서 조치 후 이미지 저장 후 결과리턴
*******************************************************************************************************************************************************************************/
var RequestSCRRegisterImageJochi = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRRegisterImageJochi',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			yymm : '',					//
			ser : 0,					//문서 NO
			contents : '',			//조치 내용
			photos : [],				//사진
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRRegisterImageJochi 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.yymm='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.contents='';
		for( i = 0 ; i < this.photos.length ; i++ ){
			this_avv= this.photos[i];
			this_avv.data='';
			this_avv.dataType='';
			this_avv.fileName='';
				this_avv.lat=0;
				this_avv.lon=0;
			this_avv.language='';
		}
		this.prop.requestObject.language='';

    };
    //RequestSCRRegisterImageJochi 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRRegisterImageJochi request Message를 서버에 요청 하고, ResponseSCRRegisterImageJochi Message가 recevedData로 리턴받는다.
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
						receivedData.userid;				//사용자 아이디
						receivedData.yymm;					//
						receivedData.ser;					//문서 NO
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
		    		}else{ //RequestSCRRegisterImageJochi 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRRegisterImageJochi 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합 보고서 조치결과 상세데이터 조회
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRViewJochi 부적합 보고서 조치결과 상세데이터 조회
*******************************************************************************************************************************************************************************/
var RequestSCRViewJochi = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRViewJochi',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			yymm : '',					//
			ser : 0,					//문서 NO
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRViewJochi 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.yymm='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.language='';

    };
    //RequestSCRViewJochi 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRViewJochi request Message를 서버에 요청 하고, ResponseSCRViewJochi Message가 recevedData로 리턴받는다.
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
						for( i = 0 ; i < receivedData.ncrList.length ; i++ ){
							avv= receivedData.ncrList[i];				//부적합 보고서 조치결과 목록
							avv.sitecode;			//현장코드
							avv.sitename;			//현장명
							avv.writer;				//작성자
							avv.writernm;			//작성자
							avv.issuedate;			//작성일자
							avv.title;				//문서제목
							avv.recvDept;			//수신부서
							avv.publishDept;			//발행부서
							avv.contents;			//문서내용
							avv.rules;				//관련규정 - 추가
							avv.writedate;			//작성일자
							for( i = 0 ; i < avv.photos.length ; i++ ){
								bvv= avv.photos[i];				//사진
								bvv.data;					//사진
								bvv.dataType;			//사진파일타입
								bvv.fileName;			//사진파일명
								bvv.lat;					//위치경도
								bvv.lon;					//위치위도
								bvv.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
							}
							avv.language;			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")
						}
						receivedData.userid;				//사용자 아이디
						receivedData.sitecode;			//현장 코드값
						receivedData.yymm;					//
						receivedData.ser;					//문서 NO
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
		    		}else{ //RequestSCRViewJochi 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRViewJochi 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합보고서 조치결과 데이터,이미지 삭제
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRDeleteJochi 부적합보고서 조치결과 데이터,이미지 삭제
*******************************************************************************************************************************************************************************/
var RequestSCRDeleteJochi = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRDeleteJochi',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			yymm : '',					//
			ser : 0,					//문서 NO
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRDeleteJochi 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.yymm='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.language='';

    };
    //RequestSCRDeleteJochi 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRDeleteJochi request Message를 서버에 요청 하고, ResponseSCRDeleteJochi Message가 recevedData로 리턴받는다.
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
						receivedData.userid;				//사용자 아이디
						receivedData.sitecode;			//현장 코드값
						receivedData.yymm;					//
						receivedData.ser;					//문서 NO
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
		    		}else{ //RequestSCRDeleteJochi 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRDeleteJochi 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
//부적합보고서 조치결과 데이터 삭제
/*******************************************************************************************************************************************************************************
Mobile HSE , 2015.09 RequestSCRDeleteJochiContents 부적합보고서 조치결과 데이터 삭제
*******************************************************************************************************************************************************************************/
var RequestSCRDeleteJochiContents = function(){
	this.prop = {
		requestObjectName : 'AppRequestSCRDeleteJochiContents',
		requestObject :{ 
			requestKey : '',			//요청 키
			sitecode : '',			//현장 코드값
			userid : '',				//사용자 아이디
			yymm : '',					//
			ser : 0,					//문서 NO
			language : '',			//모바일 사용자가 선택한 언어(한국어="ko",영어="en")

		}
	};
	//RequestSCRDeleteJochiContents 오브젝트 초기화
	this.init = function(){
		this.prop.requestObject.requestKey=(new IDGenerator()).generate();
		this.prop.requestObject.sitecode='';
		this.prop.requestObject.userid='';
		this.prop.requestObject.yymm='';
			this.prop.requestObject.ser=0;
		this.prop.requestObject.language='';

    };
    //RequestSCRDeleteJochiContents 오브젝트를 json string로 변환
    this.toString = function(){
    	return JSON.stringify( this.prop );
    };
    this.request = function( onSuccessResponse , onFailResponse ){
    	//RequestSCRDeleteJochiContents request Message를 서버에 요청 하고, ResponseSCRDeleteJochiContents Message가 recevedData로 리턴받는다.
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
						receivedData.userid;				//사용자 아이디
						receivedData.sitecode;			//현장 코드값
						receivedData.yymm;					//
						receivedData.ser;					//문서 NO
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
		    		}else{ //RequestSCRDeleteJochiContents 요청이 서버에 전송되었고, 처리중 실패(처리 부적합)로 판단하여 리턴 
		    			onFailResponse(receivedData, setting);
		    		}
		    	}
		    },
		    "onError":	function(errorCode, errorMessage, setting) { //RequestSCRDeleteJochiContents 요청이 서버와 연결중 네트워크 또는 기타 오류...
		        M.tool.log( "onError", errorCode, errorMessage );
		    	alert( "onError, " + errorCode + ", " + errorMessage );
		    }
		});
    };
}
