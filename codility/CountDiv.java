import java.util.*;

public class CountDiv {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(6, 11, 2));
		System.out.println(solution.solution(0, 2, 2));
		System.out.println(solution.solution(0, 0, 2));
		System.out.println(solution.solution(6, 12, 2));
		System.out.println(solution.solution(11, 345, 17));
		System.out.println(solution.solution(1, 2_000_000, 1));
		System.out.println(solution.solution(0, 2_000_000, 1));
		System.out.println(solution.solution(0, 2_000_000, 2_000_000));
		System.out.println(solution.solution(10, 10, 5));
		System.out.println(solution.solution(10, 10, 7));
		System.out.println(solution.solution(5, 10, 5));
		System.out.println(solution.solution(1, 3, 2));
		System.out.println(solution.solution(1, 11, 3));
		
		for (int i = 1; i < 21; i++) {
			System.out.println(i + ":" + 17*i);
		} 
	}
}

class Solution {
	public int solution(int A, int B, int K) {
		
		if (A % K != 0)
			A += K - A % K;
		if (B % K != 0)
			B -= B % K;
		
		if (A > B)
			return 0;
		else
			return (B - A) / K + 1;
		
	}
}
