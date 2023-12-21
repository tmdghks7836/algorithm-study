package com.company.백준.greedy.신입사원;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         *  인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다
         * */
        int casses = sc.nextInt();

        for (int j = 0; j < casses; j++) {
            int num = sc.nextInt();

            int[][] grads = new int[num][2];

            for (int i = 0; i < grads.length; i++) {
                grads[i][0] = sc.nextInt();
                grads[i][1] = sc.nextInt();
            }

            grads = Arrays.stream(grads).sorted(Comparator.comparingInt(o -> o[0])).toArray(int[][]::new);

            int[] low =  grads[0];
            int res = 0;

            for (int i = 1; i < grads.length; i++) {

                if (low[0] < grads[i][0] && low[1] < grads[i][1]) {
//                    System.out.println("버릴사람: " + (i + 1));
                    res++;
                }else{
                    low = grads[i];
                }
            }

            System.out.println(num - res);
        }


    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}