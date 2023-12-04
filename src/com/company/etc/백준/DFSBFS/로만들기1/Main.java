package com.company.etc.백준.DFSBFS.로만들기1;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] d = new int[1000005];

        d[0] = 0;

        for (int i = 2; i <= n; i++) {

            d[i] = d[i - 1] + 1;
            if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
            if (i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
        }

        System.out.println(d[n]);
    }
}