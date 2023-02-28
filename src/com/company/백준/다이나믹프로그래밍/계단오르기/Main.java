package com.company.백준.다이나믹프로그래밍.계단오르기;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        int[] stair = new int[M + 1];

        for (int i = 1; i < stair.length; i++) {
            stair[i] = in.nextInt();
        }

        if(M == 1){
            System.out.println(stair[1]);
            return;
        }
        int[][] d = new int[M + 1][3];

        d[1][1] = stair[1];
        d[1][2] = 0;
        d[2][1] = stair[2];
        d[2][2] = stair[1] + stair[2];

        for (int i = 3; i < d.length; i++) {

            d[i][1] = Math.max(d[i - 2][1], d[i - 2][2]) + stair[i];
            d[i][2] = d[i - 1][1] + stair[i];

        }

        System.out.println(Math.max(d[M][1], d[M][2]));
    }
}