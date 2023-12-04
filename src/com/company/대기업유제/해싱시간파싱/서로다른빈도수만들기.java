package com.company.대기업유제.해싱시간파싱;

import java.util.*;
import java.util.stream.Collectors;

class 서로다른빈도수만들기 {
	public int solution(String s){
		int answer = 0;

		HashMap<Character, Integer> map = new HashMap();


		Set<Integer> set = new HashSet<>();

		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		//알파벳 갯수 확인

		//알파벳 갯수가 중복된다면 중복안될때까지 지우기
		List<Character> collect = map.keySet().stream()
				.map(character -> character)
				.collect(Collectors.toList());

		for (char c : collect) {

			while(map.containsKey(c) &&  set.contains(map.get(c)) ){

				if(map.get(c) > 1)
				map.put(c, map.get(c) -1);
				else{
					map.remove(c);
				}
				answer++;
			}

			if(map.containsKey(c))
			set.add(map.get(c));
		}


		return answer;
	}

	public static void main(String[] args){
		서로다른빈도수만들기 T = new 서로다른빈도수만들기();
		System.out.println(T.solution("aaabbbcc"));	
		System.out.println(T.solution("aaabbc"));
		System.out.println(T.solution("aebbbbc"));
		System.out.println(T.solution("aaabbbcccde"));
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));
	}
}