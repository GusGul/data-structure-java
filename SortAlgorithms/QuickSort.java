package SortAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {
    public static List<Integer> quickSort(List<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        } else {
            int mid = arr.size() / 2;
            int pivot = arr.get(mid);
            
            List<Integer> less = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();

            for (int i = 0; i < arr.size(); i++) {
                if (i != mid) {
                    if (arr.get(i) <= pivot) {
                        less.add(arr.get(i));
                    } else {
                        greater.add(arr.get(i));
                    }
                }
            }

            List<Integer> sortedLess = quickSort(less);
            List<Integer> sortedGreater = quickSort(greater);

            return Stream.concat(Stream.concat(sortedLess.stream(), Stream.of(pivot)), sortedGreater.stream())
                         .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("Array original: " + Arrays.toString(array));

        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        
        List<Integer> sortedList = quickSort(list);
        System.out.println("Array ordenado: " + sortedList);
    }
}
