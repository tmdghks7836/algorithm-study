package com.company.greedy.친구인가;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 서로 각기 다른 배열의 값의 부모를 찾는 느낌이다
 * 1 2 3 4 ...
 * [2 3 4 4] -> 압축하면 [4 4 4 4] 로 공통된 부모인 4를 Find 함수를 통해 같은 집합인 것을 알 수 있다.
 * */
public class Main {

    static int[] unf;

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
            union(a, b);
        }

        int a = kb.nextInt();
        int b = kb.nextInt();

        int fa = Find(a);
        int fb = Find(b);
        System.out.println(fa == fb ? "YES" : "NO");
    }
}
