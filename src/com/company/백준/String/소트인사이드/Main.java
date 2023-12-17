
package com.company.백준.String.소트인사이드;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {


    /**
     *
     */
    public void solution() {

        Scanner sc = new Scanner(System.in);

        String next = sc.next();

        Character[] arr = new Character[next.length()];
        char[] charArray = next.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            arr[i] = charArray[i];
        }


        Arrays.sort(arr, Comparator.reverseOrder());

        for (Character c : arr) {
            System.out.print(c);
        }

    }

    public static void main(String[] args) {

        Main T = new Main();
        T.solution();
    }
}