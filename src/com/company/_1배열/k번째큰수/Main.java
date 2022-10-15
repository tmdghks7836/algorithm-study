package com.company._1배열.k번째큰수;

import java.util.*;

public class Main {

    public Integer solution(Integer[] arr, int k) {

        Set<Integer> set = new TreeSet<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int ii = j + 1; ii < arr.length; ii++) {
                    set.add(arr[i] + arr[j] + arr[ii]);
                }
            }
        }

        int count = 0;
        for (Integer integer : set) {
            count++;
            if (count == k) {
                return integer;
            }
        }


        return -1;
    }


    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();
        Integer k = in.nextInt();
        Integer[] arr = new Integer[next];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr, k));
    }
}
