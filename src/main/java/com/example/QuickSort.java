package com.example;

/**
 * @author Shayan
 * @since 5/26/2021
 */
public class QuickSort<T extends Comparable<T>> {

    public static void main(String[] args) {
        Integer[] unSortedArray = {1, 9, 7, 4, 5, 10};
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.quickSort(0, unSortedArray.length - 1, unSortedArray);
        for (int value : unSortedArray) System.out.println(value);

        String[] unSortedStringArray = {"leh", "ieueu", "elham", "Ali", "ali"};
        QuickSort<String> stringQuickSort = new QuickSort<>();
        stringQuickSort.quickSort(0, unSortedStringArray.length - 1, unSortedStringArray);
        for (String value : unSortedStringArray) System.out.println(value);

    }


    public void quickSort(int low, int high, T[] arr) {
        if (low >= high) {
            return;
        }
        int pi = partition(low, high, arr);
        quickSort(low, pi - 1, arr);
        quickSort(pi + 1, high, arr);
    }


    private int partition(int low, int high, T[] arr) {
        T pivot = arr[high];
        int pivotRightIndex = low;
        for (int i = low; i < high; i++) {
            if (arr[i].compareTo(pivot) < 0) {
                swap(i, pivotRightIndex, arr);
                pivotRightIndex++;
            }
        }
        swap(pivotRightIndex, high, arr);
        return pivotRightIndex;
    }

    private void swap(int i, int j, T[] arr) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
