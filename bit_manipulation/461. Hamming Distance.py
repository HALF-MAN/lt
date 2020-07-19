class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        b = x ^ y
        res = 0
        while b != 0:
            b = b & (b-1)
            res += 1
        return res