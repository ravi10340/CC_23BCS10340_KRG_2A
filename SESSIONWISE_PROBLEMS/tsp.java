import java.util.*;

class TravellingSalesman{
    static int[][] dp;

    public static int tsp(int[][] graph) {
        int n = graph.length;
        dp = new int[1 << n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(graph, 1, 0);
    }

    private static int solve(int[][] graph, int mask, int pos) {
        int n = graph.length;

        if (mask == (1 << n) - 1) {
            return graph[pos][0];
        }

        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int ans = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = graph[pos][city] + solve(graph, mask | (1 << city), city);
                ans = Math.min(ans, newAns);
            }
        }

        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println(tsp(graph));
    }
}
