package com.company.프로그래머스.모의고사;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public class St {

        int answerNum;

        int index;

        int[] arr;

        public St(int index, int[] arr) {
            this.index = index;
            this.arr = arr;
        }
    }


    public Integer[] solution(int[] answers) {

        List<St> list = new ArrayList<>();
        list.add(new St(1, new int[]{1, 2, 3, 4, 5,}));
        list.add(new St(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}));
        list.add(new St(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5,}));

        int max = 0;
        for (int i = 0; i < answers.length; i++) {

            for (St st : list) {

                st.answerNum += st.arr[i % st.arr.length] == answers[i] ? 1 : 0;
                max = Math.max(st.answerNum, max);
            }
        }

        int finalMax = max;
        Integer[] integers = list.stream()
                .filter(integer1 -> integer1.answerNum == finalMax)
                .map(st -> st.index)
                .toArray(Integer[]::new);

        return integers;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(new int[]{1, 3, 2, 4, 2,4,5,3,2,3,3,4,5,3,2,4,3,5,4,3}));
    }
}