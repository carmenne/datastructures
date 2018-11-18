import java.util.Arrays;

class MinHeap {
    
    int size = 0;
    int[] heap = new int[1];
    
    // Returns the min elements from a heap
    Integer getMin() {
        if (size == 0) return null;
        return heap[0];
    }

    void insert(int el) {

        if (heap.length == size) {
            heap = ArrayUtils.enlarge(heap);
        }
        heap[size++] = el;
        heapifyUp();
    }
    
    void heapifyUp() {
        
        int len = size;
        
        for (int i = len - 1; i > 0; i = (i-1)/2) {
            
            int el = heap[i];
            int parent = heap[(i-1)/2];
            
            if (el < parent) swap(i, el, parent);
        }
    }
    
    void swap(int i, int el, int parent) {
                
        heap[(i-1)/2] = el;
        heap[i] = parent;
    }
  
    
    public static void main(String[] args) {
    
        // 2,7,26,25,19,17,1,90,3,36
        MinHeap heap = new MinHeap();
       
        heap.insert(2);
        heap.insert(7);
        heap.insert(26);
        heap.insert(25);
        heap.insert(19);
        heap.insert(17);
        heap.insert(1);
        heap.insert(90);
        heap.insert(3);
        heap.insert(36);
        
        Print.greenln(heap.getMin());
        Print.greenln(Arrays.toString(heap.heap));
    }
}
