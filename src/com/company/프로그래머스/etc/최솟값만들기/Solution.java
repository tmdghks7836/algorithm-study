package com.company.프로그래머스.etc.최솟값만들기;


import java.util.Arrays;

public class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 4, 2, 3, 6, 2}, new int[]{5, 2, 6, 7, 4, 4}));
    }
}