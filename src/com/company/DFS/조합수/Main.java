package com.company.DFS.조합수;

import java.util.Scanner;


public class Main {

    static int n, r;
    static int[][] dist;

    public int DFS(int a, int b) {

        if(a == b) return 1;
        if(b == 0) return 1;

        if(dist[a][b] == 0){
            dist[a][b] = DFS(a - 1, b - 1) + DFS(a - 1, b);
        }

        return dist[a][b];
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        r = in.nextInt();
        dist = new int[n + 1][r + 1];

        int dfs = T.DFS(n, r);

        System.out.println(dfs);
    }
}
