package com.company.etc.DFS.중복순열;

import java.util.Scanner;


public class Main {

    static int n, m;
    static int[] dist;

    public void DFS(int lev) {

        if (lev == m) {

            for (int i : dist) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {

                dist[lev] = i;

                DFS(lev + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        dist = new int[m];

        T.DFS(0);
    }
}
