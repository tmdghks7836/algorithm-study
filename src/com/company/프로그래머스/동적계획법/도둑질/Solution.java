
package com.company.프로그래머스.동적계획법.도둑질;


class Solution {

    public int solution(int[] money) {

        int[] clone = money.clone();
        int[] clone2 = money.clone();

        clone[0] = 0;
        clone[2] = Math.max(money[2], money[1]);
        clone2[money.length - 1] = 0;
        clone2[1] = Math.max(money[0], money[1]);
        clone2[2] = Math.max(money[0] + money[2], money[1]);

        for (int i = 3; i < money.length; i++) {

            int i1 = clone[i];
            int i2 = clone[i - 2];
            clone[i] = i1 + i2;
            clone[i] = Math.max(i1 + i2, clone[i -1]);
        }

        for (int i = 3; i < money.length; i++) {

            int i1 = clone2[i];
            int i2 = clone2[i - 2];
            clone2[i] = Math.max(i1 + i2, clone2[i -1]);
        }
        int num = Math.max(clone[money.length - 1], clone[money.length - 2]);
        int num2 = Math.max(clone2[money.length - 1], clone2[money.length - 2]);

        return Math.max(num, num2);
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(new int[]{1, 10, 100, 1, 10000, 100000, 1, 1000, 100000, 10}));
    }

}
