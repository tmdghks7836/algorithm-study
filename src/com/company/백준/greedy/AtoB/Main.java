package com.company.백준.greedy.AtoB;

import java.util.*;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         *정수 A를 B로
         *
         * 2를 곱한다.
         * 1을 수의 가장 오른쪽에 추가한다.
         * */

        long A = sc.nextInt();
        long B = sc.nextInt();

        Set<Long> set = new HashSet<>();

        Queue<Long> queue = new ArrayDeque<>();

        queue.add(A);
        set.add(A);

        long L = 1;
        while(!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Long poll = queue.poll();

                Long case1 = poll * 2;

                Long case2 = (poll * 10)  + 1;

                if(case2 == B || case1 == B) {
                    System.out.println(L + 1);
                    return;
                }

                if(!set.contains(case1) && case1 < B){
                    set.add(case1);
                    queue.add(case1);
                }

                if(!set.contains(case2) && case2 < B){
                    set.add(case2);
                    queue.add(case2);
                }
            }
            L++;
        }

        System.out.println(-1);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}