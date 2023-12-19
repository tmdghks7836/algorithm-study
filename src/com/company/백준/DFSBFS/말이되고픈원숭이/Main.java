package com.company.백준.DFSBFS.말이되고픈원숭이;

import java.util.*;

public class Main {

    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         * 말 : 격자판에서 체스 나이트와 같은 이동방식 좌우위아래 2번 연속이동 후 대각선 추가 이동
         * 장애물 뛰어넘을 수 있음
         *
         * 맨 왼쪽에서 오른쪽 아래
         * 네방향으로 한번 , 말의 움직임으로 한번 : 모두 한번의 동작
         * 원숭이가 최소한의 동작으로 도착지점까지 갈 수 있는 방법
         * K
         * W : 가로길이
         * H : 세로길이
         * 0 : 평지
         * 1 : 장애물
         * 갈수없으면 -1
         * */

        int k = sc.nextInt();

        int w = sc.nextInt();
        int h = sc.nextInt();


        int[][] board = new int[h][w];

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {


                board[i][j] = sc.nextInt();

                if(board[i][j] == 0) board[i][j] = Integer.MAX_VALUE;
            }
        }
        board[0][0] = 0;
        int[] ox = {-1, 0, 1, 0};
        int[] oy = {0, -1, 0, 1};


        //먼저 말의 움직임으로 이동 가능한지 그리고 인접 칸으로 이동 후 동적계획법

        Queue<Candidate> queue = new PriorityQueue<>();

        queue.add(new Candidate(new Pos(0, 0), 0, 0));
        HDirection[] hDirections = HDirection.values();

        boolean[][][] ch = new boolean[h][w][k + 1];

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Candidate poll = queue.poll();
                Pos pos = poll.pos;

                if (pos.x == w - 1 && pos.y == h - 1) {
                    System.out.println(poll.value);
                    return;
                }

                int newValue = poll.value + 1;
                for (int od = 0; od < 4; od++) {

                    int moveX = ox[od] + pos.x;
                    int moveY = oy[od] + pos.y;

                    if (moveX < 0 || moveY < 0 || moveX >= w || moveY >= h) continue;
                    if (board[moveY][moveX] == 1) continue;
                    if(ch[moveY][moveX][poll.moveK]) continue;

                    ch[moveY][moveX][poll.moveK] = true;

                    board[moveY][moveX] = newValue;

                    queue.add(new Candidate(new Pos(moveX, moveY), newValue, poll.moveK));
                }

                if (poll.moveK == k) continue;

                for (int hd = 0; hd < hDirections.length; hd++) {

                    int moveX = hDirections[hd].dx + pos.x;
                    int moveY = hDirections[hd].dy + pos.y;

                    if (moveX < 0 || moveY < 0 || moveX >= w || moveY >= h) continue;
                    if (board[moveY][moveX] == 1) continue;
                    if(ch[moveY][moveX][poll.moveK + 1]) continue;

                    ch[moveY][moveX][poll.moveK + 1] = true;

                    board[moveY][moveX] = newValue;

                    queue.add(new Candidate(new Pos(moveX, moveY), newValue, poll.moveK + 1));
                }
            }

        }

        System.out.println(-1);
    }

    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Candidate implements Comparable<Candidate> {

        Pos pos;

        int value;

        int moveK;

        public Candidate(Pos pos, int value, int moveK) {
            this.pos = pos;
            this.value = value;
            this.moveK = moveK;
        }

        @Override
        public int compareTo(Candidate o) {
            return value - o.value;
        }
    }

    enum HDirection {
        U_L(-2, -1),
        U_R(-2, 1),
        L_L(1, -2),
        L_R(-1, -2),
        R_L(-1, 2),
        R_R(1, 2),
        D_L(2, -1),
        D_R(2, 1);


        int dx;
        int dy;

        HDirection(int dy, int dx) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}
/*
0
4 4
0 0 0 0
1 0 0 0
0 0 1 0
0 1 0 0
* */