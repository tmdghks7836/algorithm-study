package com.company.etc.프로그래머스.etc.위장;

import java.util.*;


public class Solution {

    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String s = clothe[1];

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Iterator<Integer> iterator = map.values().iterator();
        answer = 1;

        while(iterator.hasNext()){
            answer *= iterator.next().intValue() + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        T.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }
}
