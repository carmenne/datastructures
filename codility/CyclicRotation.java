import java.util.Arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {3, 8, 9, 7, 6};
		int K = 3;
		System.out.println(Arrays.toString(solution.solution(A, K)));
	}
}

class Solution {
    public int[] solution(int[] A, int K) {
        int N = A.length;
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[(i + K) % N] = A[i]; 
        }
        return B;
    }
}
