package com.company.대기업유제.시뮬레이션;

import java.util.ArrayList;

public class 최대길이바이토닉 {


    public int solution(int[] nums) {

        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < n-1; i++) {
            if(nums[i-1] < nums[i] && nums[i] > nums[i +1]){
                peaks.add(i);
            }
        }

        for (Integer x : peaks) {

            int left = x;
            int right = x;
            int cnt =1;
            while(left -1 >= 0 && nums[left -1] < nums[left]){
                left --;
                cnt++;
            }
            while(right + 1 < n && nums[right] > nums[right + 1]){
                right++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) {

        최대길이바이토닉 T = new 최대길이바이토닉();

        int[] arr = new int[]{1,2,1,2,3,2,1};
        System.out.println(T.solution(arr));

    }
}