import java.util.Arrays;

public class ChocolatesByNumbers {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(10, 4));
	}
}

class Solution { 
	public int solution(int N, int M) {
		return N / gcd(N, M);
	}
	
	// a > b
	private int gcd(int a, int b) {
		if (a % b == 0) return b;
		return gcd(b, a % b);
	}
	
}
