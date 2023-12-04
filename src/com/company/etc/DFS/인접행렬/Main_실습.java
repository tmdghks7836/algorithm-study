package com.company.etc.DFS.인접행렬;

import java.util.Scanner;


public class Main_실습 {

    static int n;
    static int m;
    static int[][] graph;
    static int[] chk;
    static int answer;

    public void DFS(int v) {

        if(v == n){
            answer++;
        }else{

            for (int i = 1; i <= n; i++) {

                if(graph[v][i] == 1 && chk[i] == 0) {
                    chk[i] = 1;
                    DFS(i);
                    chk[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_실습 T = new Main_실습();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        graph = new int[n + 1][n + 1];
        chk = new int[n + 1];

        for (int i = 0; i < m; i++) {

            int i1 = in.nextInt();
            int i2 = in.nextInt();

            graph[i1][i2] = 1;
        }
        chk[1] = 1;
        T.DFS(1);
    }
}
