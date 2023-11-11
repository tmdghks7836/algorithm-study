package com.company.프로그래머스.etc.올바른괄호;

import java.util.Stack;

public class Solution {

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(') {
                if (answer && !stack.isEmpty() && stack.peek() == ')') return false;
                answer = false;
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
                if (stack.isEmpty()) answer = true;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("(()("));
    }
}