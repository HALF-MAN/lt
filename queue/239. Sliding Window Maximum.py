from collections import deque
class Solution:
    def maxSlidingWindow(self, nums, k):
        q = deque()
        result = []
        for i in range(len(nums)):
            if i < k - 1 :
                while len(q) > 0 and nums[i] > q[-1]:
                    q.pop()
                q.append(nums[i])
            else :
                # push right
                while len(q) > 0 and nums[i] > q[-1]:
                    q.pop()
                q.append(nums[i])
                result.append(q[0])
                # remove left
                if len(q) > 0 and nums[i - k + 1] == q[0]:
                    q.popleft()
        return result
if __name__ == "__main__":
    s = Solution()
    print(s.maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3))