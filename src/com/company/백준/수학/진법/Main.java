package com.company.백준.수학.진법;

import java.util.Scanner;

public class Main {


    /**
     *
     *B진법 수 N이 주어진다
     * 수를 10진법으로 바꿔
     * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int b = sc.nextInt();
        int res = 0;

        char[] charArray = str.toCharArray();

        for (char c : charArray) {

            if('0' <= c && c <= '9') {
                res = res * b + (c - '0');
            }
            else{
                res = res * b + (c - 'A' + 10); // 10 - 10 + 10
            }
        }

        System.out.println(res);
    }
    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}