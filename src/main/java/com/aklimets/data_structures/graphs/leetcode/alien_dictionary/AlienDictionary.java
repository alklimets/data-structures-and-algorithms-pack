package com.aklimets.data_structures.graphs.leetcode.alien_dictionary;

import java.util.*;

public class AlienDictionary {

    public String solution(List<String> words) {
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        Set<Character> characterSet = new HashSet<>();

        for (int i = 0; i < words.size() - 1; i++) {
            String current = words.get(i);
            String next = words.get(i + 1);

            if (current.startsWith(next) && current.length() > next.length()) return "";

            char[] currentChars = current.toCharArray();
            char[] nextChars = next.toCharArray();
            for (int j = 0; j < Math.min(current.length(), next.length()); j++) {
                if (currentChars[j] != nextChars[j]) {
                    indegree.compute(nextChars[j], (k, v) -> v == null ? 1 : v + 1);
                    graph.computeIfAbsent(currentChars[j], v -> new ArrayList<>()).add(nextChars[j]);
                    break;
                }
            }

            for (char ch : currentChars) {
                characterSet.add(ch);
            }

            for (char ch : nextChars) {
                characterSet.add(ch);
            }
        }

        for (char ch : characterSet) {
            indegree.putIfAbsent(ch, 0);
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        String res = "";
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            res += ch;
            for (char relative : graph.getOrDefault(ch, List.of())) {
                indegree.compute(relative, (k, v) -> v - 1);
                if (indegree.get(relative) == 0) {
                    queue.offer(relative);
                }
            }
        }

        return res.length() == characterSet.size() ? res : "";
    }

    public static void main(String[] args) {
        System.out.println(new AlienDictionary().solution(List.of("wrt", "wrf", "er", "ett", "rftt")));
        System.out.println(new AlienDictionary().solution(List.of("abc", "abd", "ddd", "ccc")));
    }
}
