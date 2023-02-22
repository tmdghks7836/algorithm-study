package com.company.프로그래머스.etc.베스트앨범;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static class Song implements Comparable<Song> {

        String name;
        int sum;
        int index;

        public Song(String name, int sum, int index) {
            this.name = name;
            this.sum = sum;
            this.index = index;
        }

        @Override
        public int compareTo(Song o) {
            return o.sum - this.sum;
        }

        public String getName() {
            return name;
        }
    }

    public class NameOrder implements Comparable<NameOrder> {

        String name;
        int sum;

        public NameOrder(String name, int sum) {
            this.name = name;
            this.sum = sum;
        }

        @Override
        public int compareTo(NameOrder o) {
            return o.sum - this.sum;
        }
    }

    public Integer[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList();

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            songs.add(new Song(genres[i], plays[i], i));
        }

        Map<String, List<Song>> map = songs.stream().collect(Collectors.groupingBy(Song::getName));
        List<NameOrder> orders = new ArrayList<>();

        map.forEach((s, songs1) -> {
            Collections.sort(songs1);


            map.put(s, songs1.subList(0, songs1.size() == 1 ? 1 : 2));

            orders.add(new NameOrder(s, songs1.stream().mapToInt(value -> value.sum).sum()));

        });

        Collections.sort(orders);

        for (NameOrder order : orders) {

            for (Song song : map.get(order.name)) {
                answer.add(song.index);
            }
        }

        return answer.toArray(Integer[]::new);
    }

    public static void main(String[] args) {

        Solution T = new Solution();

        System.out.println(T.solution(new String[]{"classic", "classic", "classic", "pop"}, new int[]{500, 150, 800, 2500}));
    }
}