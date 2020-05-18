class Solution:
    def lengthOfLIS(self, nums) -> int:
        dp = []
        i = 0
        while i < len(nums):
            dp.append(1)
            i += 1
        i = 0
        while i < len(nums):
            j = 0
            while j < i:
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
                j += 1
            i += 1
        res = 0
        for v in dp:
            res = max(res, v)
        return res
            
if __name__ == "__main__":
    t = Solution()
    d = t.lengthOfLIS([10,9,2,5,3,7,101,18])
    print(d)
