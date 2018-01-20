/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.*;

public class MovieRatingsParser {

    public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {

        TreeMap<String, PriorityQueue<Integer>> parsedRatings = new TreeMap<>();

        if (null == allUsersRatings || allUsersRatings.isEmpty()) {
            return parsedRatings;
        }

        for (UserMovieRating rating : allUsersRatings) {

            if (null != rating &&
                    null != rating.getMovie() &&
                    !rating.getMovie().isEmpty() &&
                    rating.getUserRating() >= 0) {

                String title = rating.getMovie().toLowerCase();

                if (parsedRatings.containsKey(title)) {

                    parsedRatings.get(title).add(rating.getUserRating());

                } else {

                    PriorityQueue<Integer> orderedRatings = new PriorityQueue<>();
                    orderedRatings.add(rating.getUserRating());
                    parsedRatings.put(title, orderedRatings);
                }
            }

        }

        return parsedRatings;
    }

}
