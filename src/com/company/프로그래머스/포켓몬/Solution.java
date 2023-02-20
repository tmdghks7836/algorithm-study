package com.company.프로그래머스.포켓몬;


import java.util.HashSet;

public class Solution {

    public int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i =0; i < nums.length; i++){

            set.add(nums[i]);
        }

        int type = nums.length / 2;



        return Math.min(type, set.size());
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{3,3,3,2,2,2});
        System.out.println(solution1);
    }
}