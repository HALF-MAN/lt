import sys
class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = -1
        def backtrack(nums:[], score:int):
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