package array.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord,
			Set<String> wordList) {
		List<List<String>> solutions = new ArrayList<List<String>>();
		if (beginWord.equals(endWord))
			return solutions;

		Queue<String> intermediateWordQueue = new LinkedList<String>();
		Queue<Integer> distanceQueue = new LinkedList<Integer>();
		Queue<List<String>> tmpWordListQueue = new LinkedList<List<String>>();

		intermediateWordQueue.offer(beginWord);
		distanceQueue.offer(1);
		List<String> list = new ArrayList<String>();
		list.add(beginWord);
		tmpWordListQueue.offer(list);

		while (!intermediateWordQueue.isEmpty()) {
			String word = intermediateWordQueue.poll();
			int distance = distanceQueue.poll();
			List<String> tmpWordList = tmpWordListQueue.poll();

			for (int i = 0; i < word.length(); i++) {
				char[] strArr = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					if (strArr[i] == c) {
						continue;
					}
					strArr[i] = c;
					String newWord = new String(strArr);
					if (newWord.equals(endWord)) {
						List<String> newWordList = new ArrayList(tmpWordList);
						newWordList.add(newWord);
						solutions.add(newWordList);
					} else if (wordList.contains(newWord)) {
						intermediateWordQueue.offer(newWord);
						distanceQueue.offer(distance + 1);
						List<String> newWordList = new ArrayList(tmpWordList);
						newWordList.add(newWord);
						tmpWordListQueue.offer(tmpWordList);
						wordList.remove(newWord);
					}
				}
			}
		}

		if (solutions.size() == 0)
			return solutions;

		int shortestWordListLength = solutions.get(0).size();
		for (int i = 0; i < solutions.size(); i++) {
			if (shortestWordListLength > solutions.get(i).size())
				shortestWordListLength = solutions.get(i).size();
		}

		List<List<String>> shortestSolutions = new ArrayList<List<String>>();

		for (int i = 0; i < solutions.size(); i++) {
			if (shortestWordListLength == solutions.get(i).size())
				shortestSolutions.add(solutions.get(i));
		}

		return shortestSolutions;
	}

	public static void main(String[] args) {
		WordLadderII w = new WordLadderII();

		Set<String> wordList = new HashSet();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		String beginWord = "hit";
		String endWord = "cog";

		// String beginWord = "qa";
		// String endWord = "sq";
		// String[] tmp = { "si", "go", "se", "cm", "so", "ph", "mt", "db",
		// "mb",
		// "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca",
		// "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya",
		// "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur",
		// "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if",
		// "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha",
		// "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm",
		// "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn",
		// "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni",
		// "mr", "pa", "he", "lr", "sq", "ye" };
		//
		// Set<String> wordList = new HashSet<String>();
		// for (String s : tmp)
		// wordList.add(s);

		// wordList.add("a");
		// wordList.add("b");
		// wordList.add("c");
		// String beginWord = "a";
		// String endWord = "c";

		List<List<String>> shortestSolutions = w.findLadders(beginWord,
				endWord, wordList);

		for (List<String> list : shortestSolutions) {
			for (String word : list) {
				System.out.print(word + ", ");
			}
			System.out.println();
		}

	}
}
