package com.rfid.circularlabs_rfid_table_reader_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class CircularlabsRfidTableReaderBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircularlabsRfidTableReaderBackEndApplication.class, args);
		System.out.println("APPLICATION ACTIVATE");
		String year = String.valueOf(LocalDateTime.now().getYear());

		// 제품이 생성될 때 자동으로 생성될 제품 구분 코드
		StringBuilder classificationCode = new StringBuilder();

		classificationCode.append(year.substring(2));

		if (LocalDateTime.now().getMonthValue() < 10) {
			String addMonthClassificationCode = "0" + LocalDateTime.now().getMonthValue();
			classificationCode.append(addMonthClassificationCode);
		} else {
			classificationCode.append(LocalDateTime.now().getMonthValue());
		}

		if (LocalDateTime.now().getDayOfMonth() < 10) {
			String addDatClassificationCode = "0" + LocalDateTime.now().getDayOfMonth();
			classificationCode.append(addDatClassificationCode);
		} else {
			classificationCode.append(LocalDateTime.now().getDayOfMonth());
		}

		System.out.println(classificationCode);
	}

}
