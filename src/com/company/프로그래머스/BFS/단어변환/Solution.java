package com.company.프로그래머스.BFS.단어변환;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    boolean[] check;
    int level = 0;
    Queue<String> queue = new LinkedList<>();

    public int solution(String begin, String target, String[] words) {

        check = new boolean[words.length];

        queue.add(begin);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                String poll = queue.poll();

                for (int i = 0; i < words.length; i++) {

                    if(poll.equals(target)){
                        return level;
                    }
                    if (sameCheck(words[i], poll) && !check[i]){
                        check[i] = true;
                        queue.add(words[i]);
                    }
                }
            }

            level++;
            System.out.println(level);
        }

        return 0;
    }

    public boolean sameCheck(String a1, String a2) {

        int cnt = 0;

        for (int i = 0; i < a1.length(); i++) {

            if (a1.charAt(i) != a2.charAt(i)) {
                cnt++;
            }
        }

        return cnt == 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(solution1);
    }
}