package com.company.동적계획법.계단오르기;

import java.util.Scanner;

public class Main {

    static int[] arr;

    public static int dynamic(int stair) {

        if (arr[stair] != 0) return arr[stair];
        if (stair == 1) return 1;
        if (stair == 2) return 2;

        arr [stair] = dynamic(stair - 2) + dynamic(stair - 1);

        return arr [stair];
    }

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        arr = new int[n + 1];

        int dynamic = dynamic(n);

        System.out.println(dynamic);
    }
}
