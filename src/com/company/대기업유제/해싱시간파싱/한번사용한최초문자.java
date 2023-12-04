package com.company.대기업유제.해싱시간파싱;

import java.util.*;

class 한번사용한최초문자 {

    public int solution(String s) {
        int answer = 0;

        HashMap<Character, Integer> map = new HashMap();

        //한번만 사용한 문자만 걸러낸다.
        char[] charArray = s.toCharArray();

        for (char c : charArray) {

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //그 중 첫번째를 가져온다.
        for (int i = 0; i < charArray.length; i++) {

            char c = charArray[i];

            if(map.get(c) == 1){
                return i + 1;
            }
        }

        //한번만 사용한 문자가 없으면 -1 반환
        return -1;
    }

    public static void main(String[] args) {
        한번사용한최초문자 T = new 한번사용한최초문자();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}