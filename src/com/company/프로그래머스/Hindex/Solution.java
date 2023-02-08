package com.company.프로그래머스.Hindex;


import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public int solution(int[] citations) {
        int answer = 0;

        Integer[] integers = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, Collections.reverseOrder());

        for (int i = 0; i < integers.length; i++) {

            if (integers[i] >= answer + 1) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{47, 10, 5, 4, 2});
        System.out.println(solution1);

    }
}