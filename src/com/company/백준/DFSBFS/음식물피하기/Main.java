package com.company.백준.DFSBFS.음식물피하기;

import java.util.*;
public class Main {

    public void solution() {

        Scanner sc = new Scanner(System.in);

        int boardY = sc.nextInt();
        int boardX = sc.nextInt();
        int trashCnt = sc.nextInt();

        int[][] arr = new int[boardY][boardX];
        boolean[][] ch = new boolean[boardY][boardX];
        List<Pos> trashPoses = new ArrayList<>();


        for (int i = 0; i < trashCnt; i++) {

            int y = sc.nextInt() -1;
            int x = sc.nextInt() -1;

            arr[y][x] = 1;
            trashPoses.add(new Pos(x, y));
        }

        int result = 0;
        for (Pos trashPose : trashPoses) {

            if(ch[trashPose.y][trashPose.x]) continue;
            ch[trashPose.y][trashPose.x] = true;

            DFS(trashPose.x, trashPose.y, ch, arr);

            result = Math.max(result, temp);
            temp = 1;
        }

        System.out.println(result);
    }
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int temp = 1;

    private void DFS(int x, int y, boolean[][] ch, int[][] arr) {

        for (int i = 0; i < 4; i++) {

            int moveX = dx[i] + x;
            int moveY = dy[i] + y;

            if(moveX < 0 || moveY < 0 || moveX >= arr[0].length || moveY >= arr.length) continue;
            if(arr[moveY][moveX] == 0) continue;
            if(ch[moveY][moveX]) continue;
            ch[moveY][moveX] = true;
            temp++;

            DFS(moveX, moveY, ch, arr);
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