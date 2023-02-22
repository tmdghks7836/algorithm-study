package com.company.프로그래머스.etc.타겟넘버;


public class Solution {

    int target;
    int[] numbers;
    int count;

    int[] curr;

    public void DFS(int num, int i) {

        //마지막 일 경우
        if (i == numbers.length) {

            if (num == target) {
//                System.out.println(Arrays.toString(curr));
                count++;
            }
            return;
        }

        int minus = num - numbers[i];
        int plus = num + numbers[i];
//        curr[i] = -numbers[i];
        DFS(minus, i + 1);
//        curr[i] = numbers[i];
        DFS(plus, i + 1);
    }


    public int solution(int[] numbers, int target) {

        this.numbers = numbers;
        this.target = target;
        this.curr = new int[numbers.length];

        DFS(0, 0);
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{4, 1, 2, 1}, 4);
        System.out.println(solution1);
    }
}