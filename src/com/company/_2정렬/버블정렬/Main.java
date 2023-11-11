package com.company._2정렬.버블정렬;

import java.util.Scanner;


public class Main {

    public Object solution(int[] arr) {


        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if(arr[j] > arr[j + 1]){
                    int temp = arr[j + 1];
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

        int[] arr= new int[start];
        for (int i = 0; i < start; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
