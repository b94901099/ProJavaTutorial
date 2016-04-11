package array.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderI {
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {

		if (beginWord.equals(endWord) || beginWord == null || endWord == null) {
			return 0;
		}

		Queue<String> queue = new LinkedList<String>();
		Queue<Integer> distanceQueue = new LinkedList<Integer>();
		queue.offer(beginWord);
		distanceQueue.offer(1);

		while (!queue.isEmpty()) {
			String str = queue.poll();
			int ret = (int) distanceQueue.poll();
			for (int i = 0; i < str.length(); i++) {
				char[] strCharArr = str.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					strCharArr[i] = c;
					String newWord = new String(strCharArr);
					if (newWord.equals(endWord)) {
						return ret + 1;
					}
					if (wordList.contains(newWord)) {
						queue.offer(newWord);
						distanceQueue.offer(ret + 1);
						wordList.remove(newWord);
					}
				}
			}
		}
		return 0;

	}

	public static void main(String[] args) {
		WordLadderI w = new WordLadderI();
		Set<String> wordList = new HashSet();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");

		System.out.println(w.ladderLength("hit", "cog", wordList));
	}

}