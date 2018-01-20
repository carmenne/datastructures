/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;
import java.util.stream.Collectors;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		if (null == movieRatings || movieRatings.isEmpty()) {
			return Collections.emptyList();
		}

		return movieRatings.keySet().stream().collect(Collectors.toList());
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {

		if (null == movieRatings || movieRatings.isEmpty()) {
			return Collections.emptyList();
		}

		return movieRatings.entrySet().stream().filter(
				r -> r.getValue().peek() > rating
		).map(m->m.getKey()).sorted().collect(Collectors.toList());
	}

	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {

		TreeMap<String, Integer> removed = new TreeMap<>();
		Set<String> titlesToRemove = new HashSet<>();

		if (null == movieRatings || movieRatings.isEmpty()) {
			return removed;
		}


		for (String title:  movieRatings.keySet()) {

			PriorityQueue<Integer> ratings = movieRatings.get(title);
			if (ratings.peek() < rating) {
				int count = 0;

				while (ratings.peek() != null &&
						ratings.peek() < rating) {
					ratings.poll();
					count++;
				}

				if (null == ratings.peek()) {
					titlesToRemove.add(title);
				}

				removed.put(title, count);
			}
		}

		for(String t: titlesToRemove) {
			movieRatings.remove(t);
		}

		return removed;
	}
}
