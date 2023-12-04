package com.company.etc.프로그래머스.etc.피보나치수;

public class Solution {

    public int solution(int n) {

        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {

            arr[i] = ((arr[i - 2] % 1234567) + arr[i - 1] % 1234567) % 1234567;
        }

        return arr[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(5);
        System.out.println(solution1);
    }
}