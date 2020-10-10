import sys
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxSum = nums[0]
        tmpSum = nums[0]
        for i in range(1,len(nums)):
            tmpSum = max(tmpSum + nums[i], nums[i])
            maxSum = max(maxSum, tmpSum)
        return maxSum