package Word_Ladder_127;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
class Node {
    public int level;
    public boolean valid;
}
public class Solution {

    int minResult = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ladderLength2(beginWord, endWord, wordList, 1);
        if (minResult == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minResult;
        }
    }
    public void ladderLength2(String currentWord, String endWord, List<String> wordList, int level) {
        if (level > minResult) {
            return;
        }
        if (currentWord.equals(endWord)) {
            if (level < minResult) {
                minResult = level;
                return;
            }
        }
        for (String word : wordList) {
            if (differsByASingleLetter(word, currentWord)) {
                List<String> list = wordList.stream().filter(item->!item.equals(word)).collect(Collectors.toList());
                ++level;
                ladderLength2(word, endWord, list, level);
                --level;
            }
        }
    }
    public boolean differsByASingleLetter(String a, String b) {
        int diffCount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        if (diffCount != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");



        Solution solution = new Solution();
        solution.ladderLengt1(beginWord, endWord, wordList);
    }

    public int ladderLengt1(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach( word -> {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
