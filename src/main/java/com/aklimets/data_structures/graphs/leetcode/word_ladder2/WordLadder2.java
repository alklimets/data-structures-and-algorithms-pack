package com.aklimets.data_structures.graphs.leetcode.word_ladder2;

import java.util.*;

public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> patterns = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                arr[i] = '*';
                String pattern = new String(arr);
                patterns.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<Pair<String, List<String>>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        visited.add(beginWord);
        queue.offer(new Pair<>(beginWord, new ArrayList<>()));
        boolean found = false;
        List<List<String>> result = new ArrayList<>();
        while (!queue.isEmpty() && !found) {
            Set<String> levelVisited = new HashSet<>();
            for (int ii = queue.size(); ii > 0; ii--) {
                Pair<String, List<String>> polled = queue.poll();
                String word = polled.getKey();
                List<String> path = polled.getValue();

                if (word.equals(endWord)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(word);
                    result.add(newPath);
                    found = true;
                }

                for (int i = 0; i < word.length(); i++) {
                    char[] arr = word.toCharArray();
                    arr[i] = '*';
                    String pattern = new String(arr);
                    for (String relative : patterns.getOrDefault(pattern, List.of())) {
                        if (!visited.contains(relative)) {
                            levelVisited.add(relative);

                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(word);
                            queue.offer(new Pair<>(relative, newPath));
                        }
                    }
                }
            }
            visited.addAll(levelVisited);
        }

        return result;
    }

    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(new WordLadder2().findLadders("hit", "cog", new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"))));
    }
}
