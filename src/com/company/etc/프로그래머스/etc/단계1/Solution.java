package com.company.etc.프로그래머스.etc.단계1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> map = new HashMap();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            char aChar = chars[i];
            if(!map.containsKey(aChar)){
                answer[i] = -1;
            }else{
                Integer num = map.get(aChar);
                answer[i] = i - num;
            }

            map.put(aChar, i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("foobar");
    }
}