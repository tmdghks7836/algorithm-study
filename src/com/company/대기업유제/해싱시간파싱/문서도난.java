package com.company.대기업유제.해싱시간파싱;

import java.time.LocalTime;
import java.util.*;
class 문서도난 {
	public String[] solution(String[] reports, String times){
		String[] answer = {};

		HashMap<LocalTime,String> timeMap = new HashMap<>();
		for (int i = 0; i < reports.length; i++) {

			String report = reports[i];
			String[] s = report.split(" ");
			String name = s[0];
			String[] time = s[1].split(":");
			LocalTime localTime = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]) );

			timeMap.put(localTime, name);
		}

		String[] s = times.split(" ");
		String[] start = s[0].split(":");
		String[] end = s[1].split(":");

		LocalTime startTime = LocalTime.of(Integer.parseInt(start[0]) , Integer.parseInt(start[1]));
		LocalTime endTime = LocalTime.of(Integer.parseInt(end[0]) , Integer.parseInt(end[1]));

		List<String> nameList = new ArrayList<>();
		while(endTime.isAfter(startTime) || startTime.equals(endTime) ){

			if(timeMap.containsKey(startTime)){
				nameList.add(timeMap.get(startTime));
			}
			startTime = startTime.plusMinutes(1);
		}

		answer = nameList.toArray(String[]::new);

		return answer;
	}

	//시간을 시:분으로 파싱하는 localTime객체로 만들고 해싱 키로 둔다. 하루 1440분이니까 최대 1440번밖에 안돈다.
	public static void main(String[] args){
		문서도난 T = new 문서도난();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}