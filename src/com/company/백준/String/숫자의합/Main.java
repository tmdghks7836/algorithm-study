
package com.company.백준.String.숫자의합;

import java.util.Scanner;

public class Main {

    public void solution() {

        Scanner sc = new Scanner(System.in);

        int i1 = sc.nextInt();
        char[] charArray = sc.next().toCharArray();

        int result = 0;

        for (int i = 0; i < charArray.length; i++) {

            result += charArray[i] - 48;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}