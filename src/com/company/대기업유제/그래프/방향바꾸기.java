package com.company.대기업유제.그래프;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class 방향바꾸기 {
    public int solution(int[][] board) {
        int answer = 0;

        /**
         * n * m 격자판 지도정보
         * 격자판에는 각 1,2,3,4 의 값이 존재
         * 1: 오른쪽의 인접한 격자로 이동
         * 2. 왼쪽의 인접한 격자로 이동
         * 3: 아래로 이동
         * 4: 위로 이동
         * 0,0부터 오른쪽 아래 맨 끝으로 이동하려고함
         * board가 주어지면 목표지점까지 가기위해 방향을 바꾸는 최소 격자 개수
         * 한 격자의 방향은 원하는 방향으로 한번만 바꾸기 가능
         *
         *
         * */

        //다익스트라로 인접 순회 할때마다 내가 그 격자를 바라보고있는지 확인
        //내가 그 격자를 바라보고있으면 1추가 안함 , 바라보지 않으면 1 추가

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        PriorityQueue<Candidate> queue = new PriorityQueue();
        Map<String, Integer> minPosMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                minPosMap.put(j + ":" + i, Integer.MAX_VALUE);
            }
        }

        Pos first = new Pos(0, 0); //첫번째 시작을 넣는다.
        queue.add(new Candidate(first, 0));


        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Candidate candidate = queue.poll();
                Pos pos = candidate.pos;

                if (pos.x == board[0].length - 1 && pos.y == board.length - 1) {
//                    print(board, minPosMap);
                    return candidate.cnt;
                }

                for (int j = 0; j < 4; j++) {

                    int moveX = dx[j] + pos.x;
                    int moveY = dy[j] + pos.y;

                    if (moveX < 0 || moveY < 0 || moveX >= board[0].length || moveY >= board.length) continue;

                    //현재 Pos 가 moveX, moveY 를 바라보고 있는지 체크
                    boolean isLookAt = isLookAt(board[pos.y][pos.x], pos, moveX, moveY);

                    //바라보면 cnt 그대로 바라보지 않으면 cnt++
                    //내가 추가할 값이 기존에 있는 값보다 작아야함
                    Pos newPos = new Pos(moveX, moveY);
                    int cnt;
                    if (isLookAt) {
                        cnt = candidate.cnt;
                    } else {
                        cnt = candidate.cnt + 1;
                    }

                    Integer baseCnt = minPosMap.get(newPos.getName());

                    if (cnt < baseCnt) {
                        minPosMap.put(newPos.getName(), cnt);
                        Candidate newCandi = new Candidate(newPos, cnt);
                        queue.add(newCandi);
                    }
                }

            }
        }

        return answer;
    }

    private static void print(int[][] board, Map<String, Integer> minPosMap) {
        int cnt = 0;
        for (Integer value : minPosMap.values()) {

            System.out.print(value + " ");
            cnt++;

            if (cnt % board[0].length == 0)
                System.out.println();
        }
    }

    private boolean isLookAt(int direction, Pos pos, int moveX, int moveY) {

        int x = pos.x;
        int y = pos.y;
        //         * 1: 오른쪽의 인접한 격자로 이동
        //         * 2. 왼쪽의 인접한 격자로 이동
        //         * 3: 아래로 이동
        //         * 4: 위로 이동
        int[][] directionCalculate = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        return y + directionCalculate[direction - 1][0] == moveY && x + directionCalculate[direction - 1][1] == moveX;
    }


    class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String getName() {
            return x + ":" + y;
        }
    }

    class Candidate implements Comparable<Candidate> {

        Pos pos;
        int cnt;

        public Candidate(Pos pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Candidate o) {
            return cnt - o.cnt;
        }
    }

    public static void main(String[] args) {
        방향바꾸기 T = new 방향바꾸기();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}