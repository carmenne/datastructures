import java.util.Arrays;

class Heap{
    
    int size = 0;
    int[] heap = {};
    
    void insert(int el) {};
    
    Heap(int capacity) {
        heap = new int[capacity];
    }
    
    void insertAll(int[] input) {
        for (int i = 0; i < input.length; i++) {
            heap[i] = input[i];
        }
    }
    
    void insertThenHeapify(int[] input) {
        
        for (int i = 0; i < input.length; i++) {
            insert(input[i]);
        }
    }
}

class MinHeap extends Heap {
    
    static MinHeap build(int[] input) {
        
        MinHeap heap = new MinHeap(input.length);
        heap.insertThenHeapify(input);
        return heap;
    }
    
    private MinHeap(int capacity) {
        super(capacity);
    }
    
    // Returns the min elements from a heap
    Integer getMin() {
        if (size == 0) return null;
        return heap[0];
    }

    // Takes logn
    void insert(int el) {

        if (heap.length == size) {
            Print.redln("enlarged");
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
}


class MaxHeap extends Heap{
    
    static MaxHeap build(int[] input) {
        
        MaxHeap heap = new MaxHeap(input.length);
        heap.insertThenHeapify(input);
        return heap;
    }
    
    static MaxHeap buildThenHeapify(int[] input) {
        
        MaxHeap heap = new MaxHeap(input.length);
        heap.insertAll(input);
        return heap;
    }
    
    private MaxHeap(int capacity) {
        super(capacity);
    }
    
    
    // Returns the min elements from a heap
    Integer getMax() {
        if (size == 0) return null;
        return heap[0];
    }


    // Takes logn
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
            
            if (el > parent) swap(i, el, parent);
        }
    }
    
    void swap(int i, int el, int parent) {
                
        heap[(i-1)/2] = el;
        heap[i] = parent;
    }
}


class Test {
    
    public static void main(String[] args) {
        
        // 2,7,26,25,19,17,1,90,3,36
        int[] input = {2, 7, 26, 25, 19, 17, 1, 90, 3, 36};
    
        MinHeap minHeap = MinHeap.build(input);
        Print.greenln("Min is: " + minHeap.getMin());

        MaxHeap maxHeap = MaxHeap.build(input);
        Print.greenln("Max is: " + maxHeap.getMax());

    }
}
