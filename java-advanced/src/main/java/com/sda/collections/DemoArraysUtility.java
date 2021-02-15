package com.sda.collections;

import java.util.Arrays;
import java.util.List;

public class DemoArraysUtility {

    public static void main(String[] args) {
        // creating Arrays of String type
        String[] array
                = new String[]{"a", "b", "c", "d"};

        // getting the list view of Array
        List<String> list = Arrays.asList(array);
        System.out.println(list);

        // copy of
        int[] numbers = {4, 3, 2};
        int[] numbersCopy = Arrays.copyOf(numbers, 4);
        numbersCopy[3] = 1;

        // sort
        Arrays.sort(numbersCopy, 0, numbersCopy.length);

        // binary search
        int foundIndex = Arrays.binarySearch(numbersCopy, 1);
        System.out.println(foundIndex);

        // fill
        String[] letters = new String[4];
        Arrays.fill(letters, "c");
        for (String letter : letters) {
            System.out.println(letter);
        }

        // parallel sort
        Arrays.parallelSort(numbers);

        int compare = Arrays.compare(numbers, numbersCopy);
    }
}
