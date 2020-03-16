import java.util.*;

public class Fish {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[] A = {4, 2, 1, 3, 5};
		int[] B = {0, 0, 0, 1, 0};
		int[] C = {3, 4, 2, 1, 5};
		int[] D = {1, 1, 1, 1, 0};
		int[] E = {4, 3, 1, 2, 5};
		int[] F = {0, 1, 0, 0, 0};
		
		System.out.	println(solution.solution(A, B));
		System.out.println(solution.solution(C, D));
		System.out.println(solution.solution(E, F));
	}
}

class Solution {
	public int solution(int[] A, int[] B) {

		Deque<Fish> fishes = new ArrayDeque<>();
		int N = A.length;
		
		for (int i = 0; i < N; i++) {
			Fish fish = new Fish(A[i], B[i]);
			while(!fishes.isEmpty() && against(fishes.peek(), fish)
					&& fish.value > fishes.peek().value) {
					fishes.pop();
			}
			if (fishes.isEmpty() || !against(fishes.peek(), fish)) {
				fishes.push(fish);
			}	

		}
		return fishes.size();
	}
	
	private boolean against(Fish first, Fish second) {
		return first.move == 1 && second.move == 0;
	}
	
	static class Fish {
		int value;
		int move;
		Fish(int value, int move) {
			this.value = value;
			this.move = move;
		}
	}
}
