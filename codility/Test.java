public class Test {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(529));
	}
}

class Solution {
    public int solution(int N) {
        int max = 0;
        int curr = 0;
        N >>= Integer.numberOfTrailingZeros(N);
        for (; N != 0; N >>= 1) {
			if ((N & 1) == 0) {
                ++curr;
            } else {
                if (curr > max) {
                    max = curr;
                }
                curr = 0;
            }
		}
        return max;
    }
}
