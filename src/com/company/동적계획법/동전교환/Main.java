package com.company.동적계획법.동전교환;

import java.util.Arrays;
import java.util.Scanner;

//냅색알고리즘
public class Main {

    static int[] dy;
    static int[] coins;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();

        coins = new int[num];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = kb.nextInt();
        }

        int n = kb.nextInt();
        dy = new int[n + 1];

        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;


        for (int i = 0; i < coins.length; i++) {

            int coin = coins[i];

            for (int j = coin; j < dy.length; j++) {

                dy[j] = Math.min(dy[j], dy[j - coin] + 1);
            }
        }

        System.out.println(dy[n]);
    }
}
