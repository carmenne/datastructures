public class BinaryRepresentation {
	
	String binary(int num) {
		String binary = "";
		long big_num = 0;
		if (num == 0) return "0";
		else if (num<0) big_num = (long) Math.pow(2, 32) - Math.abs((long) num);
		else big_num = num;
		while (big_num > 0) {
			if (big_num % 2 == 0) {
				binary = 0 + binary;
			} else {
				binary = 1 + binary;
			}
			big_num /= 2;
		}
		return binary;
	}

	void testNeg() {
		for (long i = Integer.MIN_VALUE; i<0; i /= 2) {
			if (!Integer.toBinaryString((int) i).equals(binary((int) i))) {
				System.out.println("FALSE for " + i);
			} else {
				System.out.println("TRUE for " + i);
			}
		}
	}

	void testPos() {
		for (long i = 1; i<= Integer.MAX_VALUE; i *= 2) {
			if (!Integer.toBinaryString((int) i).equals(binary((int) i))) {
				System.out.println("FALSE for " + i);
			} else {
				System.out.println("TRUE for " + i);
			}
		}
	}

	void testEdge() {
		boolean test = Integer.toBinaryString(Integer.MIN_VALUE).equals(binary(Integer.MIN_VALUE)) &&
			Integer.toBinaryString(Integer.MIN_VALUE - 1).equals(binary(Integer.MIN_VALUE - 1)) &&
			Integer.toBinaryString(Integer.MAX_VALUE + 1).equals(binary(Integer.MAX_VALUE + 1)) &&
			Integer.toBinaryString(0).equals(binary(0)) &&
			Integer.toBinaryString(-1).equals(binary(-1));

		if (!test) System.out.println("FAIL");
	}
	
	public static void main(String[] args) {
		var representation = new BinaryRepresentation(); 
		representation.testNeg();
		representation.testPos();
		representation.testEdge();
	}
}
