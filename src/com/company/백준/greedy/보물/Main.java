package com.company.백준.greedy.보물;

import java.util.*;

public class Main {

    public void solution() {

        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        int num = sc.nextInt();
        int[] A = new int[num];
        int[] B = new int[num];

        for (int i = 0; i < num; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < num; i++) {
            B[i] = sc.nextInt();
            Stack<Integer> s = new Stack<>();

            while (!stack.isEmpty() && stack.peek() > B[i]) {
                s.add(stack.pop());
            }

            stack.add(B[i]);

            while (!s.isEmpty()) {

                stack.add(s.pop());
            }
        }

        Arrays.sort(A);

        int res = 0;
        for (int i = 0; i < num; i++) {
            res += stack.pop() * A[i];
        }

        System.out.println(res);
    }


    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}