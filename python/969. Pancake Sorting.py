from typing import List
import sys
class Solution:
    def pancakeSort(self, A: List[int]) -> List[int]:
        result = []
        self.pancake(A, len(A),result)
        return result
    def pancake(self, arr, n, result):
        if n <= 0:
            return
        maxIndex = 0
        maxVal = -sys.maxsize - 1
        for i in range(n):
            if arr[i] > maxVal:
                maxVal = arr[i]
                maxIndex = i
        self.reverse(arr, 0, maxIndex)
        result.append(maxIndex + 1)
        self.reverse(arr, 0, n - 1)
        result.append(n)
        self.pancake(arr, n - 1, result)
    
    def reverse(self, arr, start, end):
        while start < end:
            arr[start], arr[end] = arr[end], arr[start]
            start += 1
            end -= 1
if __name__ == "__main__":
    s = Solution()
    res = s.pancakeSort([3,2,4,1])
    print(res)