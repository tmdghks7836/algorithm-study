package com.company.대기업유제.그리디알고리즘;

import java.util.Arrays;

class 이동횟수 {
    public int solution(int[] nums) {
        int answer = 0;

        int left = 0, right = nums.length - 1;

        int limit = 5;

        Arrays.sort(nums);

        while (left <= right) {

            int sum = nums[left] + nums[right];
            if(sum <= limit){
                left++;
                right--;
            }else{
                right--;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        이동횟수 T = new 이동횟수();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}