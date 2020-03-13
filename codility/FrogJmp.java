import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(10, 85, 30));
	}
}

class Solution { 
	public int solution(int X, int Y, int D) {
		int dist = Y - X;
		if (dist % D == 0) {
			return dist / D;
		} else {
			return dist / D + 1;
		}
	} 
}

