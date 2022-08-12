package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shayan
 * @since 5/27/2021
 */
public class Permutation {
    public static void main(String[] args) {
        Integer[] array1 = {100, 200, 300};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(array1));

        Integer[] array2 = {10};
        List<Integer> list2 = new ArrayList<>(Arrays.asList(array2));

        Integer[] array3 = {1, 2, 3};
        List<Integer> list3 = new ArrayList<>(Arrays.asList(array3));
        List<List<Integer>> dataset = new ArrayList<>();
        dataset.add(list1);
        dataset.add(list2);
        dataset.add(list3);
        List<Integer> result = permutation(dataset);
        for (Integer value : result) {
            System.out.println(value);
        }
    }

    public static void permutation(String str) {
        permutation(str, "");
    }

    public static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        }
        for (int i = 0; i < str.length(); i++) {
            permutation(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i));
        }
    }


    public static List<Integer> permutation(List<List<Integer>> values) {
        if (values.isEmpty()) {
            return new ArrayList<>();
        }
        if (values.size() == 1) {
            return new ArrayList<>(values.get(0));
        }

        List<Integer> currentList = values.remove(0);
        List<Integer> result = permutation(values);
        List<Integer> newResult = new ArrayList<>();
        for (Integer currentValue : currentList) {
            for (Integer value : result) {
                newResult.add(value + currentValue);
            }
        }
        return newResult;
    }
}
