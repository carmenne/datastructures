import java.util.Random;
import java.util.function.Function;

public class BinaryRepresentation {
	
	String binary(int num) {
		
		if (num == 0) return "0";
		
		var binary = new StringBuilder();

		while (num != 0) {
			if ((num & 1) == 0) {
				binary.append(0);
			} else {
				binary.append(1);
			}
			num = num >>> 1;
		}
		
		return binary.reverse().toString();
	}
	
	String binaryOneComplement(int num) {
		
		var binary = new StringBuilder();
		if (num <= 0) num = ~(0 - num);

		while (num != 0) {
			if ((num & 1) == 0) {
				binary.append(0);
			} else {
				binary.append(1);
			}
			num = num >>> 1;
		}
		
		return binary.reverse().toString();
	}
	
	public static void main(String[] args) {
		var representation = new BinaryRepresentation(); 
		representation.testRandom(Integer::toBinaryString, representation::binary);
		representation.testEdge(Integer::toBinaryString, representation::binary);
		representation.testRandom(representation::oneComplementExpect, representation::binaryOneComplement);
		representation.testEdge(representation::oneComplementExpect,representation::binaryOneComplement);
	}
	
	private String oneComplementExpect(int num) {
	
		if (num > 0) return Integer.toBinaryString(num);
		return Integer.toBinaryString(num - 1);
	}
	
	private int generateRandomInt(int upperRange){
		Random random = new Random();
		return random.nextInt(upperRange);
	}
	
	private void testRandom(Function<Integer,String> expect,
						Function<Integer,String> transformation) {
			
		for (int i = 0; i < 100; i++) {
			
			var num = generateRandomInt(Integer.MAX_VALUE);
			testOne(num, expect, transformation);
			testOne(~num+1, expect, transformation);
	
		}	
	
	}
	
	private void testEdge(Function<Integer,String> expect,
					Function<Integer,String> transformation) {
						
		testOne(Integer.MIN_VALUE, expect, transformation);
		testOne(Integer.MIN_VALUE - 1, expect, transformation);
		testOne(Integer.MAX_VALUE, expect, transformation);
		testOne(0, expect, transformation);
		testOne(-1, expect, transformation);
		testOne(-2, expect, transformation);
	}
	
	private void testOne(int num, Function<Integer,String> expect, 
						Function<Integer,String> transformation) {
		if (!expect.apply(num).equals(transformation.apply(num))) {
			System.out.println("FALSE for " + num);
			System.out.println("EXPECTED " + expect.apply(num));
			System.out.println("ACTUAL   " + transformation.apply(num));
		} else {
			// System.out.println("TRUE for " + num);
		}
	}
	

}
