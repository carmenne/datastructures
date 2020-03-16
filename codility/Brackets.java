import java.util.*;

public class Brackets {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String S = "([)()]";
		System.out.println(solution.solution(S));
		System.out.println(solution.solution("{[()()]}"));
	}
}

class Solution {
	public int solution(String S) {
		
		Deque<Character> brackets = new ArrayDeque<>();
		
		for (char s : S.toCharArray()) {
			if (s == '{' || s == '[' || s == '(') {
				brackets.push(s);
			} else {
				char t = brackets.peek();
				if (t == null) return 0;
				if (pair(s, t)) {
					brackets.pop();
				}
			}
		}
		
		return brackets.isEmpty() ? 1 : 0;
	}
	
	private boolean pair(char s, char t) {
		return s == '}' && t == '{' || s == ']' && t == '[' || s == ')' && t == '(' ;
	}
}
