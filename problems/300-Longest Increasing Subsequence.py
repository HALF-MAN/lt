class Solution:
    def lengthOfLIS(self, nums) -> int:
        if nums==[]:
            return 0
        dp = [1 for i in range(len(nums))]
        for i in range(len(nums)):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)
            
if __name__ == "__main__":
    t = Solution()
    d = t.lengthOfLIS([10,9,2,5,3,7,101,18])
    print(d)
