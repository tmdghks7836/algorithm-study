package com.company.프로그래머스.그리디.큰수만들기;


public class Solution {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (int i = 0; i < number.length() - k; i++) {

            int max = 0;
            for (int j = index; j <= k + i; j++) {

                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            sb.append(max);
        }


        return sb.toString();
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution("4177252841", 4));
    }
}