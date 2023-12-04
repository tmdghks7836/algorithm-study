package com.company.etc.백준.DFSBFS.단지번호붙이기;


import java.util.*;

public class Main {

    static int[][] area;
    static boolean[][] ch;
    static int count;
    static int[] xd = {-1, 0, 1, 0};
    static int[] yd = {0, -1, 0, 1};
    static int N;

    public static void DFS(int y, int x) {

        ch[y][x] = true;
        count++;

        for (int i = 0; i < 4; i++) {

            int xDir = xd[i] + x;
            int yDir = yd[i] + y;

            if (yDir >= 0 && xDir >= 0 && yDir < N && xDir < N && !ch[yDir][xDir]) {

                if(area[yDir][xDir] == 1)
                DFS(yDir, xDir);
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        area = new int[N][N];
        ch = new boolean[N][N];

        for (int i = 0; i < N; i++) {

            String next = in.next();
            for (int i1 = 0; i1 < N; i1++) {
                area[i][i1] = next.charAt(i1) - 48;
                ch[i][i1] = false;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < area.length; i++) {

            for (int j = 0; j < area[i].length; j++) {

                if (area[i][j] == 1 && !ch[i][j]) {
                    count = 0;
                    DFS(i, j);

                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

