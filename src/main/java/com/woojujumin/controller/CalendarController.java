package com.woojujumin.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woojujumin.dto.CalendarDto;
import com.woojujumin.service.CalendarService;


@RestController
public class CalendarController {

	@Autowired
	CalendarService service;
	
	// 문자열 검사 : 빈 문자일 때 -> true 빈문자가 아니면 false
	public static boolean nvl(String msg) {
		return msg == null || msg.trim().equals("") ? true : false;
	}

	// 한자리 숫자를 두자리로 만들어주는 함수 : 1 ~ 9 -> 01 ~ 09
	public static String two(String msg) {
		return msg.trim().length() < 2 ? "0" + msg.trim() : msg.trim();
	}

	@PostMapping(value = "/calendarmain")
	public HashMap<String, Object> calendarmain(String sendYear, String sendMonth) {
		System.out.println("CalendarController calendarmain() " + new Date());
		System.out.println("sendYear: "+sendYear);
		System.out.println("sendMonth: "+sendMonth);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1); // 1일로 설정

		// 맨 처음은 빈문자 - 그다음은 계속 넘어 올 것임
		String syear = sendYear;
		String smonth = sendMonth;

		int year = cal.get(Calendar.YEAR);
		if (nvl(syear) == false) { // 넘어온 파라미터가 있다!
			year = Integer.parseInt(syear);
		}

		int month = cal.get(Calendar.MONTH) + 1;
		if (nvl(smonth) == false) {
			month = Integer.parseInt(smonth);
		}

		if (month < 1) {
			month = 12;
			year--;
		}
		if (month > 12) {
			month = 1;
			year++;
		}

		cal.set(year, month - 1, 1);

		// 요일
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		cal.set(Calendar.DATE, lastday);
		int weekday = cal.get(Calendar.DAY_OF_WEEK);
		
		HashMap<String, Object> map = new HashMap<>();

		map.put("dayOfWeek",dayOfWeek);
		map.put("lastday", lastday);
		map.put("weekday", weekday);
		map.put("year", year);
		map.put("month", month);
		
		return map;
	}
	
	@GetMapping(value="/calendarwrite")
	public String calendarwrite(CalendarDto cal) {
		System.out.println("CalendarController calendarwrite() " + new Date());
		System.out.println(cal.toString());
		
		boolean isS = service.calwrite(cal);
		if(isS) return "YES";
		
		return "NO";
	}

}
