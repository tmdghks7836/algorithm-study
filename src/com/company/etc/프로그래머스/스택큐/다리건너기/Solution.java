
package com.company.etc.프로그래머스.스택큐.다리건너기;


import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        int index = 0;
        int time = 0;
        int bridgeWeight = truck_weights[index];
        boolean stop = false;
        queue.add(truck_weights[index++]);
        while (!queue.isEmpty()) {

            if (queue.size() == bridge_length || stop) {
                bridgeWeight -= queue.poll();
            }

            if (queue.size() < bridge_length && !stop) {

                if (index < truck_weights.length && bridgeWeight + truck_weights[index] <= weight) {
                    queue.add(truck_weights[index]);
                    bridgeWeight += truck_weights[index];
                    index++;
                } else {
                    queue.add(0);

                    if(index == truck_weights.length && queue.size() == bridge_length){
                        stop = true;
                    }
                }
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(2, 10, new int[]{7,4,5,6}));
    }

}
