
package com.company.etc.프로그래머스.etc.나눗셈;


public class Solution {

    public int solution(int num1, int num2) {


        return (int) ((float) num1 / num2 * 1000);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(3, 2);
        System.out.println(solution1);
    }
}