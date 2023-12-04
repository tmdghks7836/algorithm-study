package com.company.대기업유제.해싱시간파싱;

import java.util.*;
import java.util.stream.Collectors;

class 회장선거 {

	public String solution(String[] votes, int k){
		String answer = " ";
		Map<String, Integer> recomands = new HashMap<>();

		//학생들을 map으로 변환
		Map<String, Set<String>> collect = Arrays.stream(votes)
				.map(s -> s.split(" "))
				.collect(Collectors.groupingBy(o -> o[0], Collectors.mapping(o -> o[1], Collectors.toSet())));

		//k번 이상 추첨된 학생들 확인
		collect.values()
				.stream()
				.flatMap(strings -> strings.stream())
				.forEach(string -> recomands.put(string, recomands.getOrDefault(string,0) + 1));


		Map<String, Integer> gift = recomands.entrySet()
				.stream().filter(s -> s.getValue() >= k)
				.collect(Collectors.toMap(o -> o.getKey(), o -> o.getValue()));

		Map<String, Integer> result = new HashMap<>();
		//학생들을 loop 돌린다
		collect.entrySet().stream()
				.forEach(stringSetEntry -> {

					//선물을 줘야 할 학생인지 검사하고 맞으면 학생의 선물에 +1
					stringSetEntry.getValue().stream().forEach(s ->
					{
						if(gift.containsKey(s)){
							result.put(stringSetEntry.getKey(), result.getOrDefault(stringSetEntry.getKey(),0) + 1);
						}
					});
				});

		List<Map.Entry<String, Integer>> collect1 = result.entrySet().stream().collect(Collectors.toList());

		Collections.sort(collect1, (o1, o2) -> {
			int compare = o2.getValue().compareTo(o1.getValue());
			if (compare == 0) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return compare;
		});
		return collect1.get(0).getKey();
	}

	public static void main(String[] args){
		회장선거 T = new 회장선거();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}