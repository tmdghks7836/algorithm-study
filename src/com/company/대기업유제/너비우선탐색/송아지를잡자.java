package com.company.대기업유제.너비우선탐색;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


/**
 * 송아지에 위치추적기
 * 현수 위치, 송아지 위치 수직선상의 좌표 점
 * 송아지는 매초마다 처음위치에서 이전이동거리+1만큼 이동
 * 현수 위치 x  매초 앞으로 x +1, 뒤로 x-1 앞으로 x*2 이동가능
 * s는 현수의 시작위치, e는 송아지의 시작위치
 * 현수가 송아지를 잡는 가장 빠른시간
 * <p>
 * 수직선 좌표 0 ~ 200000
 * s != e
 * 송아지가 수직선상 좌표 200000을 넘으면 송아지를 못잡는 것으로 간주 -1 반환
 * <p>
 * 시간초마다 송아지의 위치가 달라진다.
 * <p>
 * 현수가 이동하는 방식에는 규칙이 있다.
 * 이동한 다다음 위치에 내가 현재 있는 위치를 가지고있다. (현재위치 5라고하면  다음위치 +1인 6, 다다음 위치 -1하면 다시 5)
 * <p>
 * 메모리를 저장하여 짝수 홀수 값을 바로 확인해본다.
 */
class 송아지를잡자 {
    public int solution(int s, int e) {
        int answer = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        //짝수홀수여부, 해당 위치값
        boolean[][] memory = new boolean[2][200001];

        queue.add(s);

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {

                Integer x = queue.poll();

                for(int nx : new int[]{x-1, x+1, x*2}){
                    if(nx >= 0 && nx <= 200000 && !memory[level%2][nx]){
                        memory[level%2][nx] = true;
                        queue.offer(nx);
                    }
                }
            }

            e = level + e;
            if(e > 200000) return -1;
            if(memory[level % 2][e]) {
                return level;
            }
        }


        return -1111;
    }

    public static void main(String[] args) {
        송아지를잡자 T = new 송아지를잡자();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}