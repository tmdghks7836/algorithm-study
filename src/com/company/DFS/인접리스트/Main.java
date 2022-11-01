package com.company.DFS.인접리스트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static int n, m, answer = 0;
    static List<List<Integer>> graph;
    static int[] ch;

    public void DFS(int v) {

        if(v==n){
            answer++;
        }else{
            for (int i : graph.get(v)) {
                if(ch[i]==0){
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<>();
        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {

            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}
