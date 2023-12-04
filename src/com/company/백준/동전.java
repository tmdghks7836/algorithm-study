package com.company.백준;

import java.util.*;
import java.util.stream.Collectors;

class 동전 {

	public int solution(){

		int answer = 0;
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int money = scanner.nextInt();

		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int coin = scanner.nextInt();

			arr.add( coin);
		}

		Collections.reverse(arr);

		int idx = 0;

		while(money > 0){

			answer += money / arr.get(idx);

			money = money % arr.get(idx);

			idx++;
		}

		return answer;
	}

	public static void main(String[] args){
		동전 T = new 동전();
		System.out.println(T.solution());
	}
}