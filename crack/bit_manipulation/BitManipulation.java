import java.util.ArrayList;
public class BitManipulation {
	
	int flip(int num) {
		
		if (num == 0) return 1;
		
		var offsets = new ArrayList<Integer>();
		int offset = 0;
		offsets.add(offset);
		
		while (num != 0) {
			
			if ((num & 1) == 0) {
				offsets.add(offset);
			}
			offset++;
			num = num >>> 1;
			
		}
		offsets.add(offset-1);
				
		var max = 0;
		
		if (offsets.size() == 2) {
			max = offset == 32 ? offset : offset + 1;
		} else {
			for (int i = 1; i < offsets.size() - 1; i++) {
				int val = offsets.get(i+1) - offsets.get(i-1);
				if (val > max) max = val;
			}
		}
		return max;
		
	}
	
	public static void main(String[] args) {
		
		var transform = new BitManipulation();
		transform.testOne(0, 1, transform.flip(0));
		transform.testOne(1775, 8, transform.flip(1775));
		transform.testOne(12, 3, transform.flip(12));
		transform.testOne(15, 5, transform.flip(15));
		transform.testOne(71, 4, transform.flip(71));
		transform.testOne(-1, 32, transform.flip(-1));
		transform.testOne(Integer.MAX_VALUE, 32, transform.flip(Integer.MAX_VALUE));
		transform.testOne(Integer.MIN_VALUE, 2, transform.flip(Integer.MIN_VALUE));
	}
	
	private void testOne(int num, int expect, int actual) {
		if (!(expect == actual)) {
			System.out.println("FALSE for " + num);
			System.out.println("EXPECTED " + expect);
			System.out.println("ACTUAL   " + actual);
		} else {
			// System.out.println("TRUE for " + num);
		}
	}
}
