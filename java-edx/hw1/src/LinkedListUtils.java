
import java.util.LinkedList;
import java.util.*;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {

		if (null == list) {
			return;
		}

		if (list.isEmpty()) {
			list.add(value);
			return;
		}

		ListIterator<Integer> iterator = list.listIterator(0);
		int index = 0;
		while (iterator.hasNext()) {
			Integer el = iterator.next();
			if (value <= el) {
				list.add(index, value);
				return;
			}
			index++;
		}

		list.add(value);

	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {

		if (null == list || list.isEmpty() || N <= 0) {
			return;
		}

		List<String> strings = Arrays.asList(list.toArray(new String[0]));
		strings.sort((s1, s2) -> s2.compareTo(s1));

		int removed = 0;
		int index = 0;

		while (index < N) {
			if (removed < strings.size()) {
				String v = strings.get(removed);
				if (null != v) {
					while (list.remove(v)) {
						removed++;
					}
				}
			}
			index++;
		}

	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		if (null == one || one.isEmpty() || null == two || two.isEmpty()
				|| two.size() > one.size()) {
			return false;
		}

		int start = one.indexOf(two.getFirst());

		// No first element in common found, means no overlapping
		if (start == -1 ||  one.size() - start < two.size()) {
			return false;
		}

		for (int i = 0; i < two.size(); i++) {
			if (one.get(start + i) != two.get(i)) {
				return false;
			}
		}

		return true; // this line is here only so this code will compile if you don't modify it
	}
}
