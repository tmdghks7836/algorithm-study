package com.company.대기업유제.너비우선탐색;

import java.util.*;
class 미로의_최단거리통로 {

	/**격자판 미로 탈출 7*7의 최단경로
	 * 경로의 길이 = 출발점에서 도착점까지 이동한 횟수
	 * 출발점은 1,1 좌표 -> 탈출 도착점 7,7
	 * 1은 벽 , 0은 도로
	 */

	class Pos{
		int x = 0;
		int y = 0;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public int solution(int[][] board){
		int answer = 0;

		boolean[][] ch = new boolean[7][7];
		int[] moveX = { -1, 0, 1, 0};
		int[] moveY = { 0, -1, 0, 1};
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(0,0));
		ch[0][0] = true;
		//bfs를 이용해서 풀이
		//무한반복문
		int level=0;
		while(!queue.isEmpty()){

			int size = queue.size();

			//현재지점에서 이동할수있는 경우의 수를 모두 큐에 넣는다.
			for (int i = 0; i < size; i++) {

				Pos poll = queue.poll();
				if(poll.x == 6 && poll.y == 6){
					return level;
				}

				for (int j = 0; j < 4; j++) {
					int x = moveX[j] + poll.x;
					int y = moveY[j] + poll.y;

					//이동할수 있으면 큐에 더한다. 이전에 갔었던 곳인지,
					if(x >= 0 && x < 7 && y >= 0 && y < 7
					&& !ch[y][x] && board[y][x] == 0){

						ch[y][x] = true;
						queue.add(new Pos(x, y));
					}
				}
			}

			//이동횟수를 1 더한다.
			level++;
		}

		return -1;
	}
		
	public static void main(String[] args){
		미로의_최단거리통로 T = new 미로의_최단거리통로();
		int[][] arr={{0, 0, 0, 0, 0, 0, 0}, 
			{0, 1, 1, 1, 1, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0}, 
			{1, 1, 0, 1, 0, 1, 1}, 
			{1, 1, 0, 1, 0, 0, 0}, 
			{1, 0, 0, 0, 1, 0, 0}, 
			{1, 0, 1, 0, 0, 0, 0}};
		System.out.println(T.solution(arr));
		int[][] array = {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 1, 1, 1, 1, 1, 0},
				{0, 0, 0, 1, 0, 0, 0},
				{1, 1, 0, 1, 1, 1, 1},
				{1, 1, 0, 1, 0, 0, 0},
				{1, 0, 0, 0, 1, 0, 0},
				{1, 0, 1, 0, 1, 0, 0}
		};
		System.out.println(T.solution(array));
	}
}