//package com.company.백준.DFSBFS.퍼즐;
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Main {
//
//    public void solution() {
//
//        Scanner sc = new Scanner(System.in);
//
//        /**
//         * */
//
//        int w = sc.nextInt();
//        int h = sc.nextInt();
//
//        int[][] board = new int[3][3];
//        Queue<Pos> queue = new ArrayDeque<>();
//        boolean[][] ch = new boolean[h][w];
//
//        for (int i = 0; i < board.length; i++) {
//
//            for (int j = 0; j < board[i].length; j++) {
//
//                board[i][j] = sc.nextInt();
//                if(board[i][j] == 1)  {
//                    ch[i][j] = true;
//                    queue.add(new Pos(j, i));
//                }
//            }
//        }
//        int[] ox = {-1, 0, 1, 0};
//        int[] oy = {0, -1, 0, 1};
//
//
//        //먼저 말의 움직임으로 이동 가능한지 그리고 인접 칸으로 이동 후 동적계획법
//
//
//
//
//        int days = 0;
//        int currentCnt = 0;
//        while (!queue.isEmpty()) {
//
//            int size = queue.size();
//            boolean checked = false;
//            for (int i = 0; i < size; i++) {
//
//                Pos poll = queue.poll();
//
//                for (int od = 0; od < 4; od++) {
//
//                    int moveX = ox[od] + poll.x;
//                    int moveY = oy[od] + poll.y;
//
//                    if (moveX < 0 || moveY < 0 || moveX >= w || moveY >= h) continue;
//                    if (board[moveY][moveX] == 1) continue;
//                    if (board[moveY][moveX] == -1) continue;
//                    if (ch[moveY][moveX]) continue;
//                    checked = true;
//                    ch[moveY][moveX] = true;
//                    currentCnt++;
//                    queue.add(new Pos(moveX, moveY));
//                }
//
//            }
//            if(checked){
//                days++;
//            }
//        }
//
//        if (targetCnt == currentCnt) {
//            System.out.println(days);
//        } else {
//
//            System.out.println(-1);
//        }
//    }
//
//    class Pos {
//        int x;
//        int y;
//
//        public Pos(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public static void main(String[] args) {
//
//        Main T = new Main();
//        T.solution();
//    }
//}
///*
//0
//4 4
//0 0 0 0
//1 0 0 0
//0 0 1 0
//0 1 0 0
//* */