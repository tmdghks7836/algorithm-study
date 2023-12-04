package com.company.etc.프로그래머스.그리디.큰수만들기;


import java.util.Stack;

public class Solution {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        int lenght = number.length() - k;

        for (int i = 0; i < number.length(); i++) {

            char c = number.charAt(i);

            while(!stack.isEmpty() && stack.peek() < c && k > 0){

                k--;
                stack.pop();
            }

            stack.push(c);
        }

        for (int i = 0; i < lenght; i++) {

            sb.append(stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution("987", 1));
    }
}