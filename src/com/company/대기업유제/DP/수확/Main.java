package com.company.대기업유제.DP.수확;

import java.util.Scanner;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        int valueCnt = sc.nextInt();

        if (valueCnt == 0) return;

        int[] values = new int[valueCnt + 1];
        int[][] space = new int[valueCnt + 1][valueCnt + 1];
        for (int i = 1; i <= valueCnt; i++) {

            int value = sc.nextInt();

            values[i] = value;
            space[i][i] = value;
        }
        int dcreaseI = 1;

        for (int jj = 2; jj < space.length; jj++) {

            int j = jj;

            for (int i = 1; i < space.length - dcreaseI; i++) {

//                System.out.println(i + " : " + j);
                int max = Math.max(space[i][j - 1], space[i + 1][j]);
                int sumCount = 0;

                for (int k = i; k <= j; k++) {
                    sumCount += values[k];
                }

                space[i][j] = max + sumCount;
                j++;
            }
            dcreaseI++;
        }

//        for (int i = 0; i < space.length; i++) {
//
//            System.out.println(Arrays.toString(space[i]));
//        }


        System.out.println(space[1][valueCnt]);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}