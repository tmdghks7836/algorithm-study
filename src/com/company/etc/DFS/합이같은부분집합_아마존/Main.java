package com.company.etc.DFS.합이같은부분집합_아마존;

import java.util.Scanner;
import java.util.Stack;


public class Main {

    static int n;
    static String yon = "NO";
    static int half;
    static int[] dist;
    static Stack<Integer> stack = new Stack();

    public Object solution(int i) {


        DFS(i, dist[i]);

        return yon;
    }

    public void DFS(int L, int sum) {

//        System.out.print(L + ",");
//        System.out.print(sum + " ");
        if (sum == half - sum) {

            for (Integer integer : stack) {
//                System.out.print(integer + " ");
            }
            yon = "YES";
            return;
//            System.out.println("찾았다");
        }

        int next = L + 1;

        if (sum < half && next < dist.length) {

            stack.add(dist[next]);
            DFS(next, sum + dist[next]); //사용한다
            stack.pop();
            DFS(next, sum); //사용 안한다
        } else {
//            System.out.println();
        }

    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        dist = new int[num];
        for (int i = 0; i < num; i++) {
            dist[i] = in.nextInt();
        }
        for (int i : dist) {
            half += i;
        }

        n = num;
        stack.add(dist[0]);
        System.out.println(T.solution(0));
    }
}
