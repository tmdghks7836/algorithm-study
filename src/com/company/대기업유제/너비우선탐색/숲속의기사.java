package com.company.대기업유제.너비우선탐색;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class 숲속의기사 {

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        /**
         * 영희는 궁전에서 기사가 지키는 숲을 통과해서 나가야함
         * 안전하게 가기위해 기사에게 산딸기를 줘야함
         * 최대한 빨리 기사에게 산딸기를 줘야함
         * 숲의 지도: R * C 판 형태
         * 영희 시작위치, 기사 위치, 산딸기 위치가 표시, 영희가 가지 못하는 위치
         * 영희는 산딸기 없이 기사를 지나쳐갈수없음
         * 동서남북 하루에 한칸씩 이동
         * 영희가 산딸기를 기사에게 가져다주는 가장 짧은 날의 수
         * 0 : 영희가 움직일수 있는곳
         * 1: 영희가 움직일수 없는곳
         * 2. 영희의 시작위치
         * 3: 숲속기사의 위치
         * 4: 산딸기 위치
         *
         * */

        //산딸기 위치 저장
        List<Pos> stroberryList = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == 4) {

                    stroberryList.add(new Pos(j, i));
                }
            }
        }

        for (Pos pos : stroberryList) {

            //* 2. 영희의 시작위치
            int count1 = BFS(pos.y, pos.x, board, 2);

            //* 3: 숲속기사의 위치
            int count2 = BFS(pos.y, pos.x, board, 3);

            answer = Math.min(count1 + count2, answer);
        }

        return answer;
    }

    private static int BFS(int y, int x, int[][] board, int posType) {
        //산딸기 위치들로부터 영희의 최소거리, 기사의 최소거리 BFS 각각 한번씩 돌기

        Queue<Pos> queue = new ArrayDeque<>(); //BFS를 위한 queue

        queue.add(new Pos(x, y));

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        boolean[][] ch = new boolean[board.length][board[0].length];
        int day = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Pos pos = queue.poll(); //현재위치로부터

                if(board[pos.y][pos.x] == posType) return day;

                for (int j = 0; j < 4; j++) { //동서남북 이동

                    int moveX = pos.x + dx[j];
                    int moveY = pos.y + dy[j];

                    if (moveY < 0 || moveX < 0 || moveX >= board[0].length || moveY >= board.length) continue;
                    if(ch[moveY][moveX]) continue;
                    if (board[moveY][moveX] == 1) continue;//1: 영희가 움직일수 없는곳

                    ch[moveY][moveX] = true;
                    queue.add(new Pos(moveX, moveY));
                }
            }

            day++;
        }

        return -1;
    }

    public static void main(String[] args) {
        숲속의기사 T = new 숲속의기사();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
		System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
			{0, 1, 1, 0, 0, 0, 1, 0},
			{0, 1, 4, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0},
			{1, 0, 1, 0, 0, 1, 1, 0},
			{4, 0, 0, 0, 1, 0, 0, 0},
			{4, 1, 0, 0, 1, 0, 0, 0},
			{4, 0, 0, 0, 0, 0, 1, 2}}));
		System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
			{0, 1, 0, 1, 0},
			{0, 0, 2, 3, 4},
			{0, 1, 0, 1, 0}}));
    }
}