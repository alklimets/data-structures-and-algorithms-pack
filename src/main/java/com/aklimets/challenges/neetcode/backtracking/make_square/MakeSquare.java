package com.aklimets.challenges.neetcode.backtracking.make_square;

public class MakeSquare {

    /*
        You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
        Return true if you can make this square and false otherwise.

        Example 1:

        Input: matchsticks = [1,1,2,2,2]
        Output: true
        Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
        Example 2:

        Input: matchsticks = [3,3,3,3,4]
        Output: false
        Explanation: You cannot find a way to form a square with all the matchsticks.

        Constraints:

        1 <= matchsticks.length <= 15
        1 <= matchsticks[i] <= 10^8
    */

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int match : matchsticks) {
            sum += match;
        }
        if (sum % 4 > 0) return false;
        return dfs(matchsticks, 0, 0, 0, sum / 4, new boolean[matchsticks.length]);
    }

    private boolean dfs(int[] matchsticks, int sum, int used, int start, int target, boolean[] visited) {
        if (used == matchsticks.length) return true;

        if (sum == target) {
            return dfs(matchsticks, 0, used, 0, target, visited);
        }

        for (int i = start; i < matchsticks.length; i++) {
            if (visited[i]) continue;
            if (sum + matchsticks[i] > target) continue;

            sum += matchsticks[i];
            visited[i] = true;
            used++;
            if (dfs(matchsticks, sum, used, i + 1, target, visited)) return true;
            sum -= matchsticks[i];
            visited[i] = false;
            used--;
            while (i + 1 < matchsticks.length && matchsticks[i] == matchsticks[i + 1]) i++;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(new MakeSquare().makesquare(new int[]{2, 2, 2, 1, 1}));
        System.out.println(new MakeSquare().makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 4, 2}));
    }
}
