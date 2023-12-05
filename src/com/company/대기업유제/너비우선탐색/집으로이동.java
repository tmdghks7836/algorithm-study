package com.company.대기업유제.너비우선탐색;

import java.util.*;
import java.util.stream.Collectors;

class 집으로이동 {
	public int solution(int[] pool, int a, int b, int home){
		int answer = 0;


		/**
		 * 놀이터에서 놀다가 집으로간다.
		 * 놀이터 집 위치는 수직선 좌표로 되어잇음
		 * 점프 규칙
		 * 1. 앞쪽으로 a만큼 이동한다
		 * 2. 뒤쪽으로 b만큼 이동한다.
		 * 3. 뒤쪽으로는 1번만 가능
		 * 4. 점프하는 곳 웅덩이 좌표가 있으면 이동 불가
		 *
		 * */
		Queue<Man> queue = new ArrayDeque<>();

		Set<Integer> poolSet = new HashSet<>();
		for (int i : pool) {
			poolSet.add(i);
		}

		int level = 0;

		queue.offer(new Man(false, 0));

		while(!queue.isEmpty()){

			int size = queue.size();

			/**
			 * 		 * 1. 앞쪽으로 a만큼 이동한다
			 * 		 * 2. 뒤쪽으로 b만큼 이동한다.
			 * 		 * 3. 뒤쪽으로는 1번만 가능
			 * 		 * 4. 점프하는 곳 웅덩이 좌표가 있으면 이동 불가*/
			for (int i = 0; i < size; i++) {

				Man poll = queue.poll();

				if(poll.position == home){
					return level;
				}
				Man front = new Man(false, poll.position + a);
				Man back = new Man(true, poll.position - b);

				if(!poolSet.contains(front.position) && front.position < 10000){
					queue.add(front);
				}
				if(!poolSet.contains(back.position) && back.position >= 0){
					if(!poll.moveBack){
						queue.offer(back);
					}
				}
			}

			level++;
		}

		return -1;
	}

	class Man {

		boolean moveBack;
		int position ;

		public Man(boolean moveBack, int position) {
			this.moveBack = moveBack;
			this.position = position;
		}
	}


	public static void main(String[] args){
		집으로이동 T = new 집으로이동();
		System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));	
		System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));	
		System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));	
		System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));	
		System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));	
	}
}