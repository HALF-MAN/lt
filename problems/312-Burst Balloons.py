import sys
class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        point = []
        n = len(nums)
        point = [1 for _ in range(n+2)]
        for i in range(1,n + 1):
            point[i] = nums[i - 1]
        dp = [[0] * (n + 2) for _ in range(n + 2)]
        for i in range(n, -1, -1):
            for j in range(i + 1, n + 2):
                for k in range(i + 1, j):
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + point[i] * point[j] * point[k])
        return dp[0][n + 1]
    def maxCoins1(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = -1
        def backtrack(nums:[], score:int):
            nonlocal res
            if len(nums) == 0 :
                res = max(res, score)
                return
            for i in range(len(nums)):
                left = nums[i-1] if i - 1 >= 0 else 1
                right = nums[i+1] if i + 1 < len(nums) else 1
                point = left * nums[i] * right
                tmp = nums[i]
                del nums[i]
                backtrack(nums, score + point)
                nums.insert(i, tmp)
        backtrack(nums, 0)
        return res
        
if __name__ == "__main__":
    t = Solution()
    print(t.maxCoins([3,1,5,8]))