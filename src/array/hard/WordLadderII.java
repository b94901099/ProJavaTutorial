package array.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

	class StringWithLevel {
		String str;
		int level;

		public StringWithLevel(String str, int level) {
			this.str = str;
			this.level = level;
		}
	}

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> res = new ArrayList();
		Set<String> unvisitedSet = new HashSet<String>();
		unvisitedSet.addAll(dict);
		unvisitedSet.add(start);
		unvisitedSet.remove(end);
		Map<String, List<String>> nextMap = new HashMap<String, List<String>>();
		for (String e : unvisitedSet) {
			nextMap.put(e, new ArrayList<String>());
		}
		LinkedList<StringWithLevel> queue = new LinkedList<StringWithLevel>();
		queue.add(new StringWithLevel(end, 0));
		boolean found = false;
		int finalLevel = Integer.MAX_VALUE;
		int curLevel = 0;
		int preLevel = 0;
		HashSet<String> visitedCurLevel = new HashSet<String>();
		while (!queue.isEmpty()) {
			StringWithLevel cur = queue.poll();
			String curStr = cur.str;
			curLevel = cur.level;
			if (found && curLevel > finalLevel) {
				break;
			}
			if (curLevel > preLevel) {
				unvisitedSet.removeAll(visitedCurLevel);
			}
			preLevel = curLevel;
			char[] curStrCharArray = curStr.toCharArray();
			for (int i = 0; i < curStr.length(); ++i) {
				char originalChar = curStrCharArray[i];
				boolean foundCurCycle = false;
				for (char c = 'a'; c <= 'z'; ++c) {
					curStrCharArray[i] = c;
					String newStr = new String(curStrCharArray);
					if (c != originalChar && unvisitedSet.contains(newStr)) {
						nextMap.get(newStr).add(curStr);
						if (newStr.equals(start)) {
							found = true;
							finalLevel = curLevel;
							foundCurCycle = true;
							break;
						}
						if (visitedCurLevel.add(newStr)) {
							queue.add(new StringWithLevel(newStr, curLevel + 1));
						}
					}
				}
				if (foundCurCycle) {
					break;
				}
				curStrCharArray[i] = originalChar;
			}
		}
		if (found) {
			List<String> list = new ArrayList<String>();
			list.add(start);
			getPaths(start, end, list, finalLevel + 1, nextMap, res);
		}
		return res;
	}

	private void getPaths(String cur, String end, List<String> list, int level,
			Map<String, List<String>> nextMap, List<List<String>> res) {
		if (cur.equals(end)) {
			res.add(new ArrayList<String>(list));
		} else if (level > 0) {
			List<String> parentsSet = nextMap.get(cur);
			for (String parent : parentsSet) {
				list.add(parent);
				getPaths(parent, end, list, level - 1, nextMap, res);
				list.remove(list.size() - 1);
			}
		}
	}

	private class WordNode3 {
		String word;
		int step;
		WordNode3 pre;
		Set<String> visited;

		public WordNode3(String word, int step, WordNode3 pre,
				Set<String> visited) {
			super();
			this.word = word;
			this.step = step;
			this.pre = pre;
			this.visited = visited;
		}
	}

	public List<List<String>> findLadders3(String beginWord, String endWord,
			Set<String> wordList) {
		List<List<String>> result = new ArrayList();

		if (beginWord.equals(endWord))
			return result;

		wordList.add(beginWord);
		wordList.add(endWord);

		Set<String> visited = new HashSet<String>();
		visited.add(endWord);
		Queue<WordNode3> queue = new LinkedList<WordNode3>();
		WordNode3 endNode = new WordNode3(endWord, 1, null, visited);
		queue.offer(endNode);

		while (!queue.isEmpty()) {
			WordNode3 node = queue.poll();
			String word = node.word;
			int step = node.step;
			Set<String> nodeVisited = node.visited;
			if (word.equals(beginWord)) {
				List<String> solution = new ArrayList<String>();
				while (node != null) {
					solution.add(node.word);
					node = node.pre;
				}
				result.add(solution);
			} else {
				for (int i = 0; i < word.length(); i++) {
					char[] wordArr = word.toCharArray();
					char originalChar = wordArr[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == originalChar)
							continue;
						wordArr[i] = c;
						String newWord = new String(wordArr);
						if (wordList.contains(newWord)
								&& !nodeVisited.contains(newWord)) {
							Set<String> newNodeVisited = new HashSet<String>(
									nodeVisited);
							newNodeVisited.add(newWord);
							WordNode3 newNode = new WordNode3(newWord,
									step + 1, node, newNodeVisited);
							queue.offer(newNode);
						}
					}
				}
			}
		}

		if (result.size() == 0)
			return result;

		int minLength = result.get(0).size();
		for (int i = 1; i < result.size(); i++) {
			if (result.get(i).size() < minLength)
				minLength = result.get(i).size();
		}

		List<List<String>> shortestResult = new ArrayList();
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).size() == minLength)
				shortestResult.add(result.get(i));
		}
		return shortestResult;
	}

	public List<List<String>> findLadders2(String beginWord, String endWord,
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

		// Set<String> wordList = new HashSet();
		// wordList.add("hot");
		// wordList.add("dot");
		// wordList.add("dog");
		// wordList.add("lot");
		// wordList.add("log");
		// String beginWord = "hit";
		// String endWord = "cog";

		String beginWord = "qa";
		String endWord = "sq";
		String[] tmp = { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb",
				"sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca",
				"br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya",
				"cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur",
				"rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if",
				"pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha",
				"hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm",
				"an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn",
				"mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni",
				"mr", "pa", "he", "lr", "sq", "ye" };

		Set<String> wordList = new HashSet<String>();
		for (String s : tmp)
			wordList.add(s);

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
