package com.company.etc.프로그래머스.etc.숫자변환하기_BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    Queue<Integer> queue = new LinkedList<>();
    HashSet set = new HashSet();
    int x, y, n, L;
    boolean check;

    public int BFS() {

        while (!queue.isEmpty()) {

            int size = queue.size();

            check = true;

            for (int i = 0; i < size; i++) {

                Integer poll = queue.poll();

                if (poll == y) return L;
                if (poll < y) check = false;

                add(poll + n);
                add(poll * 2);
                add(poll * 3);
            }

            if (check) {
                return -1;
            }
            L++;
        }

        return -1;
    }

    public void add(int i){

        if (!set.contains(i)) {
            set.add(i);
            queue.offer(i);
        }
    }

    public int solution(int x, int y, int n) {

        this.x = x;
        this.y = y;
        this.n = n;
        queue.offer(x);
        return BFS();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(10, 40, 5));
    }
}