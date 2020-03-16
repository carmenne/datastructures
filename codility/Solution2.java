import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class Solution2 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int N = 4;
		String S = "1B 2C,2D 4D";
		String T = "2B 2D 3D 4D 4A";
		System.out.println(solution.solution(N, S, T));
	}
}

class Solution {
	public String solution(int N, String S, String T) {
		
		Set<String> hits = new HashSet<>(Arrays.asList(T.split(" ")));
		int sunk = 0;
		int hit = 0;

		for (String ship : S.split(",")) {
			char leftTopRow = ship.charAt(0);
			char leftTopColumn= ship.charAt(1);
			char rightBottomRow = ship.charAt(3);
			char rightBottomColummn = ship.charAt(4);
		} 
		
		
		return sunk + "," + hit;
	}
}
