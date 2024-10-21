package SortAlgorithms;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4};
        System.out.println("Array original: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }
}
