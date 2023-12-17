package com.company.백준.DFSBFS.외판원문제2;

import java.util.*;

public class Main {

    long answer = Integer.MAX_VALUE;

    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        /**
         *
         * 최소 경로는 모든 노드들을 돌려서 확인한다.
         * 플로우 워셜 알고리즘
         *
         * */


        int nodeCnt = sc.nextInt();

        long[][] arr = new long[nodeCnt][nodeCnt];
        create(arr, sc);

        for (int i = 0; i < arr.length; i++) {

            Set<Integer> visit = new HashSet<>();
            visit.add(i);
            DFS(arr, i, i, visit, 0);
        }

        System.out.println(answer);
    }

    private void DFS(long[][] arr, int start, int current, Set<Integer> visit, long price) {

        if (visit.size() == arr.length) {

            if (arr[current][start] != 0)
                answer = Math.min(answer, price + arr[current][start]);
            return;
        }

        for (int i = 0; i < arr[current].length; i++) {

            if (start == i) continue;
            if (arr[current][i] == 0) continue;
            if (visit.contains(i)) continue;

            visit.add(i);
            DFS(arr, start, i, visit, price + arr[current][i]);
            visit.remove(i);
        }
    }


    private static void create(long[][] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {

                int num = sc.nextInt();

                arr[i][j] = num;
            }
        }


    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}