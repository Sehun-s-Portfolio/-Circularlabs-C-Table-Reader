package com.rfid.circularlabs_rfid_table_reader_backend.rfid.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rfid.circularlabs_rfid_table_reader_backend.rfid.request.RfidDataRequestDto;
import com.rfid.circularlabs_rfid_table_reader_backend.rfid.response.RfidDataResponseDto;
import com.rfid.circularlabs_rfid_table_reader_backend.rfid.service.RfidService;
import com.rfid.circularlabs_rfid_table_reader_backend.share.ResponseBody;
import com.rfid.circularlabs_rfid_table_reader_backend.share.StatusCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/rfid")
@RestController
public class RfidController {

    private final RfidService rfidService;

    // 다중 RFID 데이터 한 번에 업로드 api
    @PostMapping("/data/multi/upload")
    public ResponseEntity<ResponseBody> uploadMultiData(@RequestBody List<RfidDataRequestDto> rfidDataRequestDto) throws JsonProcessingException {
        log.info("다중 RFID 데이터 한 번에 업로드 api");

        List<RfidDataResponseDto> responseDto = rfidService.uploadMultiData(rfidDataRequestDto);

        StringBuilder checkTotalEpc = new StringBuilder();

        responseDto.forEach(eachRfidData -> {
            String dataLog = eachRfidData.getEpc() + " - READ : " + eachRfidData.getReadCount();
            checkTotalEpc.append("\n" + dataLog);
        });

        log.info("RFID 스캔 다중 데이터 업로드\n {} \n", checkTotalEpc);

        String jsonString = new ObjectMapper().writeValueAsString(responseDto);

        return new ResponseEntity<>(new ResponseBody(StatusCode.OK, jsonString), HttpStatus.OK);
    }


    // RFID 스캔 단일 데이터 즉각 업로드 처리 api
    @PostMapping("/data/solo/upload")
    public ResponseEntity<ResponseBody> uploadSoloData(@RequestBody RfidDataRequestDto rfidDataRequestDto) throws JsonProcessingException {
        log.info("");
        log.info("RFID 스캔 단일 데이터 즉각 업로드 처리 api");
        log.info("EPC : {}", rfidDataRequestDto.getEpc());
        log.info("TID : {}", rfidDataRequestDto.getTid());
        log.info("USER DATA : {}", rfidDataRequestDto.getUserData());
        log.info("ANTENNA : {}", rfidDataRequestDto.getAntenna());
        log.info("READ COUNT : {}", rfidDataRequestDto.getReadCount());
        log.info("TIME STAMP : {}", rfidDataRequestDto.getTimeStamp());

        RfidDataResponseDto responseDto = rfidService.uploadSoloData(rfidDataRequestDto);

        String jsonString = new ObjectMapper().writeValueAsString(responseDto);

        return new ResponseEntity<>(new ResponseBody(StatusCode.OK, jsonString), HttpStatus.OK);
    }
}
