package com.company.프로그래머스.etc.괄호회전하기;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public int solution(String s) {

        int answer = 0;
        Map<Character, Character> map = new HashMap<>();

        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');


        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {


            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder(s);

            for (int j = 0; j < chars.length; j++) {

                //닫힌문자가 있다면
                if (map.containsKey(chars[j]) && stack.size() > 0) {

                    if (stack.peek() == map.get(chars[j])) {
                        stack.pop();
                    } else {
                        break;
                    }
                } else {

                    stack.add(chars[j]);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }

            String subString = sb.substring(0, i + 1);
            sb.delete(0, i + 1);
            sb.append(subString);

            chars = sb.toString().toCharArray();
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("}]()[{"));
    }
}