package com.company.DFS.인접리스트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main_실습 {

    static int n, m, answer;

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] chk;

    public void DFS(int v) {


        if(v == n){
            answer++;
        }else{

            for (Integer i : graph.get(v)) {

                if (chk[i] == 0) {

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
        chk = new int[n + 1];

        for (int i = 0; i <= n; i++) {

            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {

            int x = in.nextInt();
            int y = in.nextInt();

            graph.get(x).add(y);
        }

        chk[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
