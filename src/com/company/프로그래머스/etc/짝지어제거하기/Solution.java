
package com.company.프로그래머스.etc.짝지어제거하기;

import java.util.Stack;

public class Solution {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(!stack.isEmpty() && stack.peek() == ch) stack.pop();
            else stack.push(ch);
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution("baabaa");
        System.out.println(solution1);
    }
}