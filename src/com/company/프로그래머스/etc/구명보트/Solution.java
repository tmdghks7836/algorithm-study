package com.company.프로그래머스.etc.구명보트;


import java.util.Arrays;

public class Solution {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Integer[] integers = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(integers);

        int start = 0;
        int end = people.length - 1;

        while (start <= end) {

            if (start == end) {
                start++;
            } else if (integers[start] + integers[end] <= limit) {

                start++;
            }

            answer++;
            end--;
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{70, 80, 50}, 100));
    }
}