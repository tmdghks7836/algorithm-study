package com.company.대기업유제.그래프;

import java.util.*;

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

        PriorityQueue<Pos> queue = new PriorityQueue<>();
        ch[0][0] = true;
        queue.add(new Pos(0, 0,0));

        print(board);
        while (true) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Pos pos = queue.poll();

                //도착했다면 끝
                if (pos.y == board.length - 1 && pos.x == board[0].length - 1) {
                    print(board);
                    return board[pos.y][pos.x];
                }

                for (int j = 0; j < 4; j++) {

                    int moveX = dx[j] + pos.x;
                    int moveY = dy[j] + pos.y;

                    if (moveX < 0 || moveY < 0 || moveX == board[0].length || moveY == board.length) continue;

                    if (ch[moveY][moveX]) continue;

                    board[moveY][moveX] = board[moveY][moveX] + board[pos.y][pos.x];

                    ch[moveY][moveX] = true;
                    queue.add(new Pos(moveX, moveY, board[moveY][moveX]));
                }


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

    class Pos implements Comparable<Pos> {

        int x;
        int y;

        int price;

        public Pos(int x, int y, int price) {
            this.x = x;
            this.y = y;
            this.price = price;
        }

        @Override
        public int compareTo(Pos o) {
            return this.price - o.price;
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