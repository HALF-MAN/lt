class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        s = sum(nums)
        if s % 2 != 0:
            return False
        s = int(s / 2)
        dp = [[False for _ in range(s + 1)] for _ in range(len(nums) + 1)]
        for i in range(0 , len(nums) + 1):
            dp[i][0] = True
        for i in range(1, len(nums) + 1):
            for j in range(1, s + 1):
                if j - nums[i-1] < 0:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] or dp[i-1][j - nums[i-1]]
        return dp[len(nums)][s]
if __name__ == "__main__":
    t = Solution()
    print(t.canPartition([1,2,3,4,5,5]))
    