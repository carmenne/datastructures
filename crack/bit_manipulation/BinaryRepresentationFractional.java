import java.util.Random;
import java.util.function.Function;

public class BinaryRepresentationFractional {
	
		
	String binary(double num) {
		
		if (num >= 1.0d) return "ERROR";
		if (num < 0.0d) return "ERROR";
		if (num == 0.0d) return "0";
		
		var binary = new StringBuilder();

		while (num != 0.0d) {
			num *= 2;
			if ((int)num == 0) {
				binary.append(0);
			} else {
				binary.append(1);
				num -= 1;
			}
			if (binary.length() > 32) return "ERROR";
		}
		
		return binary.toString();
	}

	
	
	public static void main(String[] args) {
		var representation = new BinaryRepresentationFractional();
		representation.testEdge(representation::binary);
	
	}
	
	private void testEdge(Function<Double,String> transformation) {
						
		testOne(0, "0", transformation);
		testOne(0.72, "ERROR", transformation);
		testOne(0.625, "101", transformation);
		testOne(0.1, "ERROR", transformation);
		testOne(0.76, "ERROR", transformation);
		testOne(0.87, "ERROR", transformation);
		testOne(0.107, "ERROR", transformation);
		testOne(0.125, "001", transformation);
		testOne(0.6875, "1011", transformation);
	}
	
	
	private void testOne(double num,  String expect, 
						Function<Double,String> transformation) {
		if (!expect.equals(transformation.apply(num))) {
			System.out.println("FALSE for " + num);
			System.out.println("EXPECTED " + expect);
			System.out.println("ACTUAL   " + transformation.apply(num));
		} else {
			// System.out.println("TRUE for " + num);
		}
	}
}
