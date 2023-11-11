package com.company.백준.DFSBFS.스타트와링크;


import java.util.*;

public class Main {

    static int[][] map;
    static int N;
    static boolean[] visit;
    static int result = Integer.MAX_VALUE;

    public static void DFS(int index, int count) {

        //조합이 완성되었으면
        if (count >= N / 2) {

            diff();
            return;
        }

        for (int i = index; i < N; i++) {

            visit[i] = true;
            DFS(i + 1, count + 1);
            visit[i] = false;
        }
    }

    private static void diff() {

        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {

                if (visit[i] && visit[j]) {
                    start += map[i][j] + map[j][i];
                }
                if (!visit[i] && !visit[j]) {
                    link += map[i][j] + map[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(start - link));
    }

    //0 1 | 0 2 | 0 3 | 1,2 | 1,3 | 2,3
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();

        map = new int[N][N];
        visit = new boolean[N];

        for (int i1 = 0; i1 < map.length; i1++) {

            for (int i2 = 0; i2 < map[i1].length; i2++) {

                map[i1][i2] = in.nextInt();
            }
        }

        DFS(0, 0);

        System.out.println(result);
    }
}