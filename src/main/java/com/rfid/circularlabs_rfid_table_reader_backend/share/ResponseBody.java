package com.rfid.circularlabs_rfid_table_reader_backend.share;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseBody {

    private final String statusMessage; // api 수행 상태 메세지
    private final String statusCode; // api 수행 상태 코드
    private final String data; // api 반환 데이터

    public ResponseBody(StatusCode statusCode, String data){
        this.statusMessage = statusCode.getMessage();
        this.statusCode = statusCode.getCode();
        this.data = data;
    }
}
