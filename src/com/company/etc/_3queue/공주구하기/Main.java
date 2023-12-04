package com.company.etc._3queue.공주구하기;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    public int solution(int n, int k) {

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(i + 1);
        }

        int cnt = 1;

        while(queue.size() > 1){

            Integer poll = queue.poll();
            if(cnt != k){
                queue.offer(poll);
                cnt++;
            }else{
                cnt = 1;
            }
        }


        return queue.poll();
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();

        Integer k = in.nextInt();
        System.out.println(T.solution(next, k));
    }
}
