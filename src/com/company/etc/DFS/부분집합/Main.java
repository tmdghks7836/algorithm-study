package com.company.etc.DFS.부분집합;

import java.util.Scanner;


public class Main {

    static int n;
    static int[] ch;
    static int cnt;

    public Object solution(int i) {


        DFS(i);

        return "";
    }

    public void DFS(int L) {

        cnt++;
        if (L == n + 1) {

            for (int i = 1; i < ch.length; i++) {
                if (ch[i] == 1) {
                    System.out.print((i) + " ");
                }
            }
            System.out.println();
        } else {
            ch[L] = 1;
            DFS(L + 1); //사용한다
            ch[L] = 0;
            DFS(L + 1); //사용 안한다
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        ch = new int[i + 1];
        n = i;
        T.solution(1);
        System.out.println(cnt);
    }
}
