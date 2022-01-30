class Solution:
    def change(self, amount: int, coins) -> int:
        n = len(coins)
        dp = [[0 for _ in range(amount + 1)] for _ in range(n + 1)]
        for i in range(n + 1):
            dp[i][0] = 1
        for i in range(1, n+1):
            for j in range(1, amount+1):
                if j - coins[i-1] >= 0:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]] 
                else:
                    dp[i][j] = dp[i-1][j]
        return dp[n][amount]
    def change2(self, amount: int, coins) -> int:
        n = len(coins)
        dp = [0 for _ in range(amount + 1)]
        dp[0] = 1
        for i in range(n):
            for j in range(1, amount+1):
                if j - coins[i] >= 0:
                    dp[j] = dp[j] + dp[j-coins[i]]
        return dp[amount]
if __name__ == "__main__":
    t = Solution()
    print(t.change2(5, [1,2,5]))
    