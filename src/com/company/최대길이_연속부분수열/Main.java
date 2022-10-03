package com.company.최대길이_연속부분수열;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Main {

    public Object solution(Integer[] numArr, int k) {
        int result = 0;
        int rt = 0;
        int lt = 0;
        for (int i = 0; i < numArr.length - 1; i++) {

            rt++;
            if (numArr[i] == 0) {

                if (k > 0) {
                    k--;
                } else {
                    result = Math.max(result, (rt - 1) - lt);
//                    System.out.println(result + " " + rt + " - " + lt);
                    while (numArr[lt] != 0) {
                        lt++;
                    }
                    lt++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();
        Integer num = in.nextInt();
        Integer[] arr = new Integer[next];

        for (Integer i = 0; i < next; i++) {

            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr, num));
    }
}
