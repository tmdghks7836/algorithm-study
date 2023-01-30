package com.company.DFS.조합구하기;

import java.util.Scanner;


public class Main {

    static int n;
    static int r;
    static int[] dist;

    public void DFS(int L, int num) {

        if (L == r) {
            for (int i : dist) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = num; i <= n; i++) {

                dist[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        r = in.nextInt();
        dist = new int[r];

        T.DFS(0, 1);


    }
}
