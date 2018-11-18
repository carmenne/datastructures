class ArrayUtils {
    
    static int[] enlarge(int[] input) {
        
        int n = input.length;
        int[] output = new int[2*n];
        
        for (int i = 0; i < n; i++) {
            output[i] = input[i]; 
        }
        
        return output;
    }
    
    static int[] shrink(int[] input) {
        
        int n = input.length;
        int[] output = new int[n/2];
        
        for (int i = 0; i < n/2; i++) {
            output[i] = input[i]; 
        }
        
        return output;
    }

    public static void main(String[] args) {
    
        int[] input = {1, 2, 3};
        int[] enlarged = enlarge(input);
        
        Print.greenln(String.format("%d=2*%d", 
                enlarged.length, input.length));
        
        int[] shrinked = shrink(input);
        
        Print.greenln(String.format("%d=%d/2", 
                shrinked.length, input.length));
        
    }
}
