package com.company.백준.DFSBFS.미로탐색;

import java.util.*;

public class Main {


    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         * 1은 이동할수있는 칸
         * 0은 이동할수없는 칸
         * 1,1 에서 출발 NM의 위치로 이동할때 지나야하는 최소칸수
         *
         *
         * */

        int y = sc.nextInt();
        int x = sc.nextInt();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int[][] arr = new int[y][x];
        boolean[][] ch = new boolean[y][x];
        for (int i = 0; i < arr.length; i++) {

            String next = sc.next();

            char[] charArray = next.toCharArray();

            for (int j = 0; j < charArray.length; j++) {

                arr[i][j] = charArray[j] - 48;
            }
        }

        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(0,0));
        ch[0][0] = true;
        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Pos poll = queue.poll();

                if(poll.x == arr[0].length -1 && poll.y == arr.length -1) {

                    System.out.println(level);
                    return ;
                }

                for (int j = 0; j < 4; j++) {

                    int moveX = dx[j] + poll.x;
                    int moveY = dy[j] + poll.y;

                    if(moveX < 0 || moveY < 0 || moveX >= arr[0].length || moveY >= arr.length) continue;
                    if(ch[moveY][moveX]) continue;
                    if(arr[moveY][moveX] == 0) continue;

                    ch[moveY][moveX] = true;

                    queue.add(new Pos(moveX, moveY));
                }
            }
            level++;
        }
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

        Main T = new Main();
        T.solution();
    }
}