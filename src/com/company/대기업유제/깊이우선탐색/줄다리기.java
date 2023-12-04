package com.company.대기업유제.깊이우선탐색;


import java.util.*;

/**
 * 총 인원 수 7 명 총인원 줄다리기
 * 7명을 1열로 세움
 * 싫어하는 학생끼리 붙어있으면 마이너스
 * nums : 서로 싫어하는 정보
 * 서로 싫어하는 사람끼리 이웃하지 않게 1열로 세울수 있는 모든 경우 수
 */

class 줄다리기 {

    int[] line;
    int answer;
    boolean[] stdCheck ;
    int[][] fight;
    Map<Integer, Set<Integer>> hateMap ;

    public int solution(int[][] fight) {
        answer = 0;
        this.fight = fight;

        hateMap = new HashMap<>();
        stdCheck = new boolean[8];
        for (int[] ints : fight) {

            if (!hateMap.containsKey(ints[0])) {
                hateMap.put(ints[0], new HashSet<>());
            }
            hateMap.get(ints[0]).add(ints[1]);

            if (!hateMap.containsKey(ints[1])) {
                hateMap.put(ints[1], new HashSet<>());
            }
            hateMap.get(ints[1]).add(ints[0]);
        }

        line = new int[7];

        for (int i = 1; i <= 7; i++) {

            stdCheck[i] = true;
            DFS(0, i);
            stdCheck[i] = false;
        }

        return answer;
    }

    private void DFS(int L,int std) {

        //라인 L 번째에 학생을 세운다.
        line[L] = std;

        if (L >= 6) {
            answer++;
            return;
        }

        for (int i = 1; i <= 7; i++) {

            Set<Integer> stdHateSet = hateMap.getOrDefault(i, new HashSet<>());

            boolean isHate = stdHateSet.contains(std);

            //i학생을 넣지 않았으면
            if(!stdCheck[i] && !isHate){
                stdCheck[i] = true;
                DFS(L+1, i);
                stdCheck[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        줄다리기 T = new 줄다리기();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
