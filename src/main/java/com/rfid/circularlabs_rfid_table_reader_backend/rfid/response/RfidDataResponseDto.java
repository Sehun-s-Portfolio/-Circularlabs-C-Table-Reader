package com.rfid.circularlabs_rfid_table_reader_backend.rfid.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RfidDataResponseDto {
    private String epc;
    private String tid;
    private String userData;
    private String antenna;
    private int readCount;
    private String timeStamp;
}

