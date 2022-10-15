package com.company._1배열.주기억장치;

import java.util.Scanner;


public class Main {

    int[] cacheMem;

    public Object solution(int[] arr, int start) {

        cacheMem = new int[start];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sort(arr[i]);
        }

        for (int i : cacheMem) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public void sort(int num) {

        for (int i = 0; i < cacheMem.length; i++) {


            if (cacheMem[i] == num) {
                for (int j = i - 1; j >= 0; j--) {

                    int temp = cacheMem[j];
                    cacheMem[j] = cacheMem[j + 1];
                    cacheMem[j + 1] = temp;
                }
                break;
            } else if (cacheMem[i] == 0 || i == cacheMem.length - 1) {

                for (int j = i; j >= 1; j--) {

                    cacheMem[j] = cacheMem[j - 1];
                }
                cacheMem[0] = num;
                break;
            }
        }

    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int start = in.nextInt();

        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr, start));
    }
}
