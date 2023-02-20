package com.company.프로그래머스.완주하지못한선수;


import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> comMap = new HashMap<>();

        for (String s : completion) {

            int num = comMap.get(s) != null ? comMap.get(s) : 0;
            comMap.put(s, num + 1);
        }

        for (String s : participant) {

            if (!comMap.containsKey(s)) {
                return s;
            }

            if (comMap.get(s) == 1) {
                comMap.remove(s);
            } else {
                comMap.put(s, comMap.get(s) - 1);
            }

        }

        return null;
    }

}