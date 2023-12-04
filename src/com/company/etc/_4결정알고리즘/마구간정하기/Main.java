package com.company.etc._4결정알고리즘.마구간정하기;

import java.util.Arrays;
import java.util.Scanner;


public class Main {


    public Object solution(int[] arr, int targetNUM) {

        Arrays.sort(arr);

        int result = 0;
        int lt = 1000000000;
        int rt = arr[arr.length - 1] - arr[0];
        for (int i = arr.length - 1; i > 0; i--) {
            if (lt > arr[i] - arr[i - 1]) {

                lt = arr[i] - arr[i - 1];
            }
        }
//        System.out.println(lt + " " + rt);
        int mid = 0;
        while (lt <= rt) {

            mid = (lt + rt) / 2;
            int num = getNum(arr, mid);

//            System.out.println("dvdNum = " + dvdNum);
            if (num >= targetNUM) {
                result = mid;
                lt = mid + 1;

            } else {
                rt = mid - 1;
            }
        }


        return result;
    }

    private int getNum(int[] arr, int mid) {

        int num = 1;

//        System.out.println(mid);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(mid <= arr[j] - arr[i]){
//                    System.out.println(arr[i] + " " + arr[j]);
                    num++;
                    i = j - 1;
                    break;
                }
            }
        }
//        System.out.println();
        return num;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int start = in.nextInt();

        int target = in.nextInt();
        int[] arr = new int[start];

        for (int i = 0; i < start; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(T.solution(arr, target));
    }
}
