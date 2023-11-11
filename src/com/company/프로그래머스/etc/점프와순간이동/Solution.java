package com.company.프로그래머스.etc.점프와순간이동;


public class Solution {


    public int solution(int n) {
        int ans = 0;

        while (n > 0) {

            if (n % 2 == 0) {
                n = n / 2;
            }else{
                n--;
                ans++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(5000);
        System.out.println(solution1);

    }
}