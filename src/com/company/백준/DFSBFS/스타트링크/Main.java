package com.company.백준.DFSBFS.스타트링크;


import java.util.*;

public class Main {

    static int F, S, G, U, D;
    static Queue<Integer> queue = new LinkedList();
    static int count;
    static boolean check;
    static Set<Integer> set = new HashSet<>();

    public static void BFS() {

        queue.offer(S);

        set.add(S);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Integer poll = queue.poll();

                if (poll == G) {
                    System.out.println(count);
                    return;
                }

                int up = poll + U;
                int down = poll - D;

                if (!set.contains(up) && up > 0 && up <= F) {
                    queue.add(up);
                    set.add(up);
                }

                if (!set.contains(down) && down > 0 && down <= F) {
                    queue.add(down);
                    set.add(down);
                }

            }

            count++;
        }

        System.out.println("use the stairs");
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        F = in.nextInt();
        S = in.nextInt();
        G = in.nextInt();
        U = in.nextInt();
        D = in.nextInt();

        BFS();

    }
}