class Solution:
    #动态规划
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)
        i, j = m, n
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            dp[i][0] = i
        for j in range(1, n + 1):
            dp[0][j] = j
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
        return dp[m][n]
    #递归
    def minDistance1(self, word1: str, word2: str) -> int:
        def dp(i, j):
            if i == -1: return j + 1
            if j == -1: return i + 1

            if word1[i] == word2[j]:
                return dp(i - 1, j - 1)
            else:
                return min(dp(i, j-1) + 1,
                    dp(i-1, j) + 1,
                    dp(i-1, j-1) + 1
                )
        return dp(len(word1) -1 , len(word2) - 1)
    #带备忘录的递归
    def minDistance2(self, s1, s2) -> int:
        memo = dict() # 备忘录
        def dp(i, j):
            if i == -1: memo[(i, j)] =  j + 1
            if j == -1: memo[(i, j)] =  i + 1
            if (i, j) in memo: 
                return memo[(i, j)]
            if s1[i] == s2[j]:
                memo[(i, j)] = dp(i - 1, j - 1)  
            else:
                memo[(i, j)] = min(dp(i, j-1) + 1,
                        dp(i-1, j) + 1,
                        dp(i-1, j-1) + 1
                    )
            return memo[(i, j)]

        return dp(len(s1) - 1, len(s2) - 1)
if __name__ == "__main__":
    s1 = "horse"
    s2 = "ros"
    t = Solution()
    print(t.minDistance2(s1, s2))