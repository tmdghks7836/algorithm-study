package com.company.백준.수학.진법2;

import java.util.Scanner;

public class Main {


    /**
     *10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을
     * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        long num = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder res = new StringBuilder();

        while(num > 0){

            long remain = num % b;

            if(remain >= 10)
            res.append((char)(remain + 'A' - 10));
            else res.append((char) (remain + '0'));
            num /= b;

        }

        System.out.println(res.reverse());
    }
    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}