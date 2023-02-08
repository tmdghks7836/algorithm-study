package com.company.프로그래머스.카펫;

import java.util.Arrays;

public class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int tot = brown + yellow;

        for (int i = 3; i < tot; i++) {

            int j = tot / i;


            if (i >= j && tot % i == 0) {
                if ((j - 2) * (i - 2) == yellow) {
                    answer = new int[]{i, j};
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(8, 1);
        System.out.println(Arrays.toString(solution1));
    }
}