package com.company.대기업유제.DP.알고리즘수업피보나치;

import java.util.Scanner;

public class Main {

    int result = 0;
    public void solution() {

        Scanner sc = new Scanner(System.in);

        int valueCnt = sc.nextInt();
        int[] f = new int[valueCnt + 1];
        fib(valueCnt);
        System.out.println(result);
        result = 0;
        fibonacci(valueCnt, f);
        System.out.println(result);
    }

    public int fib(int n) {

        if (n == 1 || n == 2){
            result++;
            return 1;
        }
        else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    public int fibonacci(int n, int[] f) {


        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            result++;
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}