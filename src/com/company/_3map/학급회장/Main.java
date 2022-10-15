package com.company._3map.학급회장;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    //n = 5
    public Object solution(String str) {

        Map<Character, Integer> map = new HashMap<>();

        char result = str.charAt(0);

        for (int i = 0; i < str.toCharArray().length; i++) {

            char cc = str.charAt(i);
            if (!map.containsKey(cc)) {
                map.put(cc, 1);
            } else {
                map.put(cc, map.get(cc) + 1);

                if(map.get(cc) > map.get(result)){
                    result = cc;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner in = new Scanner(System.in);

        int next = in.nextInt();
        String str = in.next();
        str = str.substring(0, next);


        System.out.println(T.solution(str));
    }
}
