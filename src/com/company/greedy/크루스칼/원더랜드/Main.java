package com.company.greedy.크루스칼.원더랜드;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * */
public class Main {

    static List<Edge> list = new ArrayList<>();
    static int[] unf;

    public static class Edge implements Comparable<Edge>{

        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static int Find(int v) {

        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void union(int a, int b) {

        int first = Find(a);
        int second = Find(b);

        if(first != second) unf[first] = second;
    }

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int value = kb.nextInt();

            list.add(new Edge(a, b, value));
        }

        Collections.sort(list);
        int answer = 0;

        for (Edge edge : list) {

            int fa = Find(edge.start);
            int fb = Find(edge.end);

            if(fa != fb){
                union(fa, fb);
                answer += edge.value;
            }
        }

        System.out.println(answer);
    }
}
