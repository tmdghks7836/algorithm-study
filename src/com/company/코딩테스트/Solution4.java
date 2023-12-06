package com.company.코딩테스트;

import java.util.HashMap;
import java.util.Map;

class Solution4 {

    /**
     * 화산을 피해 도망
     * 1마리빼고는 전부 동굴로 피신
     * 동굴로 이동한 공룡 이름 배열 , 안전하게 피신한 공룡 배열 주어질때 피신오지 못한 공룡의 이름
     */
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap();

        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : participant) {

            if (!map.containsKey(s) || map.getOrDefault(s, 0) == 0) {
                return s;
            }

            map.put(s, map.get(s) - 1);
        }

        return null;
    }


    public static void main(String[] args) {
        Solution4 T = new Solution4();
        System.out.println(T.solution(new String[]{"트리케라톱스", "티라노사우루스", "바리오닉스"}, new String[]{"바리오닉스", "티라노사우루스"}));
        System.out.println(T.solution(new String[]{"파키케팔로사우루스", "티라노사우루스", "티라노사우루스", "스테고사우루스"}, new String[]{"파키케팔로사우루스", "스테고사우루스", "티라노사우루스"}));
    }
}