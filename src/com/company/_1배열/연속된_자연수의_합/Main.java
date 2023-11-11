package com.company._1배열.연속된_자연수의_합;

import java.util.Scanner;


public class Main {

    public Object solution(Integer[] numArr) {

        Integer result = 0;
        Integer pivot = 0;
        Integer bowl = 0;
        for (int i = 0; i < numArr.length - 1; i++) {

            bowl += numArr[i];

            if (bowl >= numArr.length) {
                if (bowl == numArr.length) {

                    result++;
                }
                bowl -= numArr[pivot];
                pivot++;

                while (true) {
                    bowl -= numArr[i];
                    i--;
                    if (bowl + numArr[i] <= numArr.length) {
                        break;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        Integer next = in.nextInt();
        Integer[] arr = new Integer[next];

        for (Integer i = 0; i < next; i++) {

            arr[i] = i + 1;
        }
        System.out.println(T.solution(arr));
    }
}
