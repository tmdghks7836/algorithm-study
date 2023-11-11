package com.company;

public class Fibonacci {

    public static void main(String[] args) {
        int input = 8; // 8개 출력
        for (int i = 1; i <= input; i++) {
            System.out.println(fibo(i));
        }
    }


    public static int fibo(int n) {

        if (n <= 1) {
            return n;
        }

        return fibo(n - 2) + fibo(n - 1);
    }
}

// 1 = 1
// 2 = 0 + 1
// 3 = 1 + 1
// 4 = 1 + 1 + 1
// 5 =