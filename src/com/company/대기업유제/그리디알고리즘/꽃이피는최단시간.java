package com.company.대기업유제.그리디알고리즘;

import java.util.Arrays;

class 꽃이피는최단시간 {

	class Seed implements Comparable<Seed>{

		int plantTime;
		int growTime;

		public Seed(int plantTime, int growTime) {
			this.plantTime = plantTime;
			this.growTime = growTime;
		}

		@Override
		public int compareTo(Seed o) {
			return o.growTime - this.growTime;
		}
	}


	public int solution(int[] plantTime, int[] growTime){
		int answer = 0;

		Seed[] seeds = new Seed[plantTime.length];

		//자라나는 시간이 긴 순서대로 내림차순정렬
		for (int i = 0; i < seeds.length; i++) {

			seeds[i] = new Seed(plantTime[i], growTime[i]);
		}

		Arrays.sort(seeds);

		//시뮬레이션 돌리기

		int totalPlantTime = 0;
		answer = 0;
		for (int i = 0; i < seeds.length; i++) {

			Seed seed = seeds[i];

			totalPlantTime += seed.plantTime;

			//지금까지 심은 시간 + 지금 씨앗의 자라나는시간
			answer = Math.max(totalPlantTime + seed.growTime, answer);
		}




		return answer;
	}

	public static void main(String[] args){
		꽃이피는최단시간 T = new 꽃이피는최단시간();
		System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
		System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
		System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
		System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
		System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
	}
}