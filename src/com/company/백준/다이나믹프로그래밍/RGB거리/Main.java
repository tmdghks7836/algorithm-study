package com.company.백준.다이나믹프로그래밍.RGB거리;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int M = in.nextInt();

        int[][] D = new int[M + 1][3];
        int[] R = new int[M + 1];
        int[] G = new int[M + 1];
        int[] B = new int[M + 1];

        for (int i = 1; i <= M; i++) {

            R[i] = in.nextInt();
            G[i] = in.nextInt();
            B[i] = in.nextInt();
        }
        D[1][0] = R[1];
        D[1][1] = G[1];
        D[1][2] = B[1];

        for (int i = 2; i < D.length; i++) {

            D[i][0] = Math.min(D[i - 1][1], D[i - 1][2]) + R[i];
            D[i][1] = Math.min(D[i - 1][0], D[i - 1][2]) + G[i];
            D[i][2] = Math.min(D[i - 1][0], D[i - 1][1]) + B[i];
        }

        int[] ints = D[M];

        int asInt = Arrays.stream(ints).min().getAsInt();
        System.out.println(asInt);
    }
}