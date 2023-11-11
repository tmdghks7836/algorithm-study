package com.company.프로그래머스.etc.숫자의표현;

public class Solution {

    public int solution(int n) {
        int answer = 0;
        int num = 0;
        for (int i = 1; i <= n; i++) {

            num = 0;
            for (int j = i; j <= n; j++) {

                System.out.print(j + " ");
                num += j;
                if(num >= n){

                    if(num == n) answer++;
                    break;
                }
            }
            System.out.println();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(15);
        System.out.println(solution1);
    }
}