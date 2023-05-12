package com.woojujumin.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

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
	public HashMap<String, Object> calendarmain(String sendYear, String sendMonth, String sendYyyymm) {
		System.out.println("CalendarController calendarmain() " + new Date());
		System.out.println("sendYear: "+sendYear);
		System.out.println("sendMonth: "+sendMonth);
		System.out.println("넘어온 값 yyyymm : " + sendYyyymm);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1); // 1일로 설정

		// 맨 처음은 빈문자 - 그다음은 계속 넘어 올 것임
		String syear = sendYear;
		String smonth = sendMonth;
		String syyyymm = sendYyyymm;

		int year = cal.get(Calendar.YEAR);
		if (nvl(syear) == false) { // 넘어온 파라미터가 있다!
			year = Integer.parseInt(syear);
		}

		int month = cal.get(Calendar.MONTH) + 1;
		if (nvl(smonth) == false) {
			month = Integer.parseInt(smonth);
		}
		
		String yyyymm = year + two(month+"");
		if(nvl(syyyymm) == false) {
			yyyymm = syyyymm;
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
		
		List<CalendarDto> calDto = service.getCalendarList(yyyymm);
		
		map.put("list",calDto);
		
		return map;
	}
	
//	// 일정 불러오기 230417 - 그냥 main으로 이동 
//	@GetMapping(value="/calendarlist")
//	public List<CalendarDto> getCalendarList(String yyyymm){
//		System.out.println("CalendarController getCalendarList() " + new Date());
//		System.out.println("넘어온 값 yyyymm : " + yyyymm);
//		
//		List<CalendarDto> calDto = service.getCalendarList(yyyymm);
//		
//		return calDto;
//	}
	
	// 일정 추가 230414
	@GetMapping(value="/calendarwrite")
	public String calendarwrite(CalendarDto cal) {
		System.out.println("CalendarController calendarwrite() " + new Date());
		System.out.println(cal.toString());
		
		boolean isS = service.calwrite(cal);
		if(isS) return "YES";
		
		return "NO";
	}
	
	
	// 일정 상세보기 230417
	@PostMapping(value="/calendardetail")
	public CalendarDto caldetail(int calSeq) {
		System.out.println("CalendarController caldetail() " + new Date());
		System.out.println("넘어온 값 calSeq : " + calSeq);
		
		return service.caldetail(calSeq);
	}
	
	// 날짜 선택하면 일정 리스트 보기 230418
	@GetMapping(value="/calendarlist")
	public List<CalendarDto> calendarlist(CalendarDto cal){
		System.out.println("CalendarController calendarlist() " + new Date());
		System.out.println("넘어온 값 cal : " + cal);
		
		return service.getDayList(cal);
	}
	
	// 일정 수정하기 230418
	@GetMapping(value="/calendarupdate")
	public String calupdate(CalendarDto cal) {
		System.out.println("CalendarController calupdate() " + new Date());
		System.out.println("넘어온 값 cal : " + cal);
		
		boolean isS = service.calupdate(cal);
		if(isS) return "YES";
		return "NO";
	}
	
	// 일정 삭제하기 230419
	@GetMapping(value="/calendardelete")
	public String caldelete(int calSeq) {
		System.out.println("CalendarController caldelete() " + new Date());
		System.out.println("넘어온 값 calSeq : " + calSeq);
		
		boolean isS = service.caldelete(calSeq);
		if(isS) return "YES";
		return "NO";
	}
	//일정검색(Front)
	@GetMapping(value = "getDayListFront")
	public List<CalendarDto> getDayListFront(String rdate){
		System.out.println("CalendarController getDayListFront() " + new Date());
		System.out.println("넘어온 값 rdate : " + rdate);

		return service.getDayListFront(rdate);
	}
	
	// 총 개수 가져오기
	@GetMapping(value="listcount")
	public int listcount(String rdate) {
		System.out.println("CalendarController listcount() " + new Date());
		System.out.println("넘어온 값 rdate : " + rdate);
		
		return service.listcount(rdate);
	}
	
	
}
