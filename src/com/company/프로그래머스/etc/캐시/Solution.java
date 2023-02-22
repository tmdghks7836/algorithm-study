package com.company.프로그래머스.etc.캐시;


import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LRUCache lruCache = new LRUCache(cacheSize);

        for (String city : cities) {

            if (lruCache.get(city.toUpperCase()) == "") {
                answer++;
            } else {
                answer += 5;
                lruCache.put(city.toUpperCase(), "");
            }

        }
        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        System.out.println(solution1);

    }

    class LRUCache extends LinkedHashMap<String, String> {
        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public String get(int key) {
            return super.getOrDefault(key, "");
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }
}