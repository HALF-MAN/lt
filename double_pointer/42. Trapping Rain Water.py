class Solution:
    def trap(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        res = 0
        while l < r:
            mn = min(height[l], height[r])
            if mn == height[l]:
                l += 1
                while l < r and height[l] < mn:
                    res += mn - height[l]
                    l += 1
            else:
                r -= 1
                while l < r and height[r] < mn:
                    res += mn - height[r]
                    r -= 1
        return res