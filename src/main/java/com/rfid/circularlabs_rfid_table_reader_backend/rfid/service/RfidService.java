package com.rfid.circularlabs_rfid_table_reader_backend.rfid.service;

import com.rfid.circularlabs_rfid_table_reader_backend.rfid.request.RfidDataRequestDto;
import com.rfid.circularlabs_rfid_table_reader_backend.rfid.response.RfidDataResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RfidService {

    // 다중 RFID 데이터 한 번에 업로드 service
    public List<RfidDataResponseDto> uploadMultiData(List<RfidDataRequestDto> rfidDataRequestDto) {
        log.info("다중 RFID 데이터 한 번에 업로드 service");

        return rfidDataRequestDto.stream()
                .map(eachRfidData ->
                        RfidDataResponseDto.builder()
                                .epc(eachRfidData.getEpc())
                                .tid(eachRfidData.getTid())
                                .userData(eachRfidData.getUserData())
                                .antenna(eachRfidData.getAntenna())
                                .readCount(eachRfidData.getReadCount())
                                .timeStamp(eachRfidData.getTimeStamp())
                                .build()
                )
                .collect(Collectors.toList());
    }


    // 단일 RFID 데이터 업로드 service
    public RfidDataResponseDto uploadSoloData(RfidDataRequestDto rfidDataRequestDto) {
        log.info("단일 RFID 데이터 업로드 service");

        return RfidDataResponseDto.builder()
                .epc(rfidDataRequestDto.getEpc())
                .tid(rfidDataRequestDto.getTid())
                .userData(rfidDataRequestDto.getUserData())
                .antenna(rfidDataRequestDto.getAntenna())
                .readCount(rfidDataRequestDto.getReadCount())
                .timeStamp(rfidDataRequestDto.getTimeStamp())
                .build();
    }
}
