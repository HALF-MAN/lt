package test;

public class P72 {

    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int a = solution.minDistance("horse", "ros");
            System.out.println();
        }

        //递归，O(n^2)，超时了
        int max = Integer.MAX_VALUE;

        public int minDistance(String word1, String word2) {
            return dfs(word1, 0, word2, 0);
        }

        public int dfs(String word1, int word1Index, String word2, int word2Index) {
            if (word1Index == word1.length()) {
                return word2.length() - word2Index;
            } else if (word2Index == word2.length()) {
                return word1.length() - word1Index;
            } else {
                if (word1.charAt(word1Index) == word2.charAt(word2Index)) {
                    return dfs(word1, word1Index + 1, word2, word2Index + 1); //相等直接跨过去
                } else {
                    int a = dfs(word1, word1Index, word2, word2Index + 1); //插入一个字符
                    int b = dfs(word1, word1Index + 1, word2, word2Index + 1); //替换一个字符
                    int c = dfs(word1, word1Index + 1, word2, word2Index); //删除一个字符
                    return Math.min(a, Math.min(b, c)) + 1;
                }
            }
        }

        public int minDistance1(String word1, String word2) {
            int n = word1.length();
            int m = word2.length();
            if (m * n==0) {
                return m + n;
            }
            int[][] dp = new int[n+1][m+1];

            for (int i = 0; i <= n; i++) {
                dp[i][0] = i;
            }

            for (int j = 0; j <= m; j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    }
                }
            }
            return dp[n][m];
        }
    }
}
