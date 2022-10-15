package com.company._4결정알고리즘.이분검색;

import java.util.*;


public class Main {


    public Object solution(int[] arr, int target) {

        int answer = 0;
        int lt = 0, rt = arr.length - 1;
        Arrays.sort(arr);

        while (true) {

            int mid = (rt + lt) / 2;
            if (arr[mid] == target) {
                answer = mid + 1;
                break;
            } else if (arr[mid] < target) {
                lt = mid + 1;
            } else {
                rt = mid - 1;

            }

        }

        return answer;
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
