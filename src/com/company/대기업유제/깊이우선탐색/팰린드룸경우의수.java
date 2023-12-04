package com.company.대기업유제.깊이우선탐색;

import java.util.*;
import java.util.stream.Collectors;

class 팰린드룸경우의수 {

    HashMap<Character, Integer> map;
    Deque<Character> deque;
    Set<String> set;
    char[] charArray;
    int n;
    List<String> answer;

    public String[] solution(String s) {

        n = s.length();
        answer = new ArrayList<>();
        map = new HashMap<>();

        charArray = s.toCharArray();
        set = new HashSet<>();
        for (char c : charArray) {

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> collect = map.entrySet().stream().filter(entry -> entry.getValue() % 2 == 1)
                .collect(Collectors.toList());

        deque = new ArrayDeque<>();

        if (collect.size() >= 2) {
            return new String[]{};
        } else if (collect.size() == 1) {

            Character key = collect.get(0).getKey();
            deque.add(key);
            map.put(key, map.get(key) - 1);
        }

        for (char c : charArray) {

            DFS(0);
        }

        return set.toArray(String[]::new);
    }

    private void DFS(int L) {

        if (L == n / 2) {

            Character[] array = deque.toArray(Character[]::new);
            StringBuilder sb = new StringBuilder();
            for (Character c : array) {
                sb.append(c);
            }
            set.add(sb.toString());
            return;
        }

        for (char addC : charArray) {

            Character[] array = deque.toArray(Character[]::new);
            StringBuilder sb = new StringBuilder();
            sb.append(addC);
            for (Character c : array) {
                sb.append(c);
            }
            sb.append(addC);
            if (map.get(addC) >= 2 && !set.contains(sb.toString())) {
                deque.addFirst(addC);
                deque.addLast(addC);
                map.put(addC, map.get(addC) - 2);
                DFS(L + 1);
                map.put(addC, map.get(addC) + 2);
                deque.pollFirst();
                deque.pollLast();
            }
        }
    }

    List<Character> toString2(Deque deque) {

        List<Character> list = new ArrayList<>();
        list.addAll(deque);

        return list;
    }
    public static void main(String[] args) {
        팰린드룸경우의수 T = new 팰린드룸경우의수();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}