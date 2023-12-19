package com.company.백준.DFSBFS.다리만들기;

import java.util.*;

public class Main {
    int[][] ch;
    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         * */

        int w = sc.nextInt();

        int[][] board = new int[w][w];
        ch = new int[board.length][board[0].length];
        int typeNum = -1;

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                int i1 = sc.nextInt();
                board[i][j] = i1;
            }
        }

        Queue<Candi> queue = new PriorityQueue<>();

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    setIsland(board, i, j, typeNum, queue);
                    typeNum--;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};


        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Candi candi = queue.poll();

                Pos poll = candi.pos;

                for (int od = 0; od < 4; od++) {

                    int moveX = dx[od] + poll.x;
                    int moveY = dy[od] + poll.y;

                    if (moveX < 0 || moveY < 0 || moveX >= w || moveY >= w) continue;

                    int newPrice = candi.price + 1;

                    if (ch[moveY][moveX] < 0 && ch[moveY][moveX] != poll.type) {
                        System.out.println(candi.price + board[moveY][moveX]);
                        return;
                    }

                    if (0 < ch[moveY][moveX] && board[moveY][moveX] <= newPrice) continue;

                    board[moveY][moveX] = newPrice;
                    ch[moveY][moveX] = poll.type;
                    queue.add(new Candi(new Pos(moveX, moveY, poll.type), newPrice));
                }

            }
        }

        System.out.println();
    }

    private void setIsland(int[][] board, int i, int j, int type, Queue<Candi> queue) {

        int[] ox = {-1, 0, 1, 0};
        int[] oy = {0, -1, 0, 1};

        for (int i1 = 0; i1 < 4; i1++) {

            int moveX = ox[i1] + j;
            int moveY = oy[i1] + i;

            if (moveX < 0 || moveY < 0 || moveX >= board[0].length || moveY >= board.length) {
                continue;
            }

            if (board[moveY][moveX] == 1 && ch[moveY][moveX] == 0) {
                queue.add(new Candi(new Pos(moveX, moveY, type), 0));
                ch[moveY][moveX] = type;
                setIsland(board, moveY, moveX, type, queue);
            }

        }

    }

    class Pos {
        int x;
        int y;

        int type;

        public Pos(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    class Candi implements Comparable<Candi> {

        Pos pos;

        int price;

        public Candi(Pos pos, int price) {
            this.pos = pos;
            this.price = price;
        }

        @Override
        public int compareTo(Candi o) {
            return this.price - o.price;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}
/*
[-1, -1, 8, 1, 2, 2, 1, -11, -1, -1]
[-1, ^, -1, ^, 1, 2, 2, 1, -11, -1]
[^, 1, ^, ^, 1, 2, 2, 1, -11, -1]
[1, 1, ^, 1, ^, 1, 2, 2, 1, -11]
[2, 2, 1, ^, 1, 2, X, 2, 1, -11]
[X, X, 2, 1, 2, 2, X, 2, 1, -11]
[X, X, X, 2, 1, 1, 2, X, 2, 1]
[X, X, 2, 1, 12,12,1,2,X, 2]
[X, X, 2, 1, -12, -12, -12, 1, 2, X]
[X, X, X, 2, 1, 1, 1, 2, X, X]*/
