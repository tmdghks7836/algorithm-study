package com.company.etc.DFS.순열구하기;

import java.util.Scanner;


public class Main {

    static int n, m;
    static int[] dist;
    static int[] ch;
    static int[] pm;

    public void DFS(int lev) {

        if (lev == m) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 0; i < dist.length; i++) {

                if(ch[i]==0){
                    ch[i] = 1;
                    pm[lev] =  dist[i];
                    DFS(lev + 1);
                    ch[i] = 0;
                }

            }
        }

    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        dist = new int[n];
        ch = new int[n];
        pm = new int[m];
        for (int i = 0; i < dist.length; i++) {

            dist[i] = in.nextInt();
        }
        T.DFS(0);
    }
}
