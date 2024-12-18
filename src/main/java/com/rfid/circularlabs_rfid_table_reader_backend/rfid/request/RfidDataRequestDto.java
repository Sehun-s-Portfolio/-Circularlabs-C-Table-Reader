package com.rfid.circularlabs_rfid_table_reader_backend.rfid.request;

import lombok.Getter;

@Getter
public class RfidDataRequestDto {
    private String epc;
    private String tid;
    private String userData;
    private String antenna;
    private int readCount;
    private String timeStamp;
}

