import java.util.*;

public class Brackets {
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
		fishes.addFirst(new Fish(A[0], B[0]));
			
		int N = A.length;
		
		for (int i = 1; i < N; i++) {
		Fish newFish = new Fish(A[i], B[i]);
			Fish oldFish = fishes.peekFirst();
			while(!fishes.isEmpty() && against(oldFish, newFish)) {
				if (newFish.value > oldFish.value) {
					fishes.removeFirst();
					oldFish = fishes.peekFirst();
				} else {
					break; // newFish is eaten
				}
			}
				
			if (fishes.isEmpty() || !against(oldFish, newFish)) {
				fishes.addFirst(newFish);
			}
		}
		return fishes.size();
	}
	
	private boolean against(Fish oldFish, Fish newFish) {
		return oldFish.move == 1 &&	newFish.move == 0;
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
