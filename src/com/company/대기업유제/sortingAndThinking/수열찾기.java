package com.company.대기업유제.sortingAndThinking;

import java.util.*;
class 수열찾기 {
	public int[] solution(int[] nums){
		int[] answer = new int[nums.length / 2];


		for (int num : nums) {

		}


		return answer;
	}

	public static void main(String[] args){
		수열찾기 T = new 수열찾기();
		System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
		System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}
}