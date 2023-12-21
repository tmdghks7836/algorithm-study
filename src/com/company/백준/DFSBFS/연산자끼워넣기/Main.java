package com.company.백준.DFSBFS.연산자끼워넣기;

import java.util.Scanner;

class Main {
    int[] nums;

    public void solution() {

        int answer = 0;
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        nums = new int[n];

        for (int i = 0; i < nums.length; i++) {

            nums[i] = sc.nextInt();
        }

        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();

        DFS(plus, minus, mul, div, 1, nums[0]);

        System.out.println(max);

        System.out.println(min);

    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    private void DFS(int plus, int minus, int mul, int div, int L, int sum) {

        if (plus < 0 || minus < 0 || mul < 0 || div < 0) {
            return;
        }
        if (L == nums.length) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        DFS(plus - 1, minus, mul, div, L + 1, sum + nums[L]);
        DFS(plus, minus - 1, mul, div, L + 1, sum - nums[L]);
        DFS(plus, minus, mul - 1, div, L + 1, sum * nums[L]);
        DFS(plus, minus, mul, div - 1, L + 1, sum / nums[L]);

    }

    public static void main(String[] args) {
        Main T = new Main();
        T.solution();
    }
}