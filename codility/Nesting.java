import java.util.*;

public class Brackets {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String S = "(()(())())";
		System.out.println(solution.solution(S));
		System.out.println(solution.solution("())"));
		System.out.println(solution.solution("))(("));
	}
}

class Solution {
	public int solution(String S) {
		Deque<Character> brackets = new ArrayDeque<>();
		
		for (char s : S.toCharArray()) {
			if (s == '(') {
				brackets.push(s);
			} else {
				if (brackets.isEmpty()) {
					return 0;
				}
				brackets.pop();
			}
		}	
		
		return brackets.size() == 0 ? 1 : 0;
	}
}
