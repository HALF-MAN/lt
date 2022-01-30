# 旋转的数组二分查找

class Solution:
    def binarySearch(self, nums:[], target:int):
        left = 0
        right = len(nums) - 1
        lenth = len(nums)
        while (left <= right):
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                if nums[mid] <= nums[lenth - 1] and target > nums[lenth - 1]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if target <= nums[lenth - 1]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1

if __name__ == "__main__":
    t = Solution()
    print(t.binarySearch([3,4,5,1,2], 4))