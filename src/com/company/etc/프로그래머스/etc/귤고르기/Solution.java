package com.company.etc.프로그래머스.etc.귤고르기;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {

            int i1 = tangerine[i];
            map.put(i1, map.getOrDefault(i1, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .collect(Collectors.toList());

        for (int i = 0; i < collect.size(); i++) {

            Map.Entry<Integer, Integer> integerIntegerEntry = collect.get(i);

            if(k <= 0){
                break;
            }
            answer++;
            k -= integerIntegerEntry.getValue();
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
    }
}