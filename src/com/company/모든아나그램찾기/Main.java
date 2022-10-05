package com.company.모든아나그램찾기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    //n = 5
    public Object solution(String str, String str2) {

        Map<Character, Integer> map = new HashMap<>();

        Integer result = 0;
        for (int i = 0; i < str2.toCharArray().length; i++) {

            char cc = str2.charAt(i);
            if (!map.containsKey(cc)) {
                map.put(cc, 1);
            } else {
                map.put(cc, map.get(cc) + 1);
            }
        }

        Map<Character, Integer> map2 = new HashMap<>();
        char lt = str.charAt(0);
        for (int i = 0; i < str.toCharArray().length; i++) {

            char cc = str.charAt(i);
            if (!map2.containsKey(cc)) {
                map2.put(cc, 1);
            } else {
                map2.put(cc, map2.get(cc) + 1);
            }

            if (i >= str2.length() - 1) {
                if (map.equals(map2)) {
                    result++;
                }

                if (map2.get(lt) > 1) {
                    map2.put(lt, map2.get(lt) - 1);
                } else {
                    map2.remove(lt);
                }
                lt = str.charAt(i - str2.length() + 2);
            }
        }


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
