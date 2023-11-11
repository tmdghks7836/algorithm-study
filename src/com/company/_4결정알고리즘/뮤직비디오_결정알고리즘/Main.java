package com.company._4결정알고리즘.뮤직비디오_결정알고리즘;

import java.util.Scanner;


public class Main {


    public Object solution(int[] arr, int target) {

        int result = 0;
        int lt = 0;
        int rt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (lt < arr[i]) {
                lt = arr[i];
            }
            rt += arr[i];
        }
        int mid = 0;
        while (lt <= rt) {

            mid = (lt + rt) / 2;
            int dvdNum = getDvdNum(arr, mid);

//            System.out.println("dvdNum = " + dvdNum);
            if (dvdNum <= target) {
                result = mid;
                rt = mid - 1;

            } else {
                lt = mid + 1;
            }
        }


        return result;
    }

    private int getDvdNum(int[] arr, int mid) {
        int calc = 0;
        int dvdNum = 1;

        for (int x : arr) {

            if(calc + x > mid){
                dvdNum++;
                calc = x;
            }else{
                calc += x;
            }
        }
        return dvdNum;
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
