package com.company.etc.프로그래머스.그리디.큰수만들기;


import java.util.Stack;

public class Solution2 {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        //지울 갯수 체크
        //1231234 일 경우 하나씩 체크하면서 앞에있는 숫자를 제거해 나간다.

        Stack<Character> stack = new Stack<>();
        int i1 = number.length() - k;
        for (int i = 0; i < number.length(); i++) {

            char c = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < c && k > 0){

                k--;
                stack.pop();
            }

            stack.push(c);
        }

        for (int i = 0; i < i1; i++) {

            sb.append(stack.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Solution2 T = new Solution2();

        System.out.println(T.solution("1231234", 3));
    }
}