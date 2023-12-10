package com.company.대기업유제.그래프;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class 벽허물기 {
    public int solution(int[][] board) {
        int answer = 0;

        /**
         *
         * n * m 격자판 지도
         * 0,0 에서 n-1 m-1 (오른쪽 아래 끝) 이 목표지점
         * 0 : 통로
         * 1: 벽
         * 목표지점까지 가기위해서 허물어야 하는 최소 벽의 개수
         * */

        // 예상 해법:  queue 에서 전부 뽑았을때 목표지점이 아니면 벽을 허문다.
        // 길이 막히면 지금까지 왔던 길의 상하좌우 벽을 모두 허문다.

        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        boolean[][] ch = new boolean[board.length][board[0].length];

        Queue<Pos> queue = new ArrayDeque<>();
        ch[0][0] = true;
        Queue<Pos> best = new ArrayDeque<>();
        best.add(new Pos(0, 0));
        queue.add(new Pos(0, 0));

        int cnt = 0;


        print(board);
        while (true) {

            int size = queue.size();

            List<Pos> walls = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Pos pos = queue.poll();

                best.add(pos);

                //도착했다면 끝
                if (pos.y == board.length - 1 && pos.x == board[0].length - 1) {
                    print(board);
                    return cnt;
                }

                for (int j = 0; j < 4; j++) {

                    int moveX = dx[j] + pos.x;
                    int moveY = dy[j] + pos.y;

                    if (moveX < 0 || moveY < 0 || moveX == board[0].length || moveY == board.length) continue;
                    if (ch[moveY][moveX]) continue;

                    /**
                     * 		 * 0 : 통로
                     * 		 * 1: 벽
                     * 		 위 왼쪽 오른쪽 아래 순서로 돌게끔. 벽을 목적지와 가까운곳으로 저장하기위해.
                     * */
                    if (board[moveY][moveX] == 1) {
                        walls.add(new Pos(moveX, moveY));
                        continue;
                    }
                    ch[moveY][moveX] = true;

                    queue.add(new Pos(moveX, moveY));
                }


            }

            if (queue.isEmpty()) {

                for (Pos pos : best) {

                    for (int j = 0; j <= 3; j++) {

                        int moveX = dx[j] + pos.x;
                        int moveY = dy[j] + pos.y;

                        if (moveX < 0 || moveY < 0 || moveX == board[0].length || moveY == board.length) continue;
                        if (board[moveY][moveX] != 1) continue;
                        ch[moveY][moveX] = true;
                        board[moveY][moveX] = 0;
                        queue.add(new Pos(moveX, moveY));
                    }
                }

                cnt++;
            }
        }


    }

    private static void print(int[][] board) {
//        System.out.println();
//
//        for (int[] ints : board) {
//            for (int anInt : ints) {
//
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }
    }

    class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        벽허물기 T = new 벽허물기();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 1, 0, 1}, {0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}