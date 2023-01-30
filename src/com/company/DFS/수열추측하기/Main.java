package com.company.DFS.수열추측하기;

import java.util.Scanner;


public class Main {

    static int n;
    static int r;
    static int[] b, p;
    static int[][] dist;
    static int[] ch;
    static boolean found;

    public int sy(int a, int a2) {

        if (a == a2) {
            return 1;
        }
        if (a2 == 0) {
            return 1;
        }

        if (dist[a][a2] == 0) {
            dist[a][a2] = sy(a - 1, a2 - 1) + sy(a - 1, a2);
        }

        return dist[a][a2];
    }

    public void DFS(int L, int sum) {

        if (found) return;
        if (L == n) {
            if (sum == r) {
                for (int i : p) {
                    System.out.print(i + " ");
                }
                found = true;
            }
        } else {

            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {

                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, b[L] * p[L] + sum);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        r = in.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        dist = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = T.sy(n - 1, i);
        }



        T.DFS(0, 0);


    }
}
