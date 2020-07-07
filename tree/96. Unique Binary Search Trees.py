#这个单纯用递归方法会超时,加入mp缓存可以空间换时间勉强oj
class Solution:
    def numTrees(self, n: int) -> int:
        if n == 0:
            return 0
        self.count = 0
        self.mp = {}
        return  self.countBST(1, n)
    def countBST(self, start, end):
        if (start, end) in self.mp:
            return self.mp[(start, end)]
        if start > end:
            return 1
        result = 0
        for i in range(start, end + 1):
            left_count = self.countBST(start, i - 1)
            right_count = self.countBST(i + 1, end)
            result += left_count * right_count
        self.mp[(start, end)] = result
        return self.mp[(start, end)]
#这个是属于dp时间会快
# f[5] = f[0]*f[4] + f[1]*f[3] + f[2]*f[2] + f[3]*f[1] + f[4]*f[0], and in general:
# f[n] = f[0]*f[n-1] + f[1]*f[n-2] + ... + f[n-2]*f[1] + f[n-1]*f[0].
class Solution1:
    def numTrees(self, n: int) -> int:
        if n == 0 or n == 1:
            return 1
        if n == 2:
            return 2
        dp = [0] * (n + 1)
        dp[0]  = dp [1] = 1
        dp[2] = 2
        for i in range(3, n + 1):
            ans = 0
            left = 0
            right = i - 1
            while left <= i-1 and  right >= 0:
                ans += (dp[left]*dp[right])
                left += 1
                right -= 1
            dp[i] = ans
        return dp[-1]

if __name__ == "__main__":
    s = Solution1()
    print(s.numTrees(3))