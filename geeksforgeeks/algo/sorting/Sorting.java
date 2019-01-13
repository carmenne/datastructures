import java.util.*;
import java.lang.*;
import java.io.*;

class Sorting {
    
    private static ArrayList<Integer> swap(ArrayList<Integer> input) {
        
        ArrayList<Integer> swap = new ArrayList<Integer>();
        swap.add(input.get(1));
        swap.add(input.get(0));

        return swap;    
    }
    
     private static void split(int pivot, int position, 
        ArrayList<Integer> input,
        ArrayList<Integer> left, ArrayList<Integer> right) {
            
            for (int i = 0; i < input.size(); i++) {
                if (input.get(i) <= pivot)
                    left.add(input.get(i));
                else if (input.get(i) > pivot)
                    right.add(input.get(i));
            }
     }
    
    private static ArrayList<Integer> merge(ArrayList<Integer> left, 
                    int pivot, ArrayList<Integer> right) {
                        
        int size = left.size() + 1 + right.size();
        ArrayList<Integer> output = new ArrayList();
        for (int i = 0; i < left.size(); i++) {
            output.add(left.get(i));
        }
        output.add(pivot);
        
        for (int i = left.size() + 1; i < size; i++) {
            output.add(right.get(i - left.size() - 1));
        }
        return output;
    }
    
    private static ArrayList<Integer> quickSort(ArrayList<Integer> input) {
        if (input.size() == 0 || input.size() == 1) {
            return input;
        } else if (input.size() == 2) {
            if (input.get(0) > input.get(1))
                return swap(input);
            else 
                return input;
        }
        
        int pivotPosition = input.size() / 2;
        int pivot = input.get(pivotPosition);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        split(pivot, pivotPosition, input, left, right);
        
        // quickSort(left) + pivot + quickSort(right);
        return merge(quickSort(left), 
                pivot, 
                quickSort(right));
    }
    
    public static void main (String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testCases = Integer.parseInt(br.readLine());
            
            for (int i=0; i < testCases; i++) {
                
                int size = Integer.parseInt(br.readLine());
                ArrayList<Integer> input = new ArrayList<Integer>();
                
                String line = br.readLine();
                String[] str = line.trim().split("\\s+");
                for(int j = 0; j < size; j++){
                  input.add(Integer.parseInt(str[j]));
                }

                System.out.println(Arrays.toString(input.toArray()));
                ArrayList<Integer> sorted = quickSort(input);
                
                System.out.println(Arrays.toString(sorted.toArray()));
                
                for (int j = 0; j < sorted.size(); j++) {
                    System.out.printf("%d ", sorted.get(j));
                    
                }
                
                
            }
        } catch (IOException e) {}
    }
}
