package com.company.최대매출;

import java.util.Scanner;

public class Main {

    public Integer solution(Integer[] arr, int num) {

        Integer result = 0;

        for (int i = 0; i < num; i++) {

            result += arr[i];
        }
        Integer start = result;

        for (int i = 0; i < arr.length - num - 1; i++) {

            start = start - arr[i] + arr[i + num];

            result = Math.max(result, start);
        }

        return result;
    }


    public static void main(String[] args) {

        Main T = new Main();
        int a;
        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();
        Integer next2 = in.nextInt();
        Integer[] arr = new Integer[next];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr, next2));
    }
}
