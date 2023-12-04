package com.company.대기업유제.해싱시간파싱;

import java.util.HashMap;

class 음수가있는_부분수열 {
    public int solution(int[] nums, int m) {
        int answer = 0;
        int sum = 0;
        // 연속되는 부분수열의 합의 갯수를 찾기위해서는 해시를 이용해서 누적한 합을 그대로 가져다 사용하는 것이 빠름.
        HashMap<Integer, Integer> map = new HashMap();

        map.put(0, 1);

        //처음부터 하나씩 누적해서 왼쪽부터 해싱을 해나간다.
        for (int num : nums) {

            sum += num;

//			System.out.println("sum: " + sum);

            //누적합 - M이 해시에 존재하면 연속부분수열 값이 있다는 뜻
            if (map.containsKey(sum - m)) {

//                System.out.println("sum" + sum + " - m" + m + " :" + (sum - m) + "몇번?" + map.get(sum - m));

                answer += map.get(sum - m);
            }

            //누적 합을 해시에 넣는다
            map.put(sum, map.getOrDefault(sum, 0) + 1);


        }

        return answer;
    }

    public static void main(String[] args) {
        음수가있는_부분수열 T = new 음수가있는_부분수열();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}