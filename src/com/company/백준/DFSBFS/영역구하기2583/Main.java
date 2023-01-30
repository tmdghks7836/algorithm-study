package com.company.백준.DFSBFS.영역구하기2583;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] area;
    static int[] xd = {-1, 0, 1, 0};
    static int[] yd = {0, -1, 0, 1};
    static int count = 0;
    static int M;
    static int N;

    public static void DFS(int y, int x) {

        area[y][x] = 1;
        count++;

        for (int i = 0; i < 4; i++) {

            int xdirection = xd[i] + x;
            int ydirection = yd[i] + y;

            if (xdirection >= 0 && ydirection >= 0 && xdirection < N && ydirection < M && area[ydirection][xdirection] == 0) {
                DFS(ydirection, xdirection);
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        M = in.nextInt();
        N = in.nextInt();
        int K = in.nextInt();

        area = new int[M][N];

        for (int i = 0; i < K; i++) {

            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            //1로 초기화
            for (int x = x1; x < x2; x++) {

                for (int y = y1; y < y2; y++) {
                    area[y][x] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int y = 0; y < area.length; y++) {

            for (int x = 0; x < area[y].length; x++) {
                if (area[y][x] == 0) {
                    count = 0;
                    DFS(y, x);
                    list.add(count);
                }
            }
        }

        list.sort(Comparator.comparing(integer -> integer));

        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}