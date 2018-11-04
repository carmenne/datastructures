import java.util.Stack;

public class Sum {


    public int sum_recursive(int n) {

        if (n <= 0)
            return 0;
        return n + sum_recursive(n-1);

    }


    public int sum_stack(int n) {

        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        int sum = 0;

        while (!stack.isEmpty()) {
            if (n <= 0)
                sum += stack.pop();
            else {
                stack.push(n - 1);
                n = n - 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        Sum s = new Sum();
        int n = 10000;

        long l1 = System.currentTimeMillis();
        int result_recursive = s.sum_recursive(n);
        long l2 = System.currentTimeMillis();


        long l3 = System.currentTimeMillis();
        int result_stack= s.sum_stack(n);
        long l4 = System.currentTimeMillis();

        // 50005000 in 8 ms = 50005000 in 20 ms
        System.out.printf("%d in %d ms = %d in %d ms", result_recursive, l2-l1, result_stack, l4-l3) ;

    }
}
