package com.company.대기업유제.해싱시간파싱;

import java.util.*;
class 같은빈도수만들기 {
	public int[] solution(String s){
		int[] answer = new int[5];

		HashMap<Character, Integer> map = new HashMap();
		//1. 가장 많은 알파벳 갯수 찾는다.
		char[] charArray = s.toCharArray();
		int max = 0;

		for (char c : charArray) {

			int put = map.getOrDefault(c, 0) + 1;

			map.put(c, put);

			max = Math.max(map.get(c), max) ;
		}

		char[] abcde = new char[]{'a','b','c','d','e'};

		int[] numArr = new int[abcde.length];
		//2. 가장많은 알파벳 갯수만큼 다른 알파벳에 갯수를 맞춘다.

		//2-1 가장많은 알파벳 갯수 - 해당알파벳 갯수를 배열에 넣는다.
		for (int i = 0; i < abcde.length; i++) {

			char c = abcde[i];
			numArr[i] = max - map.getOrDefault(c, 0);
		}

		return numArr;
	}

	public static void main(String[] args){
		같은빈도수만들기 T = new 같은빈도수만들기();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
