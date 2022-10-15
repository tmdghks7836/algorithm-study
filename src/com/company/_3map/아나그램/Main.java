package com.company._3map.아나그램;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    //n = 5
    public Object solution(String str, String str2) {

        Map<Character, Integer> map = new HashMap<>();

        String result;
        for (int i = 0; i < str.toCharArray().length; i++) {

            char cc = str.charAt(i);
            if (!map.containsKey(cc)) {
                map.put(cc, 1);
            } else {
                map.put(cc, map.get(cc) + 1);
            }
        }

        for (int i = 0; i < str2.toCharArray().length; i++) {


            char cc = str2.charAt(i);
            if (!map.containsKey(cc)) {
                result = "NO";
                break;
            } else {
                if (map.get(cc) > 1)
                    map.put(cc, map.get(cc) - 1);
                else
                    map.remove(cc);
            }
        }
        result = map.isEmpty() ? "YES" : "NO";
        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        String next = in.next();
        String str = in.next();


        System.out.println(T.solution(next, str));
    }
}
