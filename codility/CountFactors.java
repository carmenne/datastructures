import java.util.Arrays;

public class CountFactors {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(24));
	}
}

class Solution { 
	public int solution(int N) {
		
		/*
		 There is a simple way to improve the above solution. Based on one divisor, we can find
			the symmetric divisor. More precisely, if number a is a divisor of n, 
			* then n/a is also a divisor.
			One of these two divisors is less than or equal to √
			n. (If that were not the case, n would be
			a product of two numbers greater than √
			n, which is impossible.)
		 */
		
		int count = 0;
		int M = (int) Math.sqrt(N);
		for (int i = 1; i <= M; i++) {
			if (N % i == 0) {
				count += 2; // add the simetrical divizor also
			}
		}
		
		if (M * M == N) count--; // if N is perfect square, radical was counted twice
		
		return count;
	} 
}
