package com.company.백준.DFSBFS.탈출;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         *
         *티떱숲의 지도는 R행 C열
         * 비어있는 곳은 '.'로
         * , 물이 차있는 지역은 '*',
         * 돌은 'X'
         * 비버의 굴은 'D'로
         * 고슴도치의 위치는 'S'
         *
         * 매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동
         * 물도 매 분마다 비어있는 칸으로 확장
         *
         * 물과 고슴도치는 돌을 통과할 수 없다.
         *  또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고,
         *   물도 비버의 소굴로 이동할 수 없다.
         *
         *    다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다.
         * */

        int y = sc.nextInt();
        int x = sc.nextInt();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        char[][] arr = new char[y][x];
        boolean[][] ch = new boolean[y][x];
        Queue<Pos> queue = new ArrayDeque<>();
        Queue<Pos> water = new ArrayDeque<>();
        Pos target = null;
        for (int i = 0; i < arr.length; i++) {

            String next = sc.next();

            char[] charArray = next.toCharArray();

            for (int j = 0; j < charArray.length; j++) {

                arr[i][j] =  charArray[j];

                if (arr[i][j] == 'S') {
                    ch[i][j] = true;
                    queue.add(new Pos(j,i, arr[i][j]));
                }
                if (arr[i][j] == '*') {
                    water.add(new Pos(j,i, arr[i][j]));
                }
                if (arr[i][j] == 'D') {
                    target = new Pos( j,i, arr[i][j]);
                }
            }
        }



        int level = 0;

        while (!queue.isEmpty()) {

            int ws = water.size();

            for (int i = 0; i < ws; i++) {

                Pos w = water.poll();
                extracted(dx, w, dy, arr, ch, water);
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Pos poll = queue.poll();
                if (poll.type == 'S' && poll.x == target.x && poll.y == target.y) {

                    System.out.println(level);
                    return;
                }
                extracted(dx, poll, dy, arr, ch, queue);
            }
            level++;
        }

        System.out.println("KAKTUS");

    }

    private void extracted(int[] dx, Pos poll, int[] dy, char[][] arr, boolean[][] ch, Queue<Pos> queue) {
        for (int j = 0; j < 4; j++) {

            int moveX = dx[j] + poll.x;
            int moveY = dy[j] + poll.y;

            if (moveX < 0 || moveY < 0 || moveX >= arr[0].length || moveY >= arr.length) continue;
            if (ch[moveY][moveX]) continue;
            if(arr[moveY][moveX] == 'X'){
                continue;
            }
            if(poll.type == '*' && arr[moveY][moveX] == 'D') {
                continue;
            }
            ch[moveY][moveX] = true;

            queue.add(new Pos(moveX, moveY, poll.type));
        }
    }

    class Pos {

        int x;
        int y;

        char type;

        public Pos(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}