package com.company.백준.DFSBFS.알파벳;

import java.util.*;

public class Main {

    int res = 0;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         *
         *
         * */

        int y = sc.nextInt();
        int x = sc.nextInt();



        char[][] arr = new char[y][x];
        for (int i = 0; i < arr.length; i++) {

            String next = sc.next();

            char[] charArray = next.toCharArray();

            for (int j = 0; j < charArray.length; j++) {

                arr[i][j] = charArray[j];
            }
        }

        boolean[][] visit = new boolean[y][x];
        visit[0][0] = true;

        DFS(arr, visit,0,0, arr[0][0] + "");

        System.out.println(res);
    }

    private void DFS(char[][] arr, boolean[][] visit, int x, int y, String word) {

        res = Math.max(res, word.length());

        for (int i = 0; i < 4; i++) {

            int moveX = dx[i] + x;
            int moveY = dy[i] + y;


            if(moveX < 0 || moveY < 0 || moveX >= arr[0].length || moveY >= arr.length) continue;
            if(visit[moveY][moveX]) continue;
            if(word.contains(String.valueOf(arr[moveY][moveX]))) continue;

            visit[moveY][moveX] = true;

            DFS(arr, visit, moveX, moveY,  word + arr[moveY][moveX]);

            visit[moveY][moveX] = false;
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

    class Candidate {

        Pos pos;

        String str;

        public Candidate(Pos pos, String str) {
            this.pos = pos;
            this.str = str;
        }


    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}