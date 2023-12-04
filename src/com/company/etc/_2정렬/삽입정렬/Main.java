package com.company.etc._2정렬.삽입정렬;

import java.util.Scanner;


public class Main {

    public Object solution(int[] arr) {


        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {

                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int start = in.nextInt();

        int[] arr = new int[start];
        for (int i = 0; i < start; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
