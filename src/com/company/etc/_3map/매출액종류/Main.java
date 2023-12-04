package com.company.etc._3map.매출액종류;

import java.util.*;


public class Main {
    //n = 5
    public void solution(int[] arr, int continuous) {


        Map<Integer, Integer> map = new HashMap<>();
        int subresult = 0;
        for (int i = 0; i < arr.length; i++) {

            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                subresult++;
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }

            if (i >= continuous - 1) {
                System.out.print(subresult + " ");

                int first = arr[i - continuous + 1];
                if (map.get(first) > 1) {
                    map.put(first, map.get(first) - 1);
                } else {
                    map.remove(first);
                    subresult--;
                }
            }
        }


    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int next = in.nextInt();
        int continuous = in.nextInt();
        int[] arr = new int[next];
        for (int i = 0; i < next; i++) {

            arr[i] = in.nextInt();
        }

        T.solution(arr, continuous);
    }
}
