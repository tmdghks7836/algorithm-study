package com.company.백준.DFSBFS.유기농배추;

import java.util.*;

public class Main {

    public void solution() {

        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for (int tk = 0; tk < testcase; tk++) {

            int result = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();

            int cabbage = sc.nextInt();

            int[][] arr = new int[y][x];
            List<CabbagePos> cabbagePosList = new ArrayList<>();

            boolean[][] ch = new boolean[y][x];

            for (int i = 0; i < cabbage; i++) {
                int bx = sc.nextInt();
                int by = sc.nextInt();

                arr[by][bx] = 1;
                cabbagePosList.add(new CabbagePos(bx, by));
            }

            for (int i = 0; i < cabbagePosList.size(); i++) {

                CabbagePos cabbagePos = cabbagePosList.get(i);

                if(ch[cabbagePos.y][cabbagePos.x]) continue;
                ch[cabbagePos.y][cabbagePos.x] = true;

                result++;
                DFS(cabbagePos.y, cabbagePos.x, ch, arr);
            }

            System.out.println(result);
        }
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    private void DFS(int y, int x, boolean[][] ch, int[][] arr) {


        for (int i = 0; i < 4; i++) {

            int moveX = dx[i] + x;
            int moveY = dy[i] + y;

            if(moveX < 0 || moveY < 0 || moveX >= arr[0].length || moveY >= arr.length) continue;

            if(arr[moveY][moveX] == 0) continue;
            if(ch[moveY][moveX]) continue;

            ch[moveY][moveX] = true;

            DFS(moveY, moveX, ch, arr);
        }
    }
    class CabbagePos{

        int x;
        int y;

        public CabbagePos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}