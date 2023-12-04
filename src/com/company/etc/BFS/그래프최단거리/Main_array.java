package com.company.etc.BFS.그래프최단거리;

import java.util.*;

//6 9
//1 3
//1 4
//3 4
//4 5
//4 6
//2 1
//2 5
//6 2
//6 5
public class Main_array {

    static int n, m = 0;
    static Queue<Integer> queue = new LinkedList<>();
    static List<List<Integer>> totList = new ArrayList<>();
    static int[] ch;
    static int[] dist;

    public void BFS() {

        queue.offer(1);
        ch[1] = 1;

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

            for (int i : totList.get(poll)) {

                if (ch[i] == 0) {
                    ch[i] = 1;
                    queue.add(i);

                    dist[i] = dist[poll] + 1;
                }
            }
        }



    }


    public static void main(String[] args) {

        Main_array T = new Main_array();

        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        ch = new int[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            totList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {

            int a = in.nextInt();
            int b = in.nextInt();

            totList.get(a).add(b);
        }

        T.BFS();

        for (int i = 0; i < dist.length; i++) {

            System.out.println(i + " : " + dist[i]);
        }

        System.out.println(dist);
    }


}
