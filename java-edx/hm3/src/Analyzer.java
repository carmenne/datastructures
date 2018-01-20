import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		if (null == filename) {
			return Collections.emptyList();
		}

		List<Sentence> sentences = new ArrayList<>();
		File file = new File(filename);
		Path path = file.toPath();

		Pattern pattern = Pattern.compile("(-?[0-2])\\s(.*)", Pattern.CASE_INSENSITIVE);

		try (BufferedReader reader = Files.newBufferedReader(path)) {

			String line = null;
			while ((line = reader.readLine()) != null) {
				Matcher m = pattern.matcher(line);

				if (m.find() && m.groupCount() == 2) {

					String group = m.group(1);
					try {
						int score = Integer.parseInt(m.group(1));
						String text = m.group(2);
						Sentence sentence = new Sentence(score, text);
						sentences.add(sentence);
					} catch (NumberFormatException e) {
					}
				}
			}

		} catch (IOException e) {
			return Collections.emptyList();
		}

		return sentences; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {

		if (null == sentences || sentences.isEmpty()) {
			return Collections.emptySet();
		}

		List<Word> words = new ArrayList<>();
		Pattern start = Pattern.compile("^[a-z].*");

		sentences.forEach(
				(s) -> {
					if (null != s) {
						String[] tokens = s.text.split("\\s");

						for (String token : tokens) {
							token = token.toLowerCase();
							if (start.matcher(token).find()) {


								Word word = new Word(token);

								if (words.contains(word)) {
									words.get(words.indexOf(word)).increaseTotal(s.getScore());
								} else {
									word.increaseTotal(s.getScore());
									words.add(word);
								}
							}
						}
					}
				}
		);

		return words.stream() .collect(Collectors.toSet());

	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		if (null == words || words.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<String, Double> scores = new HashMap<>();

		words.forEach((w) ->
		{
			if (null != w && null != w.getText()) {
				scores.put(w.getText(), w.calculateScore());
			}
		});

		return scores; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		if (wordScores == null || wordScores.isEmpty() || sentence == null ||
				sentence.isEmpty()) {
			return 0;
		}

		String tokens[] = sentence.split("\\s");

		if (tokens.length == 0) {
			return 0;
		}

		double scores = 0;
		int count = 0;
		Pattern start = Pattern.compile("^[a-z].*");

		for(String token: tokens) {
			token = token.toLowerCase();
			if (null != token && start.matcher(token).find()) {

				if (wordScores.containsKey(token)) {
					scores += wordScores.get(token);
				}

				count++;
			}
		}

		if (count == 0) {
			return 0;
		}

		return scores/count; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
