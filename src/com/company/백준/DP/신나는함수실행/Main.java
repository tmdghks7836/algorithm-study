package com.company.백준.DP.신나는함수실행;

import java.util.Scanner;

public class Main {

    int[][][] dp = new int[21][21][21];

    public void solution() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(a > 50 || b > 50 || c > 50) continue;

            if (a == -1 && b == -1 && c == -1) return;
            int w = w(a, b, c);

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w);
        }
    }

     int w(int a, int b, int c) {

        // a, b, c가 범위를 벗어나지 않으면서 메모이제이션이 되어있는 경우
        if(inRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if(a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        if(a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}
