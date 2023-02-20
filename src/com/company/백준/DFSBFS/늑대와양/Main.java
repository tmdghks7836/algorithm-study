package com.company.백준.DFSBFS.늑대와양;


import java.util.*;

public class Main {

    static char[][] area;
    static int[] xd = {-1, 0, 1, 0};
    static int[] yd = {0, -1, 0, 1};
    static boolean check[][];
    static int count = 1;
    static int R;
    static int C;

    public static void DFS(int y, int x) {


    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        R = in.nextInt();
        C = in.nextInt();

        area = new char[R][C];
        check = new boolean[R][C];

        //1로 초기화
        for (int y = 0; y < R; y++) {

            String str = in.next();
            for (int x = 0; x < C; x++) {

                area[y][x] = str.charAt(x);
            }
        }

        for (int y = 0; y < area.length; y++) {

            for (int x = 0; x < area[y].length; x++) {
                if (area[y][x] == 'W') {
                    check[y][x] = true;
                    DFS(y, x);
                    check[y][x] = false;
                }
            }
        }

        System.out.println(count);
        for (char[] chars : area) {

            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }
}