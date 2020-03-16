import java.util.*;

public class StoneWall {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {8, 8, 5, 7, 9, 8, 7, 4, 8};
		System.out.println(solution.solution(A));
	}
}

class Solution {
	public int solution(int[] A) {
		Deque<Integer> walls = new ArrayDeque<>();
		int N = A.length;
		int count = 0;

		for (int i = 0; i < N; i++) {

			while (!walls.isEmpty() && A[i] <= walls.peek()) {
				if (walls.pop() > A[i]) {
					count++;
				}
			}

			walls.push(A[i]);
		}
		
		return count + walls.size();
	}
}
