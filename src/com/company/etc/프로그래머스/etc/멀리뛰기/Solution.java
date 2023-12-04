package com.company.etc.프로그래머스.etc.멀리뛰기;


public class Solution {


    int[] dy;

    public int solution(int n) {

        dy = new int[n];

        if (n == 1) return 1;

        dy[0] = 1;
        dy[1] = 2;

        for (int i = 2; i < dy.length; i++) {

            dy[i] = ((dy[i - 1] % 1234567) + (dy[i - 2] % 1234567)) % 1234567;
        }

        return dy[dy.length - 1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(3);
        System.out.println(solution1);

    }
}