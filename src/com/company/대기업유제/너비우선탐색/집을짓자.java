package com.company.대기업유제.너비우선탐색;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class 집을짓자 {

    static class Building {
        int x;
        int y;

        public Building(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][][] ch;

    public int solution(int[][] board) {

        /**
         * n*n크기의 격자정보
         * 1은 빌딩
         * 2는 장애물
         * 0은 빈땅
         *
         * 모든 빌딩에서 이동거리의 합이 최소가 되는 빈땅지점에 집을 짓는다.
         * 이동은 상하좌우 인접한 빈땅으로만 이동가능
         * */
        List<Building> buildings = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    buildings.add(new Building(j, i));
                }
            }
        }

        ch = new int[buildings.size()][board.length][board[0].length];


        //빌딩의 지점으로부터 시작해서 넓게 퍼저가면서 이동거리를 1씩 추가한다.
        for (int i = 0; i < buildings.size(); i++) {

            BFS(board, buildings.get(i), i);
        }

        int answer = -Integer.MAX_VALUE;

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] < 0) {
                    int cnt = 0;
                    for (int[][] ints : ch) {
                        if (ints[i][j] == 1) {
                            cnt++;
                        }
                    }
                    if (cnt == buildings.size())
                        answer = Math.max(board[i][j], answer);
                }
            }
        }

        if(answer == -Integer.MAX_VALUE) return -1;

        return Math.abs(answer);
    }

    private void BFS(int[][] board, Building building, int idx) {

        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, -1, 0, 1};

        Queue<Building> queue = new ArrayDeque<>();
        queue.add(building);
        int level = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Building poll = queue.poll();

                //결과보드에 1을 추가한다.

                for (int j = 0; j < 4; j++) {

                    int x = poll.x + moveX[j];
                    int y = poll.y + moveY[j];

                    //만약 갈수 없는 곳이라면 큐에 집어넣지 않는다.
                    if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) continue;
                    if (ch[idx][y][x] == 1) continue; //기존에 갔엇던 곳이면
                    if (board[y][x] == 1 || board[y][x] == 2) continue; //빈땅이 아니면

                    board[y][x] -= level;
                    ch[idx][y][x] += 1;
                    queue.add(new Building(x, y));
                }
            }

            level++;
        }
    }

    public static void main(String[] args) {
        집을짓자 T = new 집을짓자();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
          System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
// 1 2 0 0
// 0 0 1 2
// 0 2 0 0
// 0 2 1 0