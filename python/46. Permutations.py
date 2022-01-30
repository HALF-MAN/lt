from typing import List
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.list = []
        self.backtrack(nums)
        return self.result
    def backtrack(self, nums):
        if len(nums) == len(self.list):
            self.result.append(self.list[:])

        for i in range(len(nums)):
            if nums[i] in self.list:
                continue
            self.list.append(nums[i])
            self.backtrack(nums)
            self.list.pop()