package com.company._4결정알고리즘.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static List<Integer> nList = new ArrayList<>();

    public static void main(String[] args) {

        Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
        nList = Arrays.asList(arr);
        BinarySearch binarySearch = new BinarySearch();
        boolean search = binarySearch.search(1, 0, nList.size() - 1);

        System.out.println(search);

    }

    public boolean search(int value, int start, int end) {

        if(start > end){
            return false;
        }

        int mid = (start + end) / 2;

        if (nList.get(mid) == value) {
            return true;
        }

        if (nList.get(mid) > value) {
            return search(value, 0, mid - 1);
        } else {
            return search(value, mid + 1, nList.size() - 1);
        }
    }
}
