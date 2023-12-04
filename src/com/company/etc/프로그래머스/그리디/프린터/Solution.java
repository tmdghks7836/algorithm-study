
package com.company.etc.프로그래머스.그리디.프린터;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        PriorityQueue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());

        for (int priority : priorities) {
            queue.add(priority);
        }

        int order = 0;
        while (!queue.isEmpty()) {

            for (int i = 0; i < priorities.length; i++) {

                if (queue.peek() == priorities[i]) {

                    if(i == location){
                        return ++order;
                    }
                    queue.poll();
                    order++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

}
