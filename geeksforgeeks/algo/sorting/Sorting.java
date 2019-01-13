import java.util.*;
import java.lang.*;
import java.io.*;

class Sorting {
    
    private static int[] swap(int[] input, int from, int to) {
        int temp = input[to];
        input[to] = input[from];
        input[from] = temp;

        return input;    
    }
    
    private static int order(int[] input, int low, int high) {

        int pivot = input[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (input[j] <= pivot) {
                i++;
                swap(input, i, j);
            }
        }
        swap(input, i + 1, high);
        return i + 1;
    }

    private static void quickSort(int[] input, int low, int high) {
        if (low < high) {
            
            int position = order(input, low, high);
            quickSort(input, low, position-1);
            quickSort(input, position+1, high);

        }
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
                
                quickSort(input, 0, size-1);
                
                for (int j = 0; j < input.length; j++) {
                    System.out.printf("%d ", input[j]);
                    
                }
                
                
            }
        } catch (IOException e) {}
    }
}
