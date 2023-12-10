package com.company.대기업유제.sortingAndThinking;

import java.util.*;

class 이진수정렬 {

    class Test implements Comparable<Test>{
        int num;
        int cnt;

        public Test(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Test o) {
            int i = cnt - o.cnt;
            if(i == 0){
                return num - o.num;
            }
            return cnt - o.cnt;
        }
    }
    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length];

        PriorityQueue<Test> queue = new PriorityQueue<>();

        /**
         * nums에 숫자가 주어지면 각 원소를 이진수로 변환했을때 1의 갯수가 적은것부터 많은 순으로 정렬
         *
         * */
        for (int i = 0; i < nums.length; i++) {

            int tmp = nums[i];
            int cnt = 0;
            while(tmp > 0){
                cnt += (tmp % 2);
                tmp = tmp / 2;
            }

            queue.add(new Test(nums[i], cnt));
        }

        queue.forEach(test -> System.out.print(test.num + " "));

        System.out.println();
        int num = 0;
        while(!queue.isEmpty()){
            answer[num++] = queue.poll().num;
        }

        return answer;
    }

    public static void main(String[] args) {
        이진수정렬 T = new 이진수정렬();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}