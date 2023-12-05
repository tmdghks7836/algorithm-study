package com.company.대기업유제.너비우선탐색;

import java.util.*;
class 타일점프 {

	int[] nums;
	public int solution(int[] nums){
		int answer = 0;
		this.nums = nums;
		/**
		 * 집에서 상점까지 자연수가 적혀있는 티일
		 * i번째 타일은 Ai라고 하면 i타일에서 오른쪽으로 Ai만큼 점프 가능
		 * 집에서부터 상점까지의 최소 점프
		 * */

		queue = new ArrayDeque<>();

		return BFS(0);
	}
	Queue<Integer> queue;
	private int BFS(int first) {

		int answer = -1;
		queue.add(first);

		int level = 0;

		while(!queue.isEmpty()){

			int size = queue.size();
			level++;

			for (int i = 0; i < size; i++) {

				Integer poll = queue.poll();
				int num = nums[poll];
				//현재로부터 타일 수만큼 모든 경우의 수를 큐에 집어넣는다.
				//만약 범위를 벗어나거나 도착하면 바로 반환
				for (Integer j = 1; j <= num; j++) {

					if(poll + j < nums.length){

						if(poll + j == nums.length -1){
							return level;
						}
						queue.add(poll + j);
					}
				}
			}
		}

		return answer;
	}

	public static void main(String[] args){
		타일점프 T = new 타일점프();
		System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
		System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
		System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
	}
}