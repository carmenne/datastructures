/*package whatever //do not write package name here */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.stream.Collectors;

class MaxHeapCheck {
    
    static int isHeap(int n, int[] input) {
        
        boolean isHeap = true;
        for (int i = 0; 2*i + 1 < n; i++) {
            
            isHeap = isHeap && input[i] > input[2*i + 1];
            if (2*i + 2 < n) 
                isHeap = isHeap && input[i] > input[2*i + 2];
        }
        return isHeap ? 1 : 0;
        
    }
    
    public static void main (String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in));
        String line = bufferedReader.readLine().replaceAll("\\s+$", "");
        int testCases = Integer.parseInt(line);

        for (int i = 0; i < testCases; i++) {
            
            line = bufferedReader.readLine().replaceAll("\\s+$", "");
            int n = Integer.parseInt(line);
            line = bufferedReader.readLine().replaceAll("\\s+$", "");
            int[] input = Stream.of(line.split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            System.out.println(isHeap(n, input));

        }
        bufferedReader.close();
    }
}
