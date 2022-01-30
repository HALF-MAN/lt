class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        length = len(nums)
        result = [0 for i in range(length)]
        stack = []
        for i in range(length * 2 - 1, -1, -1):
            while len(stack) > 0 and stack[-1] <= nums[i % length]:
                stack.pop(-1)
            result[i % length] = -1 if len(stack) <= 0 else stack[-1]
            stack.append(nums[i % length])
        return result
