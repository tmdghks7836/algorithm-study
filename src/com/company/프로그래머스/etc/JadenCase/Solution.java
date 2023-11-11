package com.company.프로그래머스.etc.JadenCase;


public class Solution {

    public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution("3people   unFollowed me"));
    }
}