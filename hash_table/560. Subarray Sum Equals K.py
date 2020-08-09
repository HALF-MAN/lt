from typing import List
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        preSum = {}
        preSum[0] = 1
        result = 0
        sum_i = 0
        for i in range(len(nums)):
            sum_i += nums[i]
            sum_j = sum_i - k
            if sum_j in preSum:
                result += preSum[sum_j]
            preSum[sum_i] = 1 if sum_i not in preSum else preSum[sum_i] + 1
        return result
if __name__ == "__main__":
    s = Solution()
    s.subarraySum([1,1,1],2)