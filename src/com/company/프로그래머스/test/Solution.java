package com.company.프로그래머스.test;


import java.math.BigDecimal;

public class Solution {


    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {

            String substring = t.substring(i, i + p.length());
            BigDecimal tNumber = new BigDecimal(substring);
            BigDecimal pNumber = new BigDecimal(p);
            if (tNumber.longValue() <= pNumber.longValue()) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().solution("10203", "102011"));
    }
}