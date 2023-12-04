package com.company.etc.BFS.송아지찾기;

import java.util.*;


public class Main {

    int[] road = new int[]{1, -1, 5};
    int[] chk ;


    public Object solution(int s, int e) {

        Queue<Integer> q = new LinkedList<>();
        chk = new int[10001];
        int L = 1;
        q.offer(s);
        chk[s] = 1;
        while(!q.isEmpty()){

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();

                for (int i1 = 0; i1 < road.length; i1++) {

                    int value = poll + road[i1];

                    if(value == e){
                        return L;
                    }
                    if(value >= 0 && value <= 10000 && chk[value] == 0){
                        chk[value] = 1;
                        q.offer(value);
                    }
                }
            }
            L++;
        }


        return L;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int i = in.nextInt();
        int i1 = in.nextInt();

        System.out.println(T.solution(i, i1));
    }
}
