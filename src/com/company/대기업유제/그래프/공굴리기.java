package com.company.대기업유제.그래프;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class 공굴리기 {
    public int solution(int[][] board, int[] s, int[] e) {

        /**
         * n * m 격자판
         * 0은 빈공간 1은 벽
         *
         * 공은 격자의 상하 좌우 네방향으로 빈공간을 이동할수있음 벽을 만나면 멈춘다.
         * s 공의 위치
         * e 공의 목표지점
         * 목표위치까지 최단거리 ㄱ
         * 목표지점까지 도달못하면 -1
         *
         * */
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        PriorityQueue<Candidate> queue = new PriorityQueue<Candidate>();
        Map<String, Integer> minPosMap = new HashMap<>();

        Pos first = new Pos(s[1], s[0]);

        for (int i = 0; i < 4; i++) {
            queue.add(new Candidate(first, 0, i));
        }


        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Candidate candi = queue.poll();
                Pos poll = candi.pos;

                //벽을 만나지 않았으면 가던 방향으로 계속 이동
                if(!candi.frontWall(board, dx, dy)){
                    Pos newPos = new Pos(candi.pos.x + dx[candi.direction], candi.pos.y + dy[candi.direction]);
                    Candidate newCandi = new Candidate(newPos, candi.cnt + 1, candi.direction);
                    Integer basePrice = minPosMap.getOrDefault(newPos.getName(), Integer.MAX_VALUE);

                    if (basePrice < newCandi.cnt) continue;

                    queue.add(newCandi);
                    minPosMap.put(newPos.getName(), newCandi.cnt);
                }else{   //벽을 만나면 그때 방향 돌리기

                    //벽을 만났을때만 목표지점 체크하기
                    if (poll.x == e[1] && poll.y == e[0]) {
                      //  print(board);
                        return minPosMap.getOrDefault(poll.getName(), Integer.MAX_VALUE);
                    }

                    for (int j = 0; j < 4; j++) {

                        int moveX = dx[j] + poll.x;
                        int moveY = dy[j] + poll.y;

                        if (moveX < 0 || moveY < 0 || moveX >= board[0].length || moveY >= board.length) continue;
                        //         * 0은 빈공간 1은 벽
                        if(board[moveY][moveX] == 1) continue;

                        Pos newPos = new Pos(moveX, moveY);
                        Candidate newCandi = new Candidate(newPos, candi.cnt + 1, j);
                        Integer basePrice = minPosMap.getOrDefault(newPos.getName(), Integer.MAX_VALUE);

                        if (basePrice < newCandi.cnt) continue;

                        queue.add(newCandi);
                        minPosMap.put(newPos.getName(), newCandi.cnt);
                    }
                }
            }

        }



        return -1;
    }

    public void print(int[][] board){

        for (int i = 0; i < board.length; i++) {

            for (int j : board[i]) {

                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String getName() {
            return x + "" + y;
        }

    }

    class Candidate implements Comparable<Candidate> {

        Pos pos;

        int cnt;

        int direction;

        public Candidate(Pos pos, int cnt, int direction) {
            this.pos = pos;
            this.cnt = cnt;
            this.direction = direction;
        }

        public boolean frontWall(int[][] board, int[] dx, int[] dy){

            int moveX = dx[direction] + pos.x;
            int moveY = dy[direction] + pos.y;

            if (moveX < 0 || moveY < 0 || moveX >= board[0].length || moveY >= board.length) return true;
            //         * 0은 빈공간 1은 벽
            if(board[moveY][moveX] == 1) return true;

            return false;
        }

        @Override
        public int compareTo(Candidate o) {
            return this.cnt - o.cnt;
        }
    }


    public static void main(String[] args) {
        공굴리기 T = new 공굴리기();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}

