package com.company.백준.시뮬레이션.아기상어;

import java.util.*;

public class Main {


    /**
     * N N 공간 1X1한칸
     * 물고기 M 마리
     * 아기상어 1마리
     * 한칸에는 물고기 최대 1마리
     * 아기상어의 크기 2라면 1초에 상하좌우로 인접한 한칸씩 이동
     * 자신보다 큰 물고기칸은 지나갈수없다
     * <p>
     * 크기가 같거나 작은 곳은 이동가능
     * 자신의 크기보다 작은 물고기만 먹는다.
     * <p>
     * 더이상 먹을 물고기가 공간에 없으면 엄마상어에게 도움요청
     * 먹을수 있는 물고기 1마리라면 그물고기 먹으러감
     * 먹을 수 있는 물고기가 1마리보다 많으면 거리가 가장 가까운 물고기 먹으러감
     * 아기상어가 있는 칸에서 물고기가 있는 칸으로 이동할때 지나야 하는 칸의 개수의 최소값
     * 거리가 가까운 물고기가 많으면 가장 위, 왼쪽에 있는 물고기를 먹는다.
     * <p>
     * 자신의 크기와 같은 수의 물고기를 먹을때마다 크기가 1 증가함
     */

    class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Fish {

        public Pos pos;

        public int level;

        public Fish(Pos pos, int level) {
            this.pos = pos;
            this.level = level;
        }
    }

    public class Shark extends Fish {

        int exp = 0;

        public Shark(Pos pos, int level) {
            super(pos, level);
        }

        //         *      * 자신의 크기와 같은 수의 물고기를 먹을때마다 크기가 1 증가함 */
        public void eat(Fish choice) {

            board[choice.pos.y][choice.pos.x] = 0;
            exp++;
            if (exp == level) {
                exp = 0;
                level++;
            }
        }

        /* /**
         *      * 더이상 먹을 물고기가 공간에 없으면 엄마상어에게 도움요청
         *      * 먹을수 있는 물고기 1마리라면 그물고기 먹으러감
         *      * 먹을 수 있는 물고기가 1마리보다 많으면 거리가 가장 가까운 물고기 먹으러감
         *      * 아기상어가 있는 칸에서 물고기가 있는 칸으로 이동할때 지나야 하는 칸의 개수의 최소값
         *      * 거리가 가까운 물고기가 많으면 가장 위, 왼쪽에 있는 물고기를 먹는다.
         *      *
         */
        public void grow() {

        }
    }

    int[][] board;

    public void solution() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        board = new int[N][N];

        Shark shark = null;
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                int val = sc.nextInt();
                board[i][j] = val;

                if (val == 9) {
                    shark = new Shark(new Pos(j, i), 2);
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] ch = new boolean[N][N];
        assert shark != null;
        board[shark.pos.y][shark.pos.x] = 0;
        ch[shark.pos.y][shark.pos.x] = true;
        queue.add(shark.pos);

        int realTime = 0;

        int time = 0;

        while (!queue.isEmpty()) {

            Fish choice = null;

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Pos pos = queue.poll();

                for (int j = 0; j < 4; j++) {

                    int moveX = dx[j] + pos.x;
                    int moveY = dy[j] + pos.y;

                    if (moveX < 0 || moveY < 0 || moveX >= N || moveY >= N) continue;
                    if (ch[moveY][moveX]) continue;
                    ch[moveY][moveX] = true;

                    int fishLevel = board[moveY][moveX];
                    if (fishLevel > shark.level) continue;

                    choice = find(moveY, moveX, shark, choice);

                    if (choice == null) {
                        queue.add(new Pos(moveX, moveY));
                    }
                }
            }

            time++;

            if (choice != null) {
                ch = new boolean[N][N];
                queue.clear();
                shark.eat(choice);
                queue.add(choice.pos);
                ch[choice.pos.y][choice.pos.x] = true;
//                System.out.println(choice.pos.y + " " + choice.pos.x + " " + time + " 초 level : " + shark.level);
                realTime = time;
            }
        }


        System.out.println(realTime);
    }

    private Fish find(int i, int j, Shark shark, Fish choice) {

        int fishLevel = board[i][j];
        if (fishLevel != 0 && fishLevel < shark.level) {

            Fish fish = new Fish(new Pos(j, i), fishLevel);
            Pos fishPos = fish.pos;

            if (choice == null) {
                choice = fish;
                return choice;
            }

            if (choice.pos.y > fishPos.y) {
                choice = fish;
                return choice;
            }

            if (choice.pos.y == fishPos.y && choice.pos.x > fishPos.x) {
                choice = fish;
                return choice;
            }

        }
        return choice;
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}