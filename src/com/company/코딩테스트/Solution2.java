package com.company.코딩테스트;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution2 {

    /**
     * 양의 정수의 배열 arr
     * - 입출력 예 : [ 1 , 2 , 3 , 12] → ( {1 | 2} → 2 + { 1 | 3 } → 3 + { 2 | 3 } → 6 ) = 11
     *
     *
     * */
    public String solution(int[][] arr) {


        //찍신찾기 1~5, score number 가 제공될때
        //가장 점수가 높은 사람을 "이름:점수" 형태로반환
        //1 a, 3 b, 5 c 번으로 모두 찍은 사람
        Map<Character, Integer> pickMap = new HashMap<>();
        pickMap.put('a' , 1);
        pickMap.put('b' , 3);
        pickMap.put('c' , 5);

        Map<Character, Integer> resMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int[] quiz = arr[i];

            int num = quiz[0];
            int quizScore = quiz[1];

            for (Character c : pickMap.keySet()) {

                if(pickMap.get(c) == num){
                    resMap.put(c, resMap.getOrDefault(c, 0) + quizScore);
                }
            }
        }

        Integer highScore = resMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(entry -> entry.getValue())
                .findFirst().get();

        List<String> collect = resMap.entrySet().stream().filter(entry -> entry.getValue().equals(highScore))
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.toList());

        return String.join(",", collect);
    }

    public static void main(String[] args) {
        Solution2 T = new Solution2();
        System.out.println(T.solution(new int[][]{{1, 5}, {3, 3}, {2, 4}}));
        System.out.println(T.solution(new int[][]{{1, 5}, {5, 5}, {2, 4}}));
    }
}