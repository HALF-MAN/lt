class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        res, mp = 0, [0] * 101
        for num in nums:
            res += mp[num]
            mp[num] += 1
        return res