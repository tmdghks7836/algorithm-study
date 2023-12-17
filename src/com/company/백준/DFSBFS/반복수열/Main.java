package com.company.백준.DFSBFS.반복수열;

import java.util.*;

public class Main {


    /**
     * D[1] = A:57
     * D[n] = D[n-1]의 각 자리의 숫자를 P번 곱한 수들의 합
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        long num = sc.nextInt();
        int P = sc.nextInt();

        System.out.println(DFS(num, P, 0, new HashMap<>()));

    }

    private int DFS(long num, int P, int L, Map<Long, Integer> map) {

        if(map.containsKey(num)) return map.get(num) ;

        map.put(num, L);

        long score = 0;
        while (num > 0) {

            long i = num % 10;

            num = num / 10;

            score += Math.pow(i, P);
        }

        return DFS(score, P, L + 1, map);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}