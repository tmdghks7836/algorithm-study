package com.company._3map.중복확인;

import java.util.*;


public class Main {

    public Object solution(int[] arr) {


        Set<Integer> set = new TreeSet<>();

        for (int i : arr) {
            set.add(i);
        }

        return set.size() == arr.length ? "U" : "D";
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
