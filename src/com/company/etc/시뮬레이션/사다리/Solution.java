package com.company.etc.시뮬레이션.사다리;

import java.util.*;
class Solution {

	int max;
	int[][] map;

	public char[] solution(int n, int[][] ladder){

		this.max = n;
		char[] answer = new char[n];

		map = new int[ladder.length +1][max + 1];

		for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[i].length; j++) {

				int order = ladder[i][j];
				map[i][order] = 1;

			}
		}

		for (int i = 1; i <= max; i++) {
			ride(i);
		}

		for (int i = 1; i <= max; i++) {

			int i1 = map[ladder.length][i];
			answer[i -1] = (char)(i1 + 64);
		}
		return answer;
	}

	public void ride(int startOrder){

		int order = startOrder;
		for (int i = 0; i < map.length -1; i++) {

			if(map[i][order - 1] == 1){
				order--;
			} else if(map[i][order] == 1){
				order++;
			}
		}

		map[map.length -1][order] = startOrder;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
		System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
		System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
		System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
	}
}
/**
 * answer
 * 5
 * [[1, 3], [2, 4], [1, 4]]
 * ['D', 'B', 'A', 'C', 'E']
 * 7
 * [[1, 3, 5], [1, 3, 6], [2, 4]]
 * ['A', 'C', 'B', 'F', 'D', 'G', 'E']
 * 8
 * [[1, 5], [2, 4, 7], [1, 5, 7], [2, 5, 7]]
 * ['C', 'A', 'B', 'F', 'D', 'E', 'H', 'G']
 * 12
 * [[1, 5, 8, 10], [2, 4, 7], [1, 5, 7, 9, 11], [2, 5, 7, 10], [3, 6, 8, 11]]
 * ['C', 'A', 'F', 'B', 'D', 'I', 'E', 'K', 'G', 'L', 'J', 'H']*/