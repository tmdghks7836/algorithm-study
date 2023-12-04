package com.company.etc;

import java.util.Scanner;

public class ArrayMain {

    public Integer solution(Integer[] arr) {
        return null;
    }


    public static void main(String[] args) {

        ArrayMain T = new ArrayMain();

        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();

        Integer[] arr = new Integer[next];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
