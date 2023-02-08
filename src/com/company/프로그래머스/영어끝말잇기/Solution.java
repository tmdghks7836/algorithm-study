
package com.company.프로그래머스.영어끝말잇기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> set = new HashSet<>();
        int order = 0;
        int order2 = 0;
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {

            order = i % n + 1;
            order2 = i / n + 1;

            char lastWord = words[i - 1].charAt(words[i - 1].length() - 1);
            char firstWord = words[i].charAt(0);
            boolean correctAnswer = lastWord == firstWord;
            boolean contains = set.contains(words[i]);
            if (contains || !correctAnswer) {
                break;
            } else {
                order = 0;
                order2 = 0;
                set.add(words[i]);
            }
        }

        answer[0] = order;
        answer[1] = order2;
        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});

        System.out.println(Arrays.toString(solution1));
    }
}