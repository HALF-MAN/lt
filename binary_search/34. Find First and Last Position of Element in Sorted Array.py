class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        result = []
        result.append(self.find(nums, target, True))
        result.append(self.find(nums, target, False))
        return result
    def find(self, nums, target, needFirst):
        index = -1
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2

            if target < nums[mid] or (target == nums[mid] and needFirst): 
                right = mid - 1
            else:
                left = mid + 1
            if nums[mid] == target:
                index = mid
        return index