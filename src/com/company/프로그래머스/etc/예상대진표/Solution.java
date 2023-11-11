package com.company.프로그래머스.etc.예상대진표;

public class Solution {

    public int solution(int n, int a, int b) {
        int answer = 1;

        while (true) {
            answer++;
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;

            if (Math.abs(a - b) == 1) {
                break;
            }

        }

        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(8, 4, 7);
        System.out.println(solution1);
    }
}