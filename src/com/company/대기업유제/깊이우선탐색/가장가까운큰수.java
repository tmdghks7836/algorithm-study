package com.company.대기업유제.깊이우선탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class 가장가까운큰수 {

    List<Integer> nums;
    boolean[] visit;
    private int n;

    int answer;

    boolean flag = false;

    public int solution(int n) {
        this.n = n;
        answer = Integer.MAX_VALUE;
        //123보다는 큰 수고 제일 작은수여야 한다.

        int temp = n;

        nums = new ArrayList<>();
        while(temp > 0){
            nums.add(temp % 10);
            temp = temp / 10;
        }
        Collections.sort(nums);
        visit = new boolean[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            flag = false;
            DFS(i, 0);
        }


        return answer != Integer.MAX_VALUE ? answer : -1;
    }

    private void DFS(int depth, int number) {

        if(flag) return;
        if (depth == nums.size()) {

            if (number > n) {
                answer = Math.min(answer, number);
                flag = true;
            }
            return;
        }

        for (int j = 0; j < nums.size(); j++) {

            if (!visit[j]) {
                visit[j] = true;
                DFS(depth + 1, number * 10 + nums.get(j));
                visit[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        가장가까운큰수 T = new 가장가까운큰수();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}