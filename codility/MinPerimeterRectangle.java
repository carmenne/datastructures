import java.util.Arrays;

public class MinPerimeterRectangle {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(30));
	}
}

class Solution { 
	public int solution(int N) {
		int M = (int) Math.sqrt(N);
	
		for (int i = M; i > 0; i--) {
			if (N % i == 0) {
				return (i + N/i) * 2;
			}
		}
		
		return -1;
		
	}
}
