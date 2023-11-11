package com.company.DFS.섬나라아일랜드;

import java.util.Scanner;


public class Main {

    static int n;
    static int[][] map;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int result = 0;

    public void DFS(int y, int x) {

        for (int i = 0; i < dx.length; i++) {

            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newY < 0 || newX < 0 || newY > n - 1 || newX > n - 1) continue;
            if (map[newY][newX] == 1) {
                map[newY][newX] = 0;
                DFS(newY, newX);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 1) {
                    result++;
                    map[i][j] = 0;
                    T.DFS(i, j);
                }
            }
        }

        System.out.println(result);
    }
}
