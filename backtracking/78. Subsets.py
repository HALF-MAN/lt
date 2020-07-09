class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        track = []
        self.backtrack(nums, 0, track)
        return self.result
    def backtrack(self, nums, start, track):
        self.result.append(track[:])
        for i in range(start, len(nums)):
            track.append(nums[i])
            self.backtrack(nums, i + 1, track)
            track.pop()