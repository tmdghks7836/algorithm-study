package com.company.대기업유제.그리디알고리즘;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class 전투게임 {

    class Std implements Comparable<Std> {

        String name;

        Integer att;

        int idx;

        public Std(String name, Integer att, int idx) {
            this.name = name;
            this.att = att;
            this.idx = idx;
        }

        @Override
        public int compareTo(Std o) {
            return this.att - o.att;
        }
    }

    public int[] solution(String[] students) {

        int n = students.length;
        int[] answer = new int[n];

        AtomicInteger idxtemp = new AtomicInteger();
        List<Std> stdList = Arrays.stream(students).map(s -> {
                    String[] s1 = s.split(" ");

                    return new Std(s1[0], Integer.parseInt(s1[1]), idxtemp.getAndIncrement());
                })
                .collect(Collectors.toList());


        //오름차순 정렬 (자신보다 작은 값들은 바로 이전에서 합한 토탈값)
        Collections.sort(stdList);

        //토탈값은 계속 누적
        int j = 0;
        int jScore = 0;
        //팀별 점수 누적
        Map<String, Integer> teamMap = new HashMap<>();
        //이전 토탈값을 팀별 점수 누적값을 빼서 현재 학생에게 부여한다.
        for (int i = 0; i < stdList.size(); i++) {

            //현재 학생을 뽑는다.
            Std std = stdList.get(i);
            //이전학생 점수가 나보다 낮을때까지 더한다.
            while (i > j && std.att > stdList.get(j).att) {

                jScore += stdList.get(j).att;
                teamMap.put(stdList.get(j).name, teamMap.getOrDefault(stdList.get(j).name, 0) + stdList.get(j).att);
                j++;
            }

            answer[std.idx] = jScore - teamMap.getOrDefault(std.name, 0);
        }


        return answer;
    }


    public static void main(String[] args) {
        전투게임 T = new 전투게임();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}