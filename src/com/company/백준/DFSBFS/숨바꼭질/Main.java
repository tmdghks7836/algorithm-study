

package com.company.백준.DFSBFS.숨바꼭질;

import java.util.*;

public class Main {


    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         *
         * N : 수빈이 위치
         * K : 동생 위치
         *
         * 수빈이 걷기 : X + 1 or X - 1
         * 순간이동 하기 : X * 2
         *
         * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇초인가.
         * */
        int N = sc.nextInt();
        int K = sc.nextInt();

        int time = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        Set<Integer> ch = new HashSet<>();

        queue.add(N);
        ch.add(N);

        while(!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Integer poll = queue.poll();

                if(poll == K) {
                    System.out.println(time);
                    return;
                }

                int[] arr = {poll + 1, poll - 1, poll * 2};

                for (int j = 0; j < arr.length; j++) {

                    if(arr[j] < 0 || arr[j] > 100000) continue;
                    if(ch.contains(arr[j])) continue;

                    ch.add(arr[j]);
                    queue.add(arr[j]);
                }
            }

            time++;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}