package com.company.etc._1배열.장난꾸러기;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public Object solution(int[] arr) {

        int[] copy = arr.clone();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            if(arr[i] != copy[i]){
                System.out.print(i+1 + " ");
            }
        }
        return "";
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
