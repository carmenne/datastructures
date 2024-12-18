import java.util.Arrays;

abstract class Heap{
    
    int size = 0;
    int[] heap = {};
   
    Heap(int capacity) {
        heap = new int[capacity];
    }
    
    public void insert(int el) {

        if (heap.length == size) {
            heap = ArrayUtils.enlarge(heap);
        }
        heap[size++] = el;
        heapifyUp();
    }
    
    public int peek() {
        return heap[0];
    }
    
    public int pop() {
        
        int root = heap[0];
        int last = heap[size - 1];
        
        heap[size - 1] = root;
        heap[0] = last;
        size--;
        heapifyDown(0);
        return root;
    }
    
    abstract boolean isHeap(int i);
    abstract void heapifyUp();
    abstract void heapifyDown(int from);
    
    int el(int i) {
        return heap[i];
    }
    
    int parent(int i) {
        return heap[(i-1)/2];
    }
    
    int left(int i) {
        return heap[2 * i + 1];
    }
    
    int right(int i) {
        return heap[2 * i + 2];
    }
    
    void insertAll(int[] input) {
        for (int i = 0; i < input.length; i++) {
            heap[i] = input[i];
            size++;
        }
        
        for(int i = size - 1; i >= 0; i--) heapifyDown(i);
    }
    
    void insertThenHeapify(int[] input) {
        
        for (int i = 0; i < input.length; i++) {
            insert(input[i]);
        }
    }
    
    void swapUp(int i) {
                
        int el = el(i);
        int parent = parent(i); 
        swap(i, el, parent);

    }
    
    void swap(int i, int el, int parent) {
        heap[(i-1)/2] = el;
        heap[i] = parent;
    }

}

class MinHeap extends Heap {
    
    private MinHeap(int capacity) {
        super(capacity);
    }
    
    static MinHeap build(int[] input) {
        
        MinHeap heap = new MinHeap(input.length);
        heap.insertThenHeapify(input);
        return heap;
    }
    
    static MinHeap buildThenHeapify(int[] input) {
        
        MinHeap heap = new MinHeap(input.length);
        heap.insertAll(input);
        return heap;
    }
    
    boolean isHeap(int i) {
        
        if (i >= (size - 1)/2) return true;
        
        if (el(i) < left(i) && el(i) < right(i) && 
            isHeap(2*i + 1) && isHeap(2*i + 2)) return true;
        
        return false;
                
    }

    void heapifyUp() {
        
        for (int i = size - 1; i > 0; i = (i-1)/2) {
            if (el(i) < parent(i)) swapUp(i);
        }
    }
    
    void heapifyDown(int from) {
        for (int i = from; i <= (size - 2)/2; i++) {
            
            int root = el(i);
            int left = left(i);
            
            if (2 * i + 2 >= size) {
                if (root > left) swapUp(2*i + 1);
            } else {
                int right = right(i);
                if (root > left || root > right)
                    if (left < right) swapUp(2*i + 1);
                    else swapUp(2*i + 2);
            }
        }
        
    }
}


class MaxHeap extends Heap{
    
    private MaxHeap(int capacity) {
        super(capacity);
    }
    
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
    
    boolean isHeap(int i) {
        
        if (i >= (size - 1)/2) return true;
        
        if (el(i) > left(i) && el(i) > right(i) && 
            isHeap(2*i + 1) && isHeap(2*i + 2)) return true;
        
        return false;
                
    }
    
    void heapifyUp() {
        
        for (int i = size - 1; i > 0; i = (i-1)/2) {
            if (parent(i) < el(i)) 
                swapUp(i);
        }
    }

    void heapifyDown(int from) {

        for (int i = from; i <= (size - 2)/2; i++) {
            
            int root = el(i);
            int left = left(i);
            
            if (2 * i + 2 >= size) {
                if (root < left) swapUp(2*i + 1);
            } else {
                int right = right(i);
                if (root < left || root < right)
                    if (left > right) swapUp(2*i + 1);
                    else swapUp(2*i + 2);
            }
            
        }   
        
    }
}

class Test {
    
    public static void main(String[] args) {
        
        // {2, 7, 26, 25, 19, 17, 1, 90, 3, 36}
        // {1, 23, 12, 9, 30, 2, 50}
        // {9, 845, 610, 990}

        int[] input = {1, 23, 12, 9, 30, 2, 50};
    
        MinHeap minHeap = MinHeap.build(input);
        int min1 = minHeap.peek();
        MinHeap minHeap2 = MinHeap.buildThenHeapify(input);
        int min2 = minHeap2.peek();
        if (min1 == min2) 
            Print.greenln(String.format("%d=%d", min1, min2));
        else
            Print.redln(String.format("%d=%d", min1, min2));

        Print.greenln("Min is: " + minHeap.pop());
        
        if (minHeap.isHeap(0))
            Print.greenln("Heap=True");
        else
            Print.redln("Heap=False");

        Print.greenln("New Min is: " + minHeap.peek());
        if (minHeap.isHeap(0))
            Print.greenln("Heap=True");
        else
            Print.redln("Heap=False");

        MaxHeap maxHeap = MaxHeap.buildThenHeapify(input);
        Print.greenln("Max is: " + maxHeap.pop());
        
        if (maxHeap.isHeap(0))
            Print.greenln("Heap=True");
        else
            Print.redln("Heap=False");

        Print.greenln("New Max is: " + maxHeap.pop());
        if (maxHeap.isHeap(0))
            Print.greenln("Heap=True");
        else
            Print.redln("Heap=False");
        
        Print.greenln("New Max is: " + maxHeap.pop());
        if (maxHeap.isHeap(0))
            Print.greenln("Heap=True");
        else
            Print.redln("Heap=False");
            
        MaxHeap maxHeap1 = MaxHeap.build(input);
        MaxHeap maxHeap2 = MaxHeap.buildThenHeapify(input);
        
        int max1 = maxHeap1.peek();
        int max2 = maxHeap2.peek();
        if (max1 == max2) 
            Print.greenln(String.format("%d=%d", max1, max2));
        else
            Print.redln(String.format("%d=%d", max1, max2));
        
        Print.greenln(Arrays.toString(maxHeap1.heap));
        Print.greenln(Arrays.toString(maxHeap2.heap));
    }
}
