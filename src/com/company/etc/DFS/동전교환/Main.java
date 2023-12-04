package com.company.etc.DFS.동전교환;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {

    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] arr) {

        if(answer <= L) return;
        if (sum > m) return;
        if (sum == m) {

            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, arr[i] + sum, arr);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);


        n = in.nextInt();

        Integer[] dist = new Integer[n];

        for (int i = 0; i < n; i++) {

            dist[i] = in.nextInt();
        }
        Arrays.sort(dist, Collections.reverseOrder());
        m = in.nextInt();
        T.DFS(0, 0, dist);

        System.out.println(answer);
    }
}
