package com.company.etc.DFS.바둑이승차;

import java.util.Scanner;
import java.util.Stack;


public class Main {

    static int answer, weight, n;
    static int[] dist;
    static Stack<Integer> stack = new Stack();


    public void DFS(int L, int sum) {

        if (sum > weight) {
            return;
        }

        if (L == n) {

            answer = Math.max(answer, sum);

        } else {

            int i = L + 1;
            DFS(i, sum + dist[L]);
            DFS(i, sum);

        }
    }


    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        weight = in.nextInt();
        n = in.nextInt();
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = in.nextInt();
        }
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
