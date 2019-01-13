import java.util.*;
import java.lang.*;
import java.io.*;

class Sorting {
    
    private static int[] swap(int[] input) {
        int temp = input[1];
        input[1] = input[0];
        input[0] = temp; 
        return input;    
    }
    
     private static void split(int pivot, int position, int[] input,
        ArrayList<Integer> left, ArrayList<Integer> right) {
            
            for (int i = 0; i < input.length; i++) {
                if (input[i] < pivot)
                    left.add(input[i]);
                else if (input[i] > pivot)
                    right.add(input[i]);
            }
     }
    
    private static int[] merge(int[] left, int pivot, int[] right) {
        int size = left.length + 1 + right.length;
        int[] output = new int[size];
        for (int i = 0; i < left.length; i++) {
            output[i] = left[i];
        }
        output[left.length] = pivot;
        
        for (int i = left.length + 1; i < size; i++) {
            output[i] = right[i - left.length - 1];
        }
        return output;
    }
    
    private static int[] quickSort(int[] input) {
        if (input.length == 0 || input.length == 1) {
            return input;
        } else if (input.length == 2) {
            if (input[0] > input[1])
                return swap(input);
            else 
                return input;
        }
        
        int pivotPosition = input.length / 2;
        int pivot = input[pivotPosition];
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        split(pivot, pivotPosition, input, left, right);
        
        // quickSort(left) + pivot + quickSort(right);
        return merge(quickSort(left.stream().mapToInt(i -> i).toArray()), 
                pivot, 
                quickSort(right.stream().mapToInt(i -> i).toArray()));
    }
    
    public static void main (String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testCases = Integer.parseInt(br.readLine());
            
            for (int i=0; i < testCases; i++) {
                
                int size = Integer.parseInt(br.readLine());
                int[] input = new int[size];
                
                String line = br.readLine();
                String[] str = line.trim().split("\\s+");
                for(int j = 0; j < size; j++){
                  input[j] = Integer.parseInt(str[j]);
                }
                
                int[] sorted = quickSort(input);
                
                for (int j = 0; j < sorted.length; j++) {
                    System.out.printf("%d ", sorted[j]);
                    
                }
                
                
            }
        } catch (IOException e) {}
    }
}
