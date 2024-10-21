package SearchAlgorithms;

public class BinarySearch {
    
    public static int binarySearch(int[] arr, int target) {
        int count = 0;
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            count++;
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                System.out.println("Número de iterações: " + count);
                return mid;
            }
            
            if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;
        
        int result = binarySearch(arr, target);
        
        if (result == -1) {
            System.out.println("Elemento não encontrado.");
        } else {
            System.out.println("Elemento encontrado no índice: " + result);
        }
    }
}
