package Utils;

public class SearchMin {
    
    public static int searchMin(int[] arr) {
        int min = arr[0];
        int min_index = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                min_index = i;
            }
        }
        
        return min_index;
    }
}
